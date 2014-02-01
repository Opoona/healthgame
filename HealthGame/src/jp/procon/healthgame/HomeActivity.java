package jp.procon.healthgame;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomeActivity extends FragmentActivity implements DialogListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home);
		
		Button sleepbtn = (Button) findViewById(R.id.sleepbtn);
    	sleepbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				showDialog("睡眠時間の登録", "睡眠時間を入力してください", 1);
			}
    	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	public void showDialog(String title, String message, int type) {
		MyDlg fm = MyDlg.newInstance(title, message, type);
		fm.setDialogListener(this);
		fm.setCancelable(false);
		fm.show(getFragmentManager(), "dialog");
	}
	
	public void doPositiveClick() {
		//finish();
	}
	
	public void doNegativeClick() {
		
	}
}
