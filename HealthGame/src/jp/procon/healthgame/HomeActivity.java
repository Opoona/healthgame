package jp.procon.healthgame;


import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost.TabSpec;

public class HomeActivity extends FragmentActivity implements SensorEventListener{
	private Acceleration acceleration = new Acceleration();
	private StepCount stepcount = new StepCount();
	private SensorManager smanager;
	private Sensor accelerometer;
	private Bundle exbdl = new Bundle();

	private int step = -1;
	FragmentManager fm = getSupportFragmentManager();
	FragmentTransaction t = fm.beginTransaction();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home);
		

		//Tab生成
		FragmentTabHost host = (FragmentTabHost) findViewById(android.R.id.tabhost);
        host.setup(this, getSupportFragmentManager(), R.id.content);
        
        //HomeTab
        TabSpec homeTab = host.newTabSpec("hometab");
        Button homebtn = new Button(this);
        homebtn.setText("Home");
        homeTab.setIndicator(homebtn);
        host.addTab(homeTab, HomeFragment.class, null);
        
        /*//SleepTab
        TabSpec sleepTab = host.newTabSpec("tab1");
        Button sleepbtn = new Button(this);
        sleepbtn.setText("Sleep");
        //button1.setBackgroundResource(R.drawable.tab_left);
        sleepTab.setIndicator(sleepbtn);
        Bundle sleepbdl = new Bundle();
        sleepbdl.putString("name", "Tab1");
        host.addTab(sleepTab, SleepFragment.class, sleepbdl);
        */
        
        /*//FoodTab
        TabSpec foodTab = host.newTabSpec("tab2");
        Button foodbtn = new Button(this);
        foodbtn.setText("Lunch");
        //button2.setBackgroundResource(R.drawable.tab_center);
        foodTab.setIndicator(foodbtn);
        Bundle foodbdl = new Bundle();
        foodbdl.putString("name", "Tab2");
        host.addTab(foodTab, FoodFragment.class, foodbdl);
        */
        
        //ExerciseTab
        TabSpec exTab = host.newTabSpec("ex");
        Button exbtn = new Button(this);
        exbtn.setText("Exercise");
        //button3.setBackgroundResource(R.drawable.tab_right);
        exTab.setIndicator(exbtn);
        Log.d("step", "step == -1");
        exbdl.putInt("STEP", step);
        host.addTab(exTab, ExerciseFragment.class, exbdl);
		
        //OptionTab
        /*TabSpec opTab = host.newTabSpec("option");
        Button opbtn = new Button(this);
        opbtn.setText("Option");
        opTab.setContent(new Intent(this, OptionFragment.class));
        opTab.setIndicator(opbtn);
        host.addTab(opTab, OptionFragment.class, null);
        */
        //オプションタブ
        Button optionbtn = (Button) findViewById(R.id.option);
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
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction t = fm.beginTransaction();
		ExerciseFragment fragment = new ExerciseFragment();
		//Bundle bundle = new Bundle();
		exbdl.putInt("STEP", step);
		// フラグメントに渡す値をセット
		fragment.setArguments(exbdl);
		t.add(fragment, null);
		t.commit();
		
	}
}
