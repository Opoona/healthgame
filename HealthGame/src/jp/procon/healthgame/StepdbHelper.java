package jp.procon.healthgame;

import java.util.Calendar;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class StepdbHelper extends SQLiteOpenHelper {
	private final static String name = "db";
	private final static int version = 1;

	public StepdbHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, null, version);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		Time time = new Time();
		Calendar cal = Calendar.getInstance();
		String sql = "";
		sql += "create table StepTbl (";
		sql += "_id integer primary key autoincrement not null, ";
		sql += "year String, ";
		sql += "month String, ";
		sql += "date String, ";
		sql += "step Integer";
		sql += ")";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
