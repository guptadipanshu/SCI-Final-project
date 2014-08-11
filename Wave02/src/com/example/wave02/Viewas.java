package com.example.wave02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Viewas extends Activity implements OnClickListener {
	ImageButton b1,b2,b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewas);
		b1=(ImageButton) findViewById(R.id.imageButton1);
		b2=(ImageButton) findViewById(R.id.imageButton2);
		b3=(ImageButton) findViewById(R.id.imageButton3);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.imageButton1:{
			Intent i= new Intent("com.example.wave02.Preview_changes");
			startActivity(i);
			finish();
			break;
		}
		case R.id.imageButton3:{
			Intent i= new Intent("com.example.wave02.Preview_changes");
			startActivity(i);
			finish();
			break;
		}
		case R.id.imageButton2:{
			Intent i= new Intent("com.example.wave02.Preview_changes");
			startActivity(i);
			finish();
			break;
		}
		}
		
	}
	

}
