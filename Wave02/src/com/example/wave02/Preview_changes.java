package com.example.wave02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Preview_changes extends Activity implements OnClickListener{
TextView tv1,tv2,tv3;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview_changes);
		tv1=(TextView)findViewById(R.id.tv_home);
		tv2=(TextView)findViewById(R.id.tv_dob);
		tv3=(TextView)findViewById(R.id.tv_fav_song);
		tv1.setText(Global.Hometown);
		tv2.setText(Global.fav_song);
		tv3.setText(Global.date_birthday);
		b1=(Button)findViewById(R.id.btn_show_acc);
		b1.setOnClickListener(this);
		  
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_show_acc:
			Intent i= new Intent("com.example.wave02.Acc_view");
			startActivity(i);
			break;
		}
		
	}
	

}
