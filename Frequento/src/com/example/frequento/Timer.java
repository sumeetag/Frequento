package com.example.frequento;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Timer extends Activity{

	private EditText input;
	private TextView counter;
	private Button set;
	private String in;
	private int j;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);
		
		input=(EditText)findViewById(R.id.editText1);
		counter=(TextView)findViewById(R.id.textView1);
		set=(Button)findViewById(R.id.button1);
		set.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (counter.getText().toString().contentEquals("00:00")) {
					in = input.getText().toString();
					j = Integer.parseInt(in);
					j = j * 1000 * 60;
					new CountDownTimer(j, 1000) {

						public void onTick(long millisUntilFinished) {
							counter.setText(" " + millisUntilFinished / 1000);
						}

						public void onFinish() {
							counter.setText("done!");
						}
					}.start();
				} else if (counter.getText().toString().contentEquals("done!")) {
					counter.setText("00:00");
				}
			}
			

		} );
		
	}
	
}
