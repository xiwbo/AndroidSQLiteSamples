package com.androidsqlitesamples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter extends SQLiteOpenHelper
{
	private static final String DB = "Database.db";
	private static final String TABLE_NAME = "tbl_data";
	private static final String COL_1 = "id";
	private static final String COL_2 = "first_name";
	private static final String COL_3 = "last_name";
	private static final String COL_4 = "age";

	public DatabaseAdapter(Context ctx) {
		super(ctx, DB, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_NAME + "(" + COL_1 +" int(11) primary key autoincrement," + COL_2 + " char(24)" + COL_3 + " char(24)" + COL_4 + " int(2)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int recentData, int newData) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(db);
	}

	public boolean insertData(String fname, String lname, int age) {
		SQLiteDatabase db = this.getWritableDatabase();
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

	public Cursor getData(String id) {
		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE ID='" + id + "'";
		Cursor cursor = db.rawQuery(query, null);
		return(cursor);
	}

	public boolean updateData(String id,String fname, String lname, int age) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(COL_1, id);
		cv.put(COL_2, fname);
		cv.put(COL_3, fname);
		cv.put(COL_4, age);
		db.update(TABLE_NAME, cv, "ID=?", new String[]{id});
		return(true);
	}

	public Integer deleteData(String id) {
		SQLiteDatabase db = this.getWritableDatabase();
		return(db.delete(TABLE_NAME, "ID=?", new String[]{id}));
	}

	public Cursor getAllData() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery( "SELECT * FROM " + TABLE_NAME, null);
		return(cursor);
	}
}
