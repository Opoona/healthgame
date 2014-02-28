package jp.procon.healthgame;

import java.lang.reflect.Array;
import android.widget.ImageView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;

public class Monster {
	private int exp = -1;
	private int lv = -1;
	private String name;
	private int totalExp = -1;
	private int[] expTbl = new int[10];
	
	public Monster() {
		// TODO 自動生成されたコンストラクター・スタブ
		for (int i = 0; i < 10; i++) {
			this.expTbl[i] = 90 + 10 * (i * i); 
			totalExp += expTbl[i];
		}
	}
	
	public void addExp (Float burncal, Float burnedcal) {
		if (burncal - 2000f < burnedcal && burnedcal < burncal + 2000f) {
			this.exp += 200;
		} else if (burnedcal <= burncal -2000f) {
			this.exp += 10;
		} else if (burnedcal >= burncal + 2000f) {
			this.exp += 700;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		int i;
		for (i = 0; this.exp > this.expTbl[i]; i++) {
		}
		this.setLv(i+1);
	}
	
}
