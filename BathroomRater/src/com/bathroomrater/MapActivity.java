package com.bathroomrater;

import java.util.ArrayList;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.*;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MapActivity extends ActionBarActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		// users picture
		int userImage = R.drawable.ic_launcher;
		// Bathroom Picture
		int bathroomImage = R.drawable.ic_launcher;
		
		// got to get all the data from the somewhere
		// TODO:
		int numb = 1;
		
		final ArrayList<MarkerOptions> bathrooms = new ArrayList<MarkerOptions>();
		
		 for (int i = 0; i < numb; i++) {
			 
			 double lat = 1, lng = 1;
			 
			 bathrooms.add(new MarkerOptions()
			 .icon(BitmapDescriptorFactory.fromResource(bathroomImage)) // picture for the bathroom
             .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
             .position(new LatLng(lat, lng))
        	 .title("Bathroom name")
             .snippet("Avg: " + 5)
					 );
		 }
		
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
        
        final Intent intent = new Intent(this, BathroomActivity.class);
        
        // make sure your location isn't empty
        if (location != null) {
        	
        	// make the person marker
        	 MarkerOptions user = new MarkerOptions()
             .icon(BitmapDescriptorFactory.fromResource(userImage)) // picture for the user
             .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
             .position(new LatLng(location.getLatitude(), location.getLongitude()))
        	 .title("You")
             .snippet("Your position");
             
        	 // add the markers
             map.addMarker(user);
             for (int j = 0; j < bathrooms.size(); j++) {
            	 map.addMarker(bathrooms.get(j));
             }
             
        	 
        	 // move to the person
             map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                     new LatLng(location.getLatitude(), location.getLongitude()), 19));
             
             // Map onclick stuff
             map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

				@Override
				public void onInfoWindowClick(Marker arg0) {
					if (arg0.getTitle().compareTo("You") != 0) { // nothing happens on the user
					intent.putExtra("BathroomName", arg0.getTitle());
					startActivity(intent);
					}
				}
            	 
             });
             
             
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
