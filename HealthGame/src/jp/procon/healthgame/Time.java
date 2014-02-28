package jp.procon.healthgame;

import java.util.Calendar;

public class Time {
	private String year;
	private String month;
	private String date;
	private String oyear;
	private String omonth;
	private String odate;

	public Time() {
		// TODO 自動生成されたコンストラクター・スタブ
		Calendar cal = Calendar.getInstance();
		this.setYear(Integer.toString(cal.get(Calendar.YEAR)));
		this.setMonth(Integer.toString(cal.get(Calendar.MONTH)+1));
		this.setDate(Integer.toString(cal.get(Calendar.DATE)));
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
