package com.android.triage;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class App3Activity extends Activity {

	Button button, button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main3);
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {

		final Context context = this;

		button = (Button) findViewById(R.id.button31);
		button2 = (Button) findViewById(R.id.button32);
		

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, AppActivity.class);
                startActivity(intent);   

			}

		});
		
		
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, AppActivity.class);
                startActivity(intent);   

			}

		});
		
	}
	
	@Override
	public void onBackPressed() {
	}
		
}
