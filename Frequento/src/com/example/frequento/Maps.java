package com.example.frequento;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Maps extends Activity {
	
	private final String TAG = "MapLocation";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
		
		final EditText addrText = (EditText) findViewById(R.id.etmaps);
		final Button button = (Button) findViewById(R.id.bmaps);
		
		button.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					String address = addrText.getText().toString();
					address = address.replace(' ', '+');
					Intent geoIntent = new Intent(
							android.content.Intent.ACTION_VIEW, Uri
									.parse("geo:0,0?q=" + address));
					startActivity(geoIntent);
				} catch (Exception e) {
					Log.e(TAG, e.toString());
				}
			}
				
			
		});
	}
}
