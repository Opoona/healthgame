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

public class ExerciseFragment extends Fragment {
	//private Acceleration acceleration = new Acceleration();
	//private SensorManager sensorManager;
	public int step = 0;
	
	
	
	public ExerciseFragment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout exlayout = (LinearLayout) inflater.inflate(R.layout.exercise, container, false);
        TextView stepText = (TextView) exlayout.findViewById(R.id.todaystep);
        TextView burnText = (TextView) exlayout.findViewById(R.id.todaycal);
        Float stepWidth = getArguments().getFloat("STEP_WIDTH");
        Integer weight = getArguments().getInt("WEIGHT");
        Integer step = getArguments().getInt("STEP");
        Float burnCal = step * stepWidth * weight;
        String stepString = step.toString();
        String burnCalString = burnCal.toString();
        stepText.setText(stepString);
        burnText.setText(burnCalString);
        
        return exlayout;
    }
	
	/*@Override
	public void onPause() {
		super.onPause();
	}*/
	
	@Override
	public void onResume() {
		super.onResume();
		
	}

}
