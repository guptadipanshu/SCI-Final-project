package com.example.wave02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Start_journey extends Activity implements OnClickListener{
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_journey);
		b1=(Button) findViewById(R.id.btn_strt_song_search);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_strt_song_search:
			Intent i= new Intent("com.example.wave02.Songsearch");
			startActivity(i);
			finish();
			break;
		}
		
		
	}
	

}
