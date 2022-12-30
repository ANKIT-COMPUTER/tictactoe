package com.example.gamingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText e1,e2;
	Button b1,b2;
    String p1,p2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		e1=(EditText)findViewById(R.id.etp1);
		e2=(EditText)findViewById(R.id.etp2);
		b1=(Button)findViewById(R.id.button_1);
		b2=(Button)findViewById(R.id.button_2);
	
	
	  b1.setOnClickListener(new View.OnClickListener() {
      	public void onClick(View view) {
      		if(e1.getText().toString().length() ==0){
          		e1.setText("Player One");
          	}
        	if(e2.getText().toString().length()== 0){
          		e2.setText("Player two");
          	}
      	Intent i1=new Intent(MainActivity.this,Classic.class);
      	i1.putExtra("player1", e1.getText().toString());
    	i1.putExtra("player2", e2.getText().toString());
      	 startActivity(i1);
    	}
      });
	  b2.setOnClickListener(new View.OnClickListener() {
	      	public void onClick(View view) {
	      		if(e1.getText().toString().length() ==0){
	          		e1.setText("Player One");
	          	}
	        	if(e2.getText().toString().length()== 0){
	          		e2.setText("Player two");
	          	}
	      	Intent i2=new Intent(MainActivity.this,Advance.class);
	      	i2.putExtra("player1", e1.getText().toString());
	      	i2.putExtra("player2", e2.getText().toString());
	      	startActivity(i2);
	    	}
	      });
	    

	}
}
