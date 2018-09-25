package com.androidsqlitesamples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteAdapter extends SQLiteOpenHelper
{
	private static final String DB = "Database.db";
	private static final String TABLE_NAME = "tbl_data";
	private static final String COL_1 = "id";
	private static final String COL_2 = "first_name";
	private static final String COL_3 = "last_name";
	private static final String COL_4 = "age";

	public SQLiteAdapter(Context ctx) {
		super(ctx, DB, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//this function will create a new table if tbl_data does not exists in the database
		db.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_NAME + "(" + COL_1 +" int(11) primary key autoincrement," + COL_2 + " char(24)" + COL_3 + " char(24)" + COL_4 + " int(2)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int recentData, int newData) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(db);
	}

	public boolean InsertData(String fname, String lname, int age) {
		SQLiteDatabase db = this.getWritetableDtabase();
		ContentValues cv = new ContentValues();
		cv.put(COL_2, fname);
		cv.put(COL_3, fname);
		cv.put(COL_4, age);
		long result = db.insert(TABLE_NAME, null, cv);
		if(result == -1) {
			return(false);
		}
		else {
			return(true);
		}
	}
}
