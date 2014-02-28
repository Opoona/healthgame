package jp.procon.healthgame;

import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;

import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;
import com.echo.holographlibrary.LinePoint;

public class DrawGraph extends LineGraph {
	private int pointX;
	private int pointY;

	public DrawGraph(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public Line draw(SQLiteDatabase sdb) {
		int p;
		int X = 0;
		Calendar cal = Calendar.getInstance();
		Cursor c = mergeDayStepRecord(sdb, cal);
		Line l = new Line();
		Integer flont = cal.get(Calendar.DATE);
		
		if (c.moveToFirst()) {
			int date = c.getInt(c.getColumnIndex("date"));
			do {
				if (flont == date/*c.getInt(c.getColumnIndex("date"))*/) {
					Integer Y = c.getInt(c.getColumnIndex("sumstep"));
					Log.d("sumstep",Integer.toString(Y));
					LinePoint point = new LinePoint();
					point.setX(X);
					point.setY(Y);
					l.addPoint(point);
					flont -= 1;
					X += 1;
					if (c.moveToNext()){
						date = c.getInt(c.getColumnIndex("date"));
					} else {
						do {
							LinePoint point2 = new LinePoint();
							point2.setX(X);
							point2.setY(0);
							l.addPoint(point);
							flont--;
							ContentValues values = new ContentValues();
							values.put("step", 0);
							values.put("year", cal.get(Calendar.YEAR));
							values.put("month", cal.get(Calendar.MONTH)+1);
							values.put("date", cal.get(Calendar.DATE) - X);
							sdb.insert("StepTbl", null, values);
							X++;
						} while (X < 7);
					}
				} else {
					do {
						LinePoint point = new LinePoint();
						point.setX(X);
						point.setY(0);
						l.addPoint(point);
						flont--;
						ContentValues values = new ContentValues();
						values.put("step", 0);
						values.put("year", cal.get(Calendar.YEAR));
						values.put("month", cal.get(Calendar.MONTH)+1);
						values.put("date", cal.get(Calendar.DATE) - X);
						sdb.insert("StepTbl", null, values);
						X++;
					} while (flont > date);
				}
			} while (X < 7);
		}
		l.setColor(Color.parseColor("#9ac132"));
		return l;
	}
	
	public Cursor mergeDayStepRecord(SQLiteDatabase sdb, Calendar cal) {
		Time time = new Time();
		String sql = "";
		sql += "SELECT year, month, date, sum(step) AS sumstep "
				+ "FROM StepTbl "
				+ "WHERE year == " + time.getYear() + " AND month == " + time.getMonth() + " AND date >= " + (cal.get(Calendar.DATE)-6)
				+ " GROUP BY date"
				+ " ORDER BY year DESC, month DESC, date DESC";
		Log.d("sql", sql);
		Cursor cursor = sdb.rawQuery(sql, null);
		return cursor;
	}
}
