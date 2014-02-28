package jp.procon.healthgame;

import android.content.SharedPreferences;

public class MyData {
	private int height; //身長
	private int weight; //体重
	private String name; //名前
	private Float burnCal; //消費すべきカロリー
	private Float burnedCal;//消費カロリー
	private int bestWeight; //標準体重
	private float stepwidth; //歩幅
	private int lifeArmor;
	
	

	public MyData() {
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

	public Float getBurnedCal() {
		return burnedCal;
	}

	public void setBurnedCal(int step) {
		this.burnedCal = (step * this.stepwidth * this.weight)/10000;
		
	}

	public int getLifeArmor() {
		return lifeArmor;
	}

	public void setLifeArmor(int lifeArmor) {
		this.lifeArmor = lifeArmor;
	}

	public Float getBurnCal() {
		return burnCal;
	}

	public void setBurnCal(int lifeArmor, int weight) {
		this.burnCal = (float) (lifeArmor * weight);
	}
}
