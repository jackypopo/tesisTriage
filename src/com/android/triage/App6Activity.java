package com.android.triage;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class App6Activity extends Activity {
	
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main6);
		addListenerOnButton();
	}

	
	
	public void addListenerOnButton() {

		final Context context = this;

		button = (Button) findViewById(R.id.button16);
		

		button.setOnClickListener(new OnClickListener() {

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
