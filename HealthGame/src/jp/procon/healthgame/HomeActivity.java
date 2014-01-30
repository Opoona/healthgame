package jp.procon.healthgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

public class HomeActivity extends Activity {

	public HomeActivity() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Intent intent = getIntent();
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
	}

}
