package com.android.triage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	
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
		setContentView(R.layout.activity_main);
		
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
		                        break;

		                    case 1:
		                        //Triage Primario

		                        intent =  new Intent(MainActivity.this, App2Activity.class);
		                        startActivity(intent);
		                        finish();
		                        break;

		                    case 2:
		                    	//Triage Secundario

		                    	intent =  new Intent(MainActivity.this, App9Activity.class);
		                    	startActivity(intent);
		                        finish();
		                        break;

		                    case 3:
		                    	//Triage Terciario
		                    	
		                    	intent =  new Intent(MainActivity.this, App14Activity.class);
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
		

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Advertencia");
		builder.setMessage("Está seguro que desea salir de la aplicación")
				.setCancelable(false)
				.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						MainActivity.this.finish();
						MainActivity.this.moveTaskToBack(true);
						
					}
				})
				.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});
		AlertDialog alert = builder.create();
		
		//set up image view
        alert.setIcon(R.drawable.ic_info);
		alert.show();
	}
}