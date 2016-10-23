package com.example.frequento;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Todolist extends ListActivity {

	String menu[] = { "Create" , "View" , "Info" , "Delete" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		if(position==0){
			Intent i = new Intent();
			i.setClass(this, SQLCreate.class);
			startActivity(i);
			
		}
		if(position==1){
			Intent i = new Intent();
			i.setClass(this, SQLView.class);
			startActivity(i);
			
		}
		if(position==2){
			Intent i = new Intent();
			i.setClass(this, GetInfo.class);
			startActivity(i);
			
		}
		if(position==3){
			Intent i = new Intent();
			i.setClass(this, SQLDelete.class);
			startActivity(i);
			
		}
	}
}
