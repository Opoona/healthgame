package jp.procon.healthgame;

import java.lang.reflect.Array;

import android.widget.ImageView;
import android.app.Activity;
import android.content.res.Resources;

public class Monster {
	private int exp;
	private String name;
	int[] expTbl = new int[10];

	public Monster(String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		for (int i = 0; i < 10; i++) {
			this.expTbl[i] = 90 + 10 * (i * i); 
		}
		this.setName(name);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
