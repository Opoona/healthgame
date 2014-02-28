package jp.procon.healthgame;

import java.util.Calendar;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.echo.holographlibrary.*;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;

public class ExerciseFragment extends Fragment implements OnPointClickedListener {
	private int step = 0;
	private SQLiteDatabase sdb;
	private LineGraph lineGraph;
	private DrawGraph graph;
	private static final String BR = System.getProperty("line.separator");
	
	public ExerciseFragment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StepdbHelper helper = new StepdbHelper(getActivity().getApplicationContext(),"step.sqlite",null,1);
		try{
			sdb = helper.getWritableDatabase();
			//sdb = helper.getReadableDatabase();
		}catch(SQLiteException e){
			//異常終了
			return;
		}
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout exlayout = (LinearLayout) inflater.inflate(R.layout.exercise, container, false);
        TextView stepText = (TextView) exlayout.findViewById(R.id.todaystep);
        TextView burnedText = (TextView) exlayout.findViewById(R.id.todaycal);
        //Float stepWidth = getArguments().getFloat("STEP_WIDTH");
        //Integer weight = getArguments().getInt("WEIGHT");
        //Integer step = getArguments().getInt("STEP");
        //Float burnedCal = (step * stepWidth * weight)/10000;
        String stepString = Integer.toString(getArguments().getInt("STEP"));
        String burnCalString = Float.toString(getArguments().getFloat("BURNED_CAL"));
        stepText.setText(stepString);
        burnedText.setText(burnCalString);
        LineGraph lineGraph = (LineGraph) exlayout.findViewById(R.id.graph);
        DrawGraph graph = new DrawGraph(getActivity().getApplicationContext());
        lineGraph.setOnPointClickedListener(this);
        lineGraph.addLine(graph.draw(sdb));
        lineGraph.setRangeX(0, 7);
        lineGraph.setRangeY(0, 1000);
        lineGraph.setLineToFill(0);
        return exlayout;
    }
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onClick(int lineIndex, int pointIndex) {
		// TODO 自動生成されたメソッド・スタブ
		Calendar cal = Calendar.getInstance();
		Time time = new Time();
		String sql = "";
		sql += "SELECT year, month, date, sum(step) AS sumstep "
				+ "FROM StepTbl "
				+ "WHERE year == " + time.getYear() + " AND month == " + time.getMonth() + " AND date >= " + (cal.get(Calendar.DATE)-6)
				+ " GROUP BY date"
				+ " ORDER BY year DESC, month DESC, date DESC";
		Cursor c = sdb.rawQuery(sql, null);
		String str = "NO_DATA";
		if (c.moveToPosition(pointIndex)) {
			str = "";
			str += ""
					+ Integer.toString(c.getInt(c.getColumnIndex("month"))) + "月" + Integer.toString(c.getInt(c.getColumnIndex("date"))) + "日" + BR
					+ Integer.toString(c.getInt(c.getColumnIndex("sumstep"))) + " 歩";
		}
		Toast toast = Toast.makeText(getActivity().getApplicationContext(), str, Toast.LENGTH_SHORT);
		toast.show();
	}
}
