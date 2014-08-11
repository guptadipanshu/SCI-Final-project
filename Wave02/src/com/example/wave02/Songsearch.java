package com.example.wave02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Songsearch extends Activity implements OnClickListener {
	Button b1, b3 ;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.songsearch1);
		b1=(Button) findViewById(R.id.btn_exit_upload);
		b3= (Button) findViewById(R.id.browselocalsong);
    	b3.setOnClickListener(this);
    	
    	b1.setOnClickListener(this);
    	
	}public void onClick(View view) {
		
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.browselocalsong:{
			
			Intent i= new Intent("com.example.wave02.Songsearch02");
		
			startActivity(i);
			finish();
			break;
		}
		
		case R.id.btn_exit_upload:{ 
			        finish();
					break;
		        }
		}

}
}
