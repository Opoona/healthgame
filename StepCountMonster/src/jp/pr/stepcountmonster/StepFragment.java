package jp.pr.stepcountmonster;

import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StepFragment extends Fragment {
	private SensorManager smanager;
	private Sensor accelerometer;

	public StepFragment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list;
        list = smanager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (list.size() > 0) accelerometer = list.get(0);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return container;
		
	}

}
