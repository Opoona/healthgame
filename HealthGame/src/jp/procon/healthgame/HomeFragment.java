package jp.procon.healthgame;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	Bitmap slime;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String name = getArguments().getString("NAME", "unknown");
		
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		LinearLayout homelayout = (LinearLayout) inflater.inflate(R.layout.homef, container, false);
		ImageView monsterimg = (ImageView) homelayout.findViewById(R.id.monsterimg);
		Resources res = getResources();
		Bitmap slime = BitmapFactory.decodeResource(res, R.drawable.slime);
		monsterimg.setImageBitmap(slime);
        return homelayout;
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
}
