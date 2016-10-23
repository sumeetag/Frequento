package com.example.frequento;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Browser extends Activity implements OnClickListener {
	
	private WebView ourBrow;
	private EditText url;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		
		ourBrow = (WebView)findViewById(R.id.wvBrowser);
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		ourBrow.requestFocus(View.FOCUS_DOWN);
		ourBrow.setWebViewClient(new ourViewClient());
		try {
			ourBrow.loadUrl("https://www.google.co.in");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Button go = (Button)findViewById(R.id.bGo);
		Button back = (Button)findViewById(R.id.bBackPage);
		Button refresh = (Button)findViewById(R.id.bRefresh);
		Button forward = (Button)findViewById(R.id.bForward);
		Button clear = (Button)findViewById(R.id.bHistory);
		url = (EditText)findViewById(R.id.etURL);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		forward.setOnClickListener(this);
		clear.setOnClickListener(this);
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ourBrow.requestFocus(View.FOCUS_DOWN);
		switch (v.getId()) {
		case R.id.bGo:
			String theWebsite = url.getText().toString();
			ourBrow.loadUrl("https://www."+theWebsite);
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(),0);
			break;
		case R.id.bBackPage:
			if(ourBrow.canGoBack()){
			ourBrow.goBack();
			}else{
				Toast.makeText(getApplicationContext(), "cant go back", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.bRefresh:
			ourBrow.reload();
			break;
		case R.id.bForward:
			if(ourBrow.canGoForward()){
				ourBrow.goForward();
			}else{
				Toast.makeText(getApplicationContext(), "cant go forward", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.bHistory:
			ourBrow.clearHistory();
			break;
		}
	}
	

}
