package jp.pr.stepcountmonster;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	public HomeFragment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public static Fragment newInstance(String title) {
		HomeFragment fragment = new HomeFragment();
		
		Bundle args = new Bundle();
		args.putString("title", title);
		// フラグメントに渡す値をセット
		fragment.setArguments(args);
		
		return fragment;
		}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView text = new TextView(getActivity());
		text.setText("aaaaaaaaaaaaaaa");
		return text;
	}

}
