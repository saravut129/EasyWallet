package com.example.easywallet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 10/12/2560.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "money.db";
    private static final int DATABASE_VERSION = 9;

    public static final String TABLE_NAME_ONE = "money_number1";

    public static final String COL_ID = "_id";
    public static final String COL_DETAILS = "details";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_PICTURE = "picture";

    private static final String CREATE_TABLE_ONE = "CREATE TABLE " + TABLE_NAME_ONE + "("
            + COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_DETAILS + " TEXT, "
            + COL_DETAILS + " TEXT, "
            + COL_PICTURE + " TEXT)";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ONE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db){
        ContentValues cv = new ContentValues();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ONE);
        onCreate(db);
    }
}
