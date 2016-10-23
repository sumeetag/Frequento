package com.example.frequento;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SQLDelete extends Activity implements OnItemSelectedListener, OnClickListener {


	private Spinner spinner;
	
	String[] paths = {"Id","Date","Task Name"};

	private int path;

	private EditText et;

	private Button b;

	private Button bdel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqldelete);
		init();
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,paths);
		
		spinner=(Spinner)findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		b.setOnClickListener(this);
		bdel.setOnClickListener(this);
		
		
	}
	private void init() {
		// TODO Auto-generated method stub
		et = (EditText)findViewById(R.id.etdelete);
		b = (Button)findViewById(R.id.bdelete);
		bdel = (Button)findViewById(R.id.bfulldelete);
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int position = spinner.getSelectedItemPosition();
		switch (position) {
		case 0:
			path = 0;
			break;
		case 1:
			path = 1;
			break;
		case 2:
			path = 2;
			break;
		}
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bdelete:
			try {
				String sRow1 = et.getText().toString();
				long lRow1 = Long.parseLong(sRow1);
				SQLDatabase ex1 = new SQLDatabase(this);
				ex1.open();
				ex1.deleteEntry(lRow1,path);
				ex1.close();
				Toast.makeText(getApplicationContext(), "Data deleted",
						Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				// TODO: handle exception
				
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("ho shit!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}
			break;

		case R.id.bfulldelete:
			try {
				SQLDatabase ex1 = new SQLDatabase(this);
				ex1.open();
				ex1.deleteFull();
				ex1.close();
				Toast.makeText(getApplicationContext(), "Fully Deleted",
						Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				// TODO: handle exception
				
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("ho shit!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}
			break;
		}
	}
}
