package jp.procon.healthgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExerciseFragment extends Fragment {
	//private Acceleration acceleration = new Acceleration();
	//private SensorManager sensorManager;
	public int step = 0;
	public String stepstring = null;

	public ExerciseFragment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TextView stepText = new TextView(getActivity());
		//Integer step = getArguments().getInt("STEP");
        //String stepstring = step.toString();
        //stepText.setText(stepstring);
		//Log.d("aaaaaaa", stepstring);
		
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        LinearLayout exlayout = (LinearLayout) inflater.inflate(R.layout.exercise, container, false);

        TextView stepText = new TextView(getActivity());
        Integer step = getArguments().getInt("STEP");
        String stepstring = step.toString();
        stepText.setText(stepstring);
        //Log.d("aaaaaaa", stepstring);
        exlayout.addView(stepText);
        return exlayout;
        
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
	}

}
