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

public class GetInfo extends Activity implements OnItemSelectedListener, OnClickListener {
	
	private int path;
	private Spinner spinner;
	
	String[] paths = {"Id","Date","Task Name"};
	private EditText et;
	private TextView tv;
	boolean diditwork = true;
	private Button b;
	private Button edit;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private EditText etdate;
	private EditText etname;
	private EditText ettask;
	private String returnedDate;
	private String returnedTask;
	private String returnedName;
	private long returnedId;
	private Button bedit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.getinfo);
		
		init();
		
		tv.setText(" ");
		b.setOnClickListener(this);
		edit.setOnClickListener(this);
		bedit.setOnClickListener(this);
		
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,paths);
		
		spinner=(Spinner)findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

	}

	private void init() {
		// TODO Auto-generated method stub
		tv = (TextView)findViewById(R.id.tvDisplayinfo);
		et = (EditText)findViewById(R.id.etGetinfo);
		b = (Button)findViewById(R.id.bgetinfo);
		edit = (Button)findViewById(R.id.bedit);
		tv1 = (TextView)findViewById(R.id.tvDate);
		tv2 = (TextView)findViewById(R.id.tvname);
		tv3 = (TextView)findViewById(R.id.tvtask);
		etdate = (EditText)findViewById(R.id.etdisplaydate);
		etname = (EditText)findViewById(R.id.etdisplayname);
		ettask = (EditText)findViewById(R.id.etdisplaytask);
		bedit = (Button)findViewById(R.id.bconfirmedit);
		tv1.setVisibility(View.GONE);
		tv2.setVisibility(View.GONE);
		tv3.setVisibility(View.GONE);
		etdate.setVisibility(View.GONE);
		etname.setVisibility(View.GONE);
		ettask.setVisibility(View.GONE);
		bedit.setVisibility(View.GONE);
		
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
		tv.setText("");
		
		switch (v.getId()) {
		case R.id.bgetinfo:
			try {
				String s = et.getText().toString();
				long l = Long.parseLong(s);
				SQLDatabase hon = new SQLDatabase(this);
				hon.open();
				returnedDate = hon.getDate(l,path);
				returnedName = hon.getName(l,path);
				returnedTask = hon.getTask(l,path);
				returnedId = hon.getId(l, path);
				hon.close();
				tv.setText(" \t Date: " + returnedDate + " \t \t \t \t Task: " + returnedName +  "\n About Task:  " + returnedTask);
				
			} catch (Exception e) {
				// TODO: handle exception
				diditwork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("ho shit!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}
			break;

		case R.id.bedit:
			tv.setVisibility(View.GONE);
			tv1.setVisibility(View.VISIBLE);
			tv2.setVisibility(View.VISIBLE);
			tv3.setVisibility(View.VISIBLE);
			etdate.setVisibility(View.VISIBLE);
			etname.setVisibility(View.VISIBLE);
			ettask.setVisibility(View.VISIBLE);
			bedit.setVisibility(View.VISIBLE);
			etdate.setText(returnedDate);
			etname.setText(returnedName);
			ettask.setText(returnedTask);
			edit.setVisibility(View.GONE);
			
			break;
			
		case R.id.bconfirmedit:
			
			try {
				String date = etdate.getText().toString();
				String name = etname.getText().toString();
				String task = ettask.getText().toString();
				SQLDatabase ex = new SQLDatabase(this);
				ex.open();
				ex.updateEntry(returnedId, date, name , task);
				ex.close();
				Toast.makeText(getApplicationContext(), "Data updated",
						Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				// TODO: handle exception
				diditwork = false;
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
