package com.example.frequento;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends Activity implements OnClickListener {

	private ImageButton camera;
	private ImageView wall;
	private Button setWall;
	Intent i;
	final static int cameraData = 0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);

		init();
		InputStream is = getResources().openRawResource(R.drawable.wall);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void init() {
		// TODO Auto-generated method stub
		camera = (ImageButton) findViewById(R.id.ibCamera);
		wall = (ImageView) findViewById(R.id.ivWall);
		setWall = (Button) findViewById(R.id.bSetWall);
		camera.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSetWall:
			try {
				getApplicationContext().setWallpaper(bmp);
				Toast.makeText(getApplicationContext(), "Your WallPaper is set", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.ibCamera:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			wall.setImageBitmap(bmp);
		}
	}

}
