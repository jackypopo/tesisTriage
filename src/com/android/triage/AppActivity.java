package com.android.triage;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AppActivity extends Activity {
	
	Button button, button2, button3, button4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		addListenerOnButton();
	}


	public void addListenerOnButton() {

		final Context context = this;

		button = (Button) findViewById(R.id.button1);
		button2= (Button) findViewById(R.id.button2);
		button3= (Button) findViewById(R.id.button3);
		button4= (Button) findViewById(R.id.button4);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App2Activity.class);
                startActivity(intent);   

			}

		});
		
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App9Activity.class);
                startActivity(intent);   

			}

		});
		
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App9Activity.class);
                startActivity(intent);   

			}

		});
		
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App14Activity.class);
                startActivity(intent);   

			}

		});
		
	}
}
