package jp.procon.healthgame;

import java.lang.reflect.Array;

public class Monster {
	private int exp;
	private String mName;
	int[] expTbl = new int[10];

	public Monster(String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		for (int i = 0; i < 10; i++) {
			this.expTbl[i] = 90 + 10 * (i * i); 
		}
		this.mName = name;
	}
	
}
