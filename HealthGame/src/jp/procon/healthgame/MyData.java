package jp.procon.healthgame;

import android.content.SharedPreferences;

public class MyData {
	private int height;
	private int weight;
	private String name;
	
	public MyData() {
		
	}
	
	public MyData(int height, int weight, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.height = height;
		this.weight = weight;
		this.name = name;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		// TODO 自動生成されたメソッド・スタブ
		this.weight = weight;
	}

	public void setName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
