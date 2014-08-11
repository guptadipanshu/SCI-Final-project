package com.example.wave02;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
class Mp3Filter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return (name.endsWith(".ogg"));
	}
	

}
public class Songsearch02 extends ListActivity {
private static final String SD_PATH = new String("/system/media/audio/ringtones/");
private List<String> songs= new ArrayList<String>();
private MediaPlayer mp= new MediaPlayer();
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.song_item);
		tv= (TextView) findViewById(R.id.textView1);
		
		updatePlayList();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
			 Global.song=SD_PATH +songs.get(position);
			//mp.prepare();
			//mp.start();
			
			finish();
		
	}
	 
	private void updatePlayList() {
		// TODO Auto-generated method stub
		File home = new File(SD_PATH);
		if(home.listFiles(new Mp3Filter()).length>0){
			for(File file: home.listFiles((new Mp3Filter()))){
				songs.add(file.getName());
				
				
			}
			ArrayAdapter<String> songsList = new ArrayAdapter<String>(this,R.layout.song_item_view,songs); 
			setListAdapter(songsList);
		}
		
		
	}
	

}
