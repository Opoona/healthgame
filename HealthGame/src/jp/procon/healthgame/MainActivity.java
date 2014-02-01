package jp.procon.healthgame;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //レイアウト作成
        LinearLayout layout = new LinearLayout(this);
        final Button button = new Button(this);
        button.setText("Touch!");
        layout.addView(button, WC, WC);
        setContentView(layout);
        button.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent();
        		intent.setClassName("jp.procon.healthgame", "jp.procon.healthgame.HomeActivity");
        		startActivity(intent);
        	}
        });
    }

    protected void onResume() {
    	super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
