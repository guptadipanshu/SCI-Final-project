package com.example.wave02;

import com.example.wave02.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Personal_settings extends Activity implements OnClickListener{
EditText et_city,et_dob,et_fsong;
Button save,pri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_dialog);
		et_city=(EditText) findViewById(R.id.et_hometown);
		et_dob=(EditText) findViewById(R.id.et_birth);
		et_fsong=(EditText) findViewById(R.id.et_Fav_song);
		save=(Button) findViewById(R.id.btn_save_changes);
		pri=(Button) findViewById(R.id.btn_privew);
		save.setOnClickListener(this);
		pri.setOnClickListener(this);

		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_privew:{
			Global.Hometown=et_city.getText().toString();
			Global.date_birthday=et_dob.getText().toString();
			Global.fav_song=et_fsong.getText().toString();
			Intent i= new Intent("com.example.wave02.Preview_changes");
			startActivity(i);
			break;
		}
		case R.id.btn_save_changes:{
			Global.Hometown=et_city.getText().toString();
			Global.date_birthday=et_dob.getText().toString();
			Global.fav_song=et_fsong.getText().toString();
			finish();
			
		}
	}
	
	}
}
