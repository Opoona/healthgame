package jp.procon.healthgame;

import android.content.SharedPreferences;

public class MyData {
	private int height; //身長
	private int weight; //体重
	private String name; //名前
	private int burnCal; //消費すべきカロリー
	private int bestWeight; //標準体重
	private float stepwidth; //歩幅
	
	

	public MyData() {
	}
	
	public MyData(int height, int weight, String name,int lifeArmor) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.height = height;
		this.weight = weight;
		this.name = name;
		
		this.bestWeight = (height/100) * (height/100) * 22;
		this.burnCal = weight * lifeArmor; 
		this.setStepwidth(height * 0.45f);
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

	public float getStepwidth() {
		return stepwidth;
	}

	public void setStepwidth(float stepwidth) {
		this.stepwidth = stepwidth;
	}
}
