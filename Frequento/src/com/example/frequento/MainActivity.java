package com.example.frequento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button camera;
	private Button maps;
	private Button browser;
	private Button calc;
	private Button todo;
	private Button timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ini();
		camera.setOnClickListener(this);
		maps.setOnClickListener(this);
		browser.setOnClickListener(this);
		calc.setOnClickListener(this);
		todo.setOnClickListener(this);
		timer.setOnClickListener(this);

	}

	private void ini() {
		// TODO Auto-generated method stub
		camera = (Button) findViewById(R.id.bCamera);
		maps = (Button) findViewById(R.id.bMaps);
		browser = (Button) findViewById(R.id.bBrowser);
		
		calc = (Button) findViewById(R.id.bCalc);
		todo = (Button) findViewById(R.id.bTodo);
		timer = (Button) findViewById(R.id.bTimer);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bBrowser:
			Intent i = new Intent();
			i.setClass(MainActivity.this, Browser.class);
			startActivity(i);
			break;
		case R.id.bCamera:
			Intent icamera = new Intent();
			icamera.setClass(MainActivity.this, Camera.class);
			startActivity(icamera);
			break;
		case R.id.bMaps:
			Intent imaps = new Intent();
			imaps.setClass(MainActivity.this, Maps.class);
			startActivity(imaps);
			break;
		case R.id.bCalc:
			Intent icalc = new Intent();
			icalc.setClass(MainActivity.this, Calculator.class);
			startActivity(icalc);
			break;
		case R.id.bTodo:
			Intent itodo = new Intent();
			itodo.setClass(MainActivity.this, Todolist.class);
			startActivity(itodo);
			break;
		case R.id.bTimer:
			Intent itimer = new Intent();
			itimer.setClass(MainActivity.this, Timer.class);
			startActivity(itimer);
			break;
		}
	}

}
