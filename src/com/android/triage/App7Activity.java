package com.android.triage;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class App7Activity extends Activity {
	
	Button button, button2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main7);
		addListenerOnButton();
	}

	
	public void addListenerOnButton() {

		final Context context = this;

		button = (Button) findViewById(R.id.button17);
		button2= (Button) findViewById(R.id.button27);
		

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App8Activity.class);
                startActivity(intent);   

			}

		});
		
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App6Activity.class);
                startActivity(intent);   

			}

		});

	}
	
	@Override
	public void onBackPressed() {
	}
}
