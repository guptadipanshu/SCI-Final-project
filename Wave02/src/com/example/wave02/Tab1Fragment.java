package com.example.wave02;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity; 

 
/**
 * @author mwho
 *
 */
public class Tab1Fragment extends Fragment implements OnClickListener  {
	Button b1,b2;
	
    /** (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }
       
        	View view=(LinearLayout)inflater.inflate(R.layout.fragment01, container, false);
        	b1=(Button) view.findViewById(R.id.login);
        	
        	b1.setOnClickListener(this);
        	b2=(Button) view.findViewById(R.id.signup);
        	
        	b2.setOnClickListener(this);
        	return view;
    }
	@Override
	public void onClick(View view) {
		
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.login:{
			
			Intent i= new Intent("com.example.wave02.Login");
			startActivity(i);
			
		}
		break;
		case R.id.signup:{
			Intent i= new Intent("com.example.wave02.Signup");
			startActivity(i);
			break;
		}
		}
	}
}