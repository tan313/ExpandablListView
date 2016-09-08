package com.example.expandablelistviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {

	private ExpandableListView mExpandableListView;
	private ExpandableAdapter mExpandableAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mExpandableListView = (ExpandableListView) findViewById(R.id.id_expandablelv);
		mExpandableAdapter = new ExpandableAdapter(this);
		mExpandableListView.setAdapter(mExpandableAdapter);
	}
}
