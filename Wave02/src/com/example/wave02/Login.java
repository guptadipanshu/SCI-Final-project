package com.example.wave02;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
	TextView tv;
	Button b1;
	EditText e1,e2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.login);
	 tv=(TextView)findViewById(R.id.tv);
	 
	 e1=(EditText) findViewById(R.id.etusername);
	 e2=(EditText) findViewById(R.id.etpassword);
	 b1=(Button) findViewById(R.id.loginbutton);
	 b1.setOnClickListener(this);
	
	

}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.loginbutton:LoginDatabase info = new LoginDatabase(this);
		info.open();
		boolean check=false;
		String name = e1.getText().toString();
		String password = e2.getText().toString();
		e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		check=info.getcheckData(name,password);
		info.close();
		if(check==true)
			{Intent i= new Intent("com.example.wave02.Screen1");
			  finish();
			startActivity(i);
			}	
		else	
			Toast.makeText(Login.this, "INCORRECT PASSWORD", Toast.LENGTH_SHORT).show();
		}
		
	}
}
