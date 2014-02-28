package jp.procon.healthgame;


import java.util.List;

import android.app.AlarmManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class HomeActivity extends FragmentActivity implements SensorEventListener{
	private Acceleration acceleration = new Acceleration();
	private StepCount stepcount = new StepCount();
	private SensorManager smanager;
	private Sensor accelerometer;
	private Bundle homebdl = new Bundle();
	private Bundle exbdl = new Bundle();
	private SQLiteDatabase sdb;
	private MyData myData = new MyData();


	
	private int step = -1;
	FragmentManager fm = getSupportFragmentManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home);
		
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		String name = sharedPref.getString("user_name", "unknown");
		String h = sharedPref.getString("user_height", "0");
		String w = sharedPref.getString("user_weight", "0");
		int height = Integer.parseInt(h);
		int weight = Integer.parseInt(w);
		String la = sharedPref.getString("list_preference", "-1");
		int lifeArmor = Integer.parseInt(la);
		myData.setHeight(height);
		myData.setWeight(weight);
		myData.setName(name);
		myData.setLifeArmor(lifeArmor);
		myData.setBurnCal(weight, lifeArmor);
		int weiGht = myData.getWeight();
		Float stepwidth = myData.getStepwidth();
		
		SharedPreferences mPref = getSharedPreferences("mData", Context.MODE_PRIVATE);
		Monster monster = new Monster();
		monster.setName(name);
		monster.setExp(mPref.getInt("EXP", -1));
		LinearLayout toplayout = (LinearLayout) findViewById(R.id.toplayout);
		TextView lvText = new TextView(this);
		lvText.setText("Lv." +Integer.toString(monster.getLv()));
		toplayout.addView(lvText);
		TextView nameText = new TextView(this);
		nameText.setText(monster.getName());
		toplayout.addView(nameText);
		
		//Tab生成
		FragmentTabHost host = (FragmentTabHost) findViewById(android.R.id.tabhost);
        host.setup(this, getSupportFragmentManager(), R.id.content);
        
        //HomeTab
        TabSpec homeTab = host.newTabSpec("hometab");
        Button homebtn = new Button(this);
        homebtn.setBackgroundResource(R.drawable.img001);
        homebtn.setText("Home");
        homeTab.setIndicator(homebtn);
        homebdl.putFloat("BURN_CAL", myData.getBurnCal());
        homebdl.putString("NAME", name);
        host.addTab(homeTab, HomeFragment.class, homebdl);
        //ExerciseTab
        TabSpec exTab = host.newTabSpec("ex");
        Button exbtn = new Button(this);
        exbtn.setBackgroundResource(R.drawable.img001);
        exbtn.setText("Exercise");
        exTab.setIndicator(exbtn);
        exbdl.putInt("WEIGHT", weiGht);
        exbdl.putFloat("STEP_WIDTH", stepwidth);
        exbdl.putInt("STEP", step);
        host.addTab(exTab, ExerciseFragment.class, exbdl);
        //オプションタブ
        Button optionbtn = (Button) findViewById(R.id.option);
        optionbtn.setBackgroundResource(R.drawable.img001);
        optionbtn.setText("Option");
        optionbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent opintent = new Intent();
				opintent.setClassName("jp.procon.healthgame", "jp.procon.healthgame.Preference");
				startActivity(opintent);
			}
        	
        });
        //センサー処理
        smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list;
        list = smanager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (list.size() > 0) accelerometer = list.get(0);
        
        //データベースオープン
		StepdbHelper helper = new StepdbHelper(this.getApplicationContext(),"step.db",null,1);
		try{
			sdb = helper.getWritableDatabase();
			//sdb = helper.getReadableDatabase();
		}catch(SQLiteException e){
			//異常終了
			return;
		}
		Time time = new Time();
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		if (accelerometer != null) {
			smanager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
		}
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		//manager.unregisterListener(this);
		//終了時にデータベースに記録
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		ContentValues values = new ContentValues();
		Time time = new Time();
		values.put("year", time.getYear());
		values.put("month", time.getMonth());
		values.put("date", time.getDate());
		values.put("step", step);
		sdb.insert("steptbl", null, values);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		acceleration.setNxyz(event.values[0], event.values[1], event.values[2]);
		step = stepcount.stepCnt(acceleration);
		exbdl.putInt("STEP", step);
		myData.setBurnedCal(step);
		exbdl.putFloat("BURNED_CAL", myData.getBurnedCal());
		homebdl.putFloat("BURNED_CAL", myData.getBurnedCal());
	}
}
