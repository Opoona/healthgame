package jp.pr.stepcountmonster;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class MainTabListener <T extends Fragment> implements TabListener {

	private Fragment fragment;
	private final Activity activity;
	private final String tag;
	private final Class<T> cls;

public MainTabListener(Activity activity, String tag, Class<T> cls) {
	this.activity = activity;
	this.tag = tag;
	this.cls = cls;
}
  
@Override
public void onTabReselected(Tab tab, FragmentTransaction ft) {
}

@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
	if(fragment == null){
    fragment = Fragment.instantiate(activity, cls.getName());
      ft.add(android.R.id.content, fragment, tag);
    } else{
      ft.attach(fragment);
    }
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
  if(fragment != null){
    ft.detach(fragment);
  }
}
}