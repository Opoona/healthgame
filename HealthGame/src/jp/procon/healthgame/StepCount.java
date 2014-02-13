package jp.procon.healthgame;

import java.util.Calendar;
import java.util.Date;

import android.util.Log;

public class StepCount extends Acceleration {
	private int step = 0;
	private boolean Mflag = false;
	private boolean mflag = false;
	Calendar cal = Calendar.getInstance();
	
	private int newSecond;
	private int oldSecond = 0;

	public StepCount() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int stepCnt(Acceleration acceleration) {
		this.Nxyz = acceleration.getNxyz();
		this.Oxyz = acceleration.getOxyz();
		
		//Log.d("aaaaaaaaaa", Oxyz);
		
		if (G > this.Nxyz) {
			if (Mflag == true) {
				if (Math.abs(this.Oxyz - this.Nxyz) > 0.2f) {
					step += 1;
					Mflag = false;
				}
			} else {
				mflag = true;
			}
			this.Oxyz = this.Nxyz;
		} else if (G < this.Nxyz) {
			Mflag = true;
			this.Oxyz = this.Nxyz;
		}
		return step;
	}
	
	/*public Acceleration setTime(Acceleration acceleration) {
		newSecond = cal.get(Calendar.SECOND);
		acceleration.newSecond
		return acceleration;
		
	}*/
}
