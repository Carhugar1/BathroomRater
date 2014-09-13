package com.bathroomrater;

import java.util.ArrayList;
import java.util.Collections;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class UniversitySelectActivity extends ActionBarActivity {
	
	private ListView uni_listview;

	/**
	 * Setup university list
	 * Used info from
	 * http://stackoverflow.com/questions/5070830/populating-a-listview-using-arraylist
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_university_select);
		
		uni_listview = (ListView) findViewById(R.id.listView1);
		
		ArrayList<String> uni_arrlist = new ArrayList<String>();
		
		//TODO Fetch Universities list from Firebase
		uni_arrlist.add("Iowa State University");
		uni_arrlist.add("Some other place");
		uni_arrlist.add("Meh");
		
		//Sort list of universities
		Collections.sort(uni_arrlist);
		
		//TODO Setup listView1 to contain universities
				
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                 this, 
                 android.R.layout.simple_list_item_1,
                 uni_arrlist );

         uni_listview.setAdapter(arrayAdapter); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.university_select, menu);
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
