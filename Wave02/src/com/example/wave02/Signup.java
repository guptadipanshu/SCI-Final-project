package com.example.wave02;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends Activity implements android.view.View.OnClickListener {
EditText et1,et2,et3,et4;
String name;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usersetting);
		 et1=(EditText) findViewById(R.id.editText2);
		 et2=(EditText) findViewById(R.id.editText1);
		 et3=(EditText) findViewById(R.id.editText3);
		 et4=(EditText) findViewById(R.id.editText4);
		Button b1=(Button) findViewById(R.id.bupdate);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.bupdate:{
				try{
					name = et1.getText().toString();
					et3.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					
					String confirm_password = et4.getText().toString();
					et4.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					String password = et3.getText().toString();
					if(confirm_password.equals(password)){
					
					LoginDatabase entry = new LoginDatabase(Signup.this);
					entry.open();//open the entry method in hotornot
					entry.createEntry(name,password);
					entry.close();//close  called in hotornot
					Intent i= new Intent("com.example.wave02.Start_journey");
					startActivity(i);
					Toast.makeText(Signup.this, "WELCOME", Toast.LENGTH_SHORT).show();
					finish();
					}
					else
					{
						Toast.makeText(Signup.this, "PASSWORD ENTERED DOES NOT MATCH", Toast.LENGTH_SHORT).show();
					
						
					}
					}catch(Exception e){
						String et=e.toString();
						Dialog d = new Dialog(this);
						d.setTitle("UPDATE");
						TextView tv = new TextView(this);
						tv.setText(name);
						d.setContentView(tv);
						d.show();
				
				}
				break;
			}
		}
		
	}
	

}
