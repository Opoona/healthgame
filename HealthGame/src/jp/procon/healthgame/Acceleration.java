package jp.procon.healthgame;

public class Acceleration {
	protected float Oxyz = 0.9f * 9.807f;
	protected float Nxyz = 0.0f;
	protected final float G = 0.9f * 9.807f;

	
	protected void setNxyz(float x, float y, float z) {
		Nxyz = x + y + z;
	}
	
	float getOxyz() {
		return Oxyz;
	}
	
	float getNxyz() {
		return Nxyz;
	}

}
