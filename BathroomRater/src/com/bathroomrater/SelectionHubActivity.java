package com.bathroomrater;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SelectionHubActivity extends ActionBarActivity {

	private String uni;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection_hub);
		
		Intent intent = getIntent();
		this.uni = intent.getStringExtra(UniversitySelectActivity.UNIVERSITY);
		
		TextView uni_textview = (TextView)findViewById(R.id.selhub_textview);
		uni_textview.setText(this.uni);
		
		/*
		// Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(uni);
	    
	    textView.setLayoutParams(new RelativeLayout.LayoutParams(
	                                         RelativeLayout.LayoutParams.WRAP_CONTENT,
	                                         RelativeLayout.LayoutParams.WRAP_CONTENT));

	    //android:layout_alignParentTop="true"
	    //android:layout_centerHorizontal="true"
	    
	    this.addView(textView);

	    // Set the text view as the activity layout
	    setContentView(textView);
	    */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selection_hub, menu);
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
	
	public void addBathroom(View view){
		Intent intent = new Intent(this, AddBathroom.class);
		
		//Pass the university data to next activity
		intent.putExtra(UniversitySelectActivity.UNIVERSITY, this.uni);
		
		startActivity(intent);
	}
}
