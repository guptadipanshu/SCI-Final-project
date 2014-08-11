package com.example.wave02;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Songedit extends Activity implements OnSeekBarChangeListener, OnClickListener {
	SeekBar st;
	Handler handler;
	Button play;
	MediaPlayer mp= new MediaPlayer();
	private final int stateMP_NotStarter = 0;
    private final int stateMP_Playing = 1;
    private final int stateMP_Pausing = 2;
    private int mediaPos;
    private int mediaMax;
    private int stateMediaPlayer;
    Button close;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.songedit);
		close=(Button) findViewById(R.id.edit_song_close);
		close.setOnClickListener(this);
		st=(SeekBar) findViewById(R.id.seekBar1);
		st.setOnSeekBarChangeListener(this);
		 play=(Button)findViewById(R.id.btn_play);
		 play.setOnClickListener(this);
		 handler = new Handler();
	        mp = new MediaPlayer();
	        String song= Global.song;
			mp.reset();
			try {
				mp.setDataSource(song);
				mp.prepare();
				mp.start();
				ImageView img_animation = (ImageView) findViewById(R.id.image_view_waveform);
				 TranslateAnimation animation = new TranslateAnimation(0.0f, 40.0f,
				            0.0f, 0.0f);
				    animation.setDuration(10000);   
				    animation.setRepeatCount(5);  
				    animation.setRepeatMode(2);
				    img_animation.startAnimation(animation);
						} catch(IOException e){
						  Log.v(getString(R.string.app_name), e.getMessage());
				}
			 stateMediaPlayer = stateMP_NotStarter; 
			 mediaPos = mp.getCurrentPosition();
			 mediaMax = mp.getDuration();
			 st.setMax(mediaMax);
			 st.setProgress(mediaPos);
			 handler.removeCallbacks(moveSeekBarThread);
		     handler.postDelayed(moveSeekBarThread, 100);
			
	}
	 private Runnable moveSeekBarThread = new Runnable() {

	        public void run() {
	            if (mp.isPlaying()) {

	                int mediaPos_new = mp.getCurrentPosition();
	                int mediaMax_new = mp.getDuration();

	                st.setMax(mediaMax_new);
	                st.setProgress(mediaPos_new);

	                handler.postDelayed(this, 100); 
	            }else {
	                int mediaPos_new = mp.getCurrentPosition();
	                int mediaMax_new = mp.getDuration();

	                st.setMax(mediaMax_new);
	                st.setProgress(mediaPos_new);

	                handler.postDelayed(this, 100); 
	            }
	        }
	    };
	
	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		 if (arg2) {
             mp.seekTo(arg1);
             mp.pause();
             
             st.setProgress(arg1);
		
		 }
	}
	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.btn_play:
				          mp.start();
				          break;
			case R.id.edit_song_close:
				mp.stop();
				finish();
		}
	}
	

}
