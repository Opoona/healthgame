package jp.procon.healthgame;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SleepDBHelper extends SQLiteOpenHelper {

	public SleepDBHelper(Context context) {
		//DBを作成
		super(context, "sleepdb", null, 3);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public SleepDBHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("CREATE TABLE sleeptbl (day TEXT PRIMARY KEY,sleeptime TEXT,wakeuptime TEXT,sleepinghours INTEGER)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
