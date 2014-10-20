package com.android.triage;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class App9Activity extends Activity {

	Button button, button2, head;
	
	int mPosition = -1;	
	String mTitle = "";
	
	// Array of strings storing country names
    String[] mCountries ;
    
    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] mFlags = new int[]{
                R.drawable.ic_home,
                R.drawable.ic_first,
                R.drawable.ic_second,
                R.drawable.ic_third,
                R.drawable.ic_info
                
    };

    // Array of strings to initial counts
    String[] mCount = new String[]{
        "", "", "", "", "", 
        "", "", "", "", "" };
	
	private DrawerLayout mDrawerLayout;	
	private ListView mDrawerList;	
	private ActionBarDrawerToggle mDrawerToggle;	
	private LinearLayout mDrawer ;	
	private List<HashMap<String,String>> mList ;	
	private SimpleAdapter mAdapter;	
	final private String COUNTRY = "country";	
	final private String FLAG = "flag";	
	final private String COUNT = "count";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main9);
		addListenerOnButton();
		
		// Getting an array of country names
				mCountries = getResources().getStringArray(R.array.car_parts);
				
				// Title of the activity
				mTitle = (String)getTitle();
				
				// Getting a reference to the drawer listview
				mDrawerList = (ListView) findViewById(R.id.drawer_list);
				
				// Getting a reference to the sidebar drawer ( Title + ListView )
				mDrawer = ( LinearLayout) findViewById(R.id.drawer);
				
				// Each row in the list stores country name, count and flag
		        mList = new ArrayList<HashMap<String,String>>();

		        
		        for(int i=0;i<5;i++){
		            HashMap<String, String> hm = new HashMap<String,String>();
		            hm.put(COUNTRY, mCountries[i]);
		            hm.put(COUNT, mCount[i]);
		            hm.put(FLAG, Integer.toString(mFlags[i]) );
		            mList.add(hm);
		        }

		        // Keys used in Hashmap
		        String[] from = { FLAG,COUNTRY,COUNT };

		        // Ids of views in listview_layout
		        int[] to = { R.id.flag , R.id.country};

		        // Instantiating an adapter to store each items
		        // R.layout.drawer_layout defines the layout of each item
		        mAdapter = new SimpleAdapter(this, mList, R.layout.drawer_layout, from, to);
		        
		        // Getting reference to DrawerLayout
		        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);        
		        
		        // Creating a ToggleButton for NavigationDrawer with drawer event listener
		        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer , R.string.drawer_open,R.string.drawer_close){
		        	
		        	 /** Called when drawer is closed */
		            public void onDrawerClosed(View view) {          
		            }

		            /** Called when a drawer is opened */
		            public void onDrawerOpened(View drawerView) {               
		            }
		        };
		        
		        // Setting event listener for the drawer
		        mDrawerLayout.setDrawerListener(mDrawerToggle);
		        
		        // ItemClick event handler for the drawer items
		        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int position,
							long arg3) {
						
								
							Toast.makeText(getApplicationContext(), mCountries[position], Toast.LENGTH_LONG).show();
							
							 Intent intent = null;
				                switch (position) {

				                    case 0:
				                        //Inicio
				                    	 intent =  new Intent(App9Activity.this, MainActivity.class);
					                     startActivity(intent);
					                     finish();
				                        break;

				                    case 1:
				                        //Triage Primario

				                        intent =  new Intent(App9Activity.this, App2Activity.class);
				                        startActivity(intent);
				                        finish();
				                        break;

				                    case 2:
				                    	//Triage Secundario
				                        break;

				                    case 3:
				                    	//Triage Terciario
				                    	 intent =  new Intent(App9Activity.this, App14Activity.class);
					                     startActivity(intent);
					                     finish();

				                        break;
				                   
				                    case 4:
				                    	//Informe Medico
				                    	
				                  
				                        break;
				                }
						
						
						// Closing the drawer
						mDrawerLayout.closeDrawer(mDrawer);		
					}
				});
		        
		        
		        // Enabling Up navigation
		        getActionBar().setDisplayHomeAsUpEnabled(true);     
		        
		        getActionBar().setDisplayShowHomeEnabled(true);        

		        // Setting the adapter to the listView
		        mDrawerList.setAdapter(mAdapter);
	}

	public void addListenerOnButton() {

		final Context context = this;

		button = (Button) findViewById(R.id.button19);
		button2= (Button) findViewById(R.id.button29);
		head =(Button) findViewById(R.id.HeadMaleFront);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, App10Activity.class);
                startActivity(intent);   
			}
		});
		
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(context, App11Activity.class);
                startActivity(intent);   

			}

		});
		
		head.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Cabeza", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context, App13Activity.class);
                startActivity(intent);
				
				
			}
		});
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	    }
		return super.onOptionsItemSelected(item);
	}	
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	
	// Highlight the selected country : 0 to 4
	public void highlightSelectedCountry(){
		int selectedItem = mDrawerList.getCheckedItemPosition();
    	mPosition = selectedItem;
    	
    	
	}
	
	@Override
	public void onBackPressed() {
	}
}
