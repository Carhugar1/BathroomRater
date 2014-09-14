package com.bathroomrater;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddBathroom extends ActionBarActivity implements OnItemSelectedListener {
	private Spinner buildingSpinner;
	private Spinner floorsSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_bathroom);
		
		setupBuildings();
		setupFloors();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_bathroom, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void setupBuildings() {
		//Fetch buildings from Firebase (temporary)
		ArrayList<String> buildings = new ArrayList<String>();
		buildings.add("Carver");
		buildings.add("Coover");
		buildings.add("Hoover");
		
		buildingSpinner = (Spinner) findViewById(R.id.buildings_spinner);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_spinner_item,
				buildings);
		
		buildingSpinner.setAdapter(adapter);
		
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		buildingSpinner.setAdapter(adapter);
	}
	
	private void setupFloors() {
		//Fetch buildings from Firebase (temporary)
		ArrayList<String> floors = new ArrayList<String>();
		floors.add("1");
		floors.add("2");
		floors.add("3");
		floors.add("4");
		
		floorsSpinner = (Spinner) findViewById(R.id.floors_spinner);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_spinner_item,
				floors);
		
		floorsSpinner.setAdapter(adapter);
		
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		floorsSpinner.setAdapter(adapter);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int arg2,
			long arg3) {
		//Blank I guess
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
