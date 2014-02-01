package jp.procon.healthgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

public class MyDlg extends DialogFragment {
	private DialogListener listener = null;

	  public static MyDlg newInstance(String title, String message, int type){
	        MyDlg instance = new MyDlg();
	        
	        // ダイアログに渡すパラメータはBundleにまとめる
	        Bundle arguments = new Bundle();
	        arguments.putString("title", title);
	        arguments.putString("message", message);
	        arguments.putInt("type", type);
	        
	        instance.setArguments(arguments);
	        
	        return instance;
	    }
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		LayoutInflater inf = getActivity().getLayoutInflater();
		View view = inf.inflate(R.layout.sleepdlg, null, false);
		
		NumberPicker np1 = (NumberPicker) view.findViewById(R.id.numberPicker1);
		np1.setMaxValue(23);
		np1.setMinValue(0);
		NumberPicker np2 = (NumberPicker) view.findViewById(R.id.numberPicker2);
		np2.setMaxValue(59);
		np2.setMinValue(0);
		NumberPicker np3 = (NumberPicker) view.findViewById(R.id.numberPicker3);
		np3.setMaxValue(23);
		np3.setMinValue(0);
		NumberPicker np4 = (NumberPicker) view.findViewById(R.id.numberPicker4);
		np4.setMaxValue(59);
		np4.setMinValue(0);
		
		String title = getArguments().getString("title");
		String message = getArguments().getString("message");
		int type = getArguments().getInt("type");
		
		AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
		.setView(view)
		.setTitle(title)
		.setMessage(message)
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自動生成されたメソッド・スタブ
				listener.doPositiveClick();
				dismiss();
			}
		});
		if (type == 1) {
			alert.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自動生成されたメソッド・スタブ
					listener.doNegativeClick();
					dismiss();
				}
			});
		}
		return alert.create();
	}
	
	public void setDialogListener(DialogListener listener) {
		this.listener = listener;
	}
	
	public void removeDialogListener() {
		this.listener = null;
	}
}
