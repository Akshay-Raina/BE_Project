package com.example.ankurjangra.be_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ankur Jangra on 26-12-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="First_Name";
    public static final String COL_2="Last_Name";
    public static final String COL_3="Phone_No";
    public static final String COL_4="Email_Id";
    public static final String COL_5="UserName";
    public static final String COL_6="Password";
    public static final String COL_7="DOB";
    public static final String COL_8="Address";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_NAME+"(First_Name TEXT,Last_Name TEXT,Phone_No INTEGER,Email_Id TEXT,UserName TEXT PRIMARY KEY,Password TEXT,DOB TEXT,Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

}
