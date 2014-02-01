package jp.procon.healthgame;

import java.util.EventListener;

public interface DialogListener extends EventListener{
	
	public void doPositiveClick();
	
	public void doNegativeClick();
}
