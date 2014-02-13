package jp.procon.healthgame;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.Window;

public class Preference extends PreferenceActivity {
	//private MyData  myData = null;

	private SharedPreferences sharedPref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new Preflg()).commit();
		//preferenceをとってくる処理
		sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		String h = sharedPref.getString("user_height", "0");
		String w = sharedPref.getString("user_weight", "0");
		int height = Integer.parseInt(h);
		int weight = Integer.parseInt(w);
		String name = sharedPref.getString("user_name", "unknown");
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		/*sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		String h = sharedPref.getString("user_height", "0");
		String w = sharedPref.getString("user_weight", "0");
		int height = Integer.parseInt(h);
		int weight = Integer.parseInt(w);
		String name = sharedPref.getString("user_name", "unknown");
		MyData myData = new MyData(height, weight, name);
		*/
	}
	
	public static class Preflg extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState) ;
			addPreferencesFromResource(R.xml.preferences);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preference, menu);
		return true;
	}

}
