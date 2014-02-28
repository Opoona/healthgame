package jp.procon.healthgame;

import android.app.Activity;
import android.content.Context;
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
	Monster monster = new Monster();
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String name = getArguments().getString("NAME", "unknown");
		monster.setName(name);
		SharedPreferences mPref = getActivity().getSharedPreferences("mData", Context.MODE_PRIVATE);
		monster.setExp(mPref.getInt("EXP", -1));
		Float burncal = getArguments().getFloat("BURN_CAL");
		Float burnedcal = getArguments().getFloat("BURNED_CAL");
		monster.addExp(burncal, burnedcal);
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
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		SharedPreferences mPref = getActivity().getSharedPreferences("mData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = mPref.edit();
		editor.putInt("EXP", monster.getExp());
		editor.apply();
	}
}
