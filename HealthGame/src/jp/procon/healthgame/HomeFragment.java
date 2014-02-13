package jp.procon.healthgame;

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
	
	private SharedPreferences sharedPref;
			
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		String h = sharedPref.getString("user_height", "0");
		String w = sharedPref.getString("user_weight", "0");
		int height = Integer.parseInt(h);
		int weight = Integer.parseInt(w);
		String name = sharedPref.getString("user_name", "unknown");
		MyData myData = new MyData(height, weight, name);
		LinearLayout homelayout = (LinearLayout) inflater.inflate(R.layout.homef, container, false);
		TextView text = new TextView(getActivity());
		text.setText(myData.getName());
		homelayout.addView(text);
        return homelayout;
    }
}
