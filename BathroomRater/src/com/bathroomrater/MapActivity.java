package com.bathroomrater;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MapActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		// got to get all the data from the somewhere
		// TODO:
		
		
		// get the dropdown floor selection
		Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{"1", "2", "three"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
		// dropdown.setOnClickListener(null);
		
		// get the Google Map
		GoogleMap map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();
		
		// get the location manager and Criteria
		LocationManager locationManager = 
				(LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();

		// get the last known location
        Location location = locationManager.getLastKnownLocation(
        		locationManager.getBestProvider(criteria, false));
        
        // make sure its not empty
        if (location != null) {
        	
        	// make the person marker
        	 MarkerOptions user = new MarkerOptions();
             user.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)); // picture ic_launcher
             user.anchor(0.0f, 1.0f); // Anchors the marker on the bottom left
             user.position(new LatLng(location.getLatitude(), location.getLongitude()));
        	 
        	 // add the markers
             map.addMarker(user);
        	 
        	 // move to the person
             map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                     new LatLng(location.getLatitude(), location.getLongitude()), 19));
             
             
        }       
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
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
}
