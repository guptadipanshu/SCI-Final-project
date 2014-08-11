package com.example.wave02;

import java.io.IOException;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;



public class Screen1 extends Activity implements OnClickListener{
 Button b2,b1,b3,b4,like_up1,like_up2,like_down3,like_down2,like_down1,like_up3;
 Button playsong;
 TextView tv_countup1,tv_countup2,tv_countup3,tv_countdown1,tv_countdown2,tv_countdown3;
 int count=0;
 MediaPlayer mp= new MediaPlayer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen02);
		b2=(Button) findViewById(R.id.shareselectsong);
    	b1=(Button) findViewById(R.id.settings);
    	b3=(Button) findViewById(R.id.shareeditsong);
    	b4=(Button) findViewById(R.id.viewas);
    	playsong=(Button) findViewById(R.id.playsong1);
    	like_up1=(Button) findViewById(R.id.likesong1);
    	like_up2=(Button) findViewById(R.id.likesong2);
    	like_up3=(Button) findViewById(R.id.likesong3);
    	like_down1=(Button) findViewById(R.id.dislikesong1);
    	like_down2=(Button) findViewById(R.id.dislikesong2);
    	like_down3=(Button) findViewById(R.id.dislikesong3);
    	tv_countup1=(TextView) findViewById(R.id.tvlikecount1);
    	tv_countup2=(TextView) findViewById(R.id.tvlikescount2);
    	tv_countup3=(TextView) findViewById(R.id.TextView01);
    	tv_countdown3=(TextView) findViewById(R.id.TextView02);
    	tv_countdown1=(TextView) findViewById(R.id.tvdislikecount1);
    	tv_countdown2=(TextView) findViewById(R.id.tvdislikecount2);
    	//b3=(Button) findViewById(R.id.buttonlikeup);
    	//tv=(TextView)findViewById(R.id.tvlikesup);
    	b2.setOnClickListener(this);
    	b4.setOnClickListener(this);
    	b1.setOnClickListener(this);
    	b3.setOnClickListener(this);
    	like_up1.setOnClickListener(this);
    	like_up3.setOnClickListener(this);
    	like_up2.setOnClickListener(this);
    	like_down1.setOnClickListener(this);
    	like_down2.setOnClickListener(this);
    	like_down3.setOnClickListener(this);
    	playsong.setOnClickListener(this);
    	//b3.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.shareselectsong:{
			mp.stop();
			Intent i= new Intent("com.example.wave02.Songsearch");
			startActivity(i);
		}
		break;
		case R.id.shareeditsong:{
			mp.stop();
			Intent i= new Intent("com.example.wave02.Songedit");
			startActivity(i);
			break;
		}
		case R.id.settings:
		{
			Intent i= new Intent("com.example.wave02.Personal_settings");
			startActivity(i);
			
			break;
		}
		case R.id.viewas:
		{
			Intent i= new Intent("com.example.wave02.Viewas");
			startActivity(i);
			
			break;
		}
		case R.id.likesong1:
		{   Global.count_up1=Global.count_up1+1;
			tv_countup1.setText(""+Global.count_up1);
			break;
		}
		case R.id.likesong2:
		{   Global.count_up2=Global.count_up2+1;
			tv_countup2.setText(""+Global.count_up2);
			break;
		}
		case R.id.likesong3:
		{   Global.count_up3=Global.count_up3+1;
			tv_countup3.setText(""+Global.count_up3);
			break;
		}
		case R.id.dislikesong1:
		{   Global.count_down1=Global.count_down1+1;
		tv_countdown1.setText(""+Global.count_down1);
			break;
		}
		case R.id.dislikesong2:
		{   Global.count_down2=Global.count_down2+1;
		tv_countdown2.setText(""+Global.count_down2);
			break;
		}
		case R.id.dislikesong3:
		{   Global.count_down3=Global.count_down3+1;
		tv_countdown3.setText(""+Global.count_down3);
			break;
		}
		case R.id.playsong1:
		{   
		    String song= Global.song;
			mp.reset();
			try {
				mp.setDataSource(song);
				mp.prepare();
				mp.start();
				
			}catch(IOException e){
								Log.v(getString(R.string.app_name), e.getMessage());
							}
			break;
		}
	   }
	}
	
	

}
