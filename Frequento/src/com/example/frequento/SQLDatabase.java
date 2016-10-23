package com.example.frequento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Html;

public class SQLDatabase {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_DATE = "task_date";
	public static final String KEY_NAME = "task_name";
	public static final String KEY_ABOUT = "task_info";
	
	private static final String DATABASE_NAME="Todolistdb";
	private static final String DATABASE_TABLE = "peopleTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase; 
	
	private static class DbHelper extends SQLiteOpenHelper{
		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					KEY_DATE + " TEXT NOT NULL, " +
					KEY_NAME + " TEXT NOT NULL, " + KEY_ABOUT + " TEXT NOT NULL);"
					);
		}
			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				// TODO Auto-generated method stub
				db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
				onCreate(db);
		}
	}
	
	public SQLDatabase(Context c){
		ourContext = c;
	}
	public SQLDatabase open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}
	public long createEntry(String date, String name, String about) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_DATE, date);
		cv.put(KEY_NAME, name);
		cv.put(KEY_ABOUT, about);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	
	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_NAME, KEY_ABOUT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iDate = c.getColumnIndex(KEY_DATE);
		int iName = c.getColumnIndex(KEY_NAME);
		int iAbout = c.getColumnIndex(KEY_ABOUT);
		
		
		for( c.moveToFirst();!c.isAfterLast(); c.moveToNext()){
			result = result + "  " + Html.fromHtml("<b>" + c.getString(iRow) + "</b>") + " \t \t " + Html.fromHtml("<b>" + c.getString(iDate) + "</b>") + " \t \t \t \t \t \t " +  Html.fromHtml("<.bold><i>" + c.getString(iName) + "</i><./bold>") + "\n Task:  " + c.getString(iAbout) + "\n\n";
		}
		
		return result;
	}
	
	public String getDate(long l, int path)throws SQLException {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_NAME, KEY_ABOUT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, columns[path] + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}
	
	public String getName(long l, int path)throws SQLException {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_NAME, KEY_ABOUT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, columns[path] + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String name = c.getString(2);
			return name;
		}
		return null;
	}

	public String getTask(long l , int path)throws SQLException {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_NAME, KEY_ABOUT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, columns[path] + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String hotness = c.getString(3);
			return hotness;
		}
		return null;
	}
	
	public long getId(long l , int path)throws SQLException {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_NAME, KEY_ABOUT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, columns[path] + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			long id = c.getLong(0);
			return id;
		}
		return l;
	}
	
	public void updateEntry(long lRow, String date, String name, String about)throws SQLException {
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_DATE, date);
		cvUpdate.put(KEY_NAME, name);
		cvUpdate.put(KEY_ABOUT, about);
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);
	}
	
	public void deleteEntry(long lRow1, int path)throws SQLException {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_NAME, KEY_ABOUT};
		ourDatabase.delete(DATABASE_TABLE, columns[path] + "=" + lRow1, null);
	}
	
	public void deleteFull()throws SQLException {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, null, null);
	}
}
