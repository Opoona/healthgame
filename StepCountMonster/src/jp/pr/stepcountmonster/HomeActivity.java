package jp.pr.stepcountmonster;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;

public class HomeActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//ActionBarをタブナビゲーションに設定
		ActionBar mActionBar = getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.addTab(mActionBar.newTab().setText("HOME").setTabListener(new MainTabListener<HomeFragment>(this, "home", HomeFragment.class)));
		//mActionBar.addTab(getActionBar().newTab().setText("STEP").setTabListener(this));
		//mActionBar.addTab(getActionBar().newTab().setText("OPTION").setTabListener(this));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return false;
	}



}
