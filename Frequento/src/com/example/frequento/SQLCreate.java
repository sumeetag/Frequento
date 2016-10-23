package com.example.frequento;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLCreate extends Activity implements OnClickListener {

	private EditText sqldate;
	private EditText sqlname;
	private EditText sqltask;
	private Button confirm;
	private Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlcreate);
		
		init();
		confirm.setOnClickListener(this);
		save.setOnClickListener(this);
		
	}

	private void init() {
		// TODO Auto-generated method stub
		sqldate = (EditText)findViewById(R.id.etDate);
		sqlname = (EditText)findViewById(R.id.etName);
		sqltask = (EditText)findViewById(R.id.etTask);
		confirm = (Button)findViewById(R.id.bConfirmtask);
		save = (Button)findViewById(R.id.bSavetask);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bConfirmtask:
			save.setVisibility(View.VISIBLE);
			break;

		case R.id.bSavetask:
			save.setVisibility(View.INVISIBLE);
			boolean diditwork = true;
			try {
				String date = sqldate.getText().toString();
				String name = sqlname.getText().toString();
				String task = sqltask.getText().toString();

				SQLDatabase entry = new SQLDatabase(SQLCreate.this);
				entry.open();
				entry.createEntry(date, name, task);
				entry.close();
			} catch (Exception e) {
				// TODO: handle exception
				diditwork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Not successful try again Pls..!!!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			} finally {
				if (diditwork) {
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yea!");
					TextView tv = new TextView(this);
					tv.setText("       success");
					d.setContentView(tv);
					d.show();
				}
			}
			break;
		}
	}
}
