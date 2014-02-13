package jp.procon.healthgame;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	
	@Override
	public void onAttach(Activity act) {
		super.onAttach(act);
	}
	
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		LinearLayout homelayout = (LinearLayout) inflater.inflate(R.layout.homef, container, false);
        return homelayout;
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
}
