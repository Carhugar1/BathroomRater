package com.bathroomrater;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class UniversitySelectActivity extends ActionBarActivity {
	
	private ListView uni_listview;
	
	private Intent intent;
	
	public final static String UNIVERSITY = "com.BathroomRater.UniversitySelectActivity.UNIVERSITY";

	/**
	 * Setup university list
	 * Used info from
	 * http://stackoverflow.com/questions/5070830/populating-a-listview-using-arraylist
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_university_select);
		
		intent = new Intent(this, SelectionHubActivity.class);
		
		uni_listview = (ListView) findViewById(R.id.listView1);
		
		ArrayList<String> uni_arrlist = new ArrayList<String>();
		
		//TODO Fetch Universities list from Firebase
		uni_arrlist.add("Iowa State University");
		uni_arrlist.add("Some other place");
		uni_arrlist.add("Meh");
		uni_arrlist.add("sdfsd");
		uni_arrlist.add("sdafgdfgh");
		uni_arrlist.add("iutygjg");
		uni_arrlist.add("hmnfdnfdgb");
		uni_arrlist.add("vfvdsf");
		uni_arrlist.add("ytytrdye");
		uni_arrlist.add("erthghcg");
		uni_arrlist.add("nbvcnhmhg");
		uni_arrlist.add("dhgrdtynh");
		
		//Sort list of universities
		Collections.sort(uni_arrlist);
		
		//TODO Setup listView1 to contain universities
				
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                 this, 
                 android.R.layout.simple_list_item_1,
                 uni_arrlist );

		uni_listview.setAdapter(arrayAdapter); 
         
		// ListView Item Click Listener
		uni_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 
			// ListView Clicked item value
			String  itemValue    = (String) uni_listview.getItemAtPosition(position);
			
			intent.putExtra(UNIVERSITY, itemValue);
			
			startActivity(intent);
			}
		});
			

		
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
