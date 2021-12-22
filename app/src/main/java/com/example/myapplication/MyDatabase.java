package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyDatabase extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "BaseName.db";
    public static  final int DATABASE_VERSION = 1;
    public static final  String TABLE_NAME = "m_person";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOM = "last_name";
    public static final String COLUMN_PRENOM = "first_name";


    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PRENOM + " TEXT, " +
                        COLUMN_NOM + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // drop the table :
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        // whenever we drop the table we need to create it ;
        onCreate(db);

    }
    void addPerson(String first_name,String last_name){
        SQLiteDatabase db = this.getWritableDatabase();
        // we need to create a Content Value for holding the data;
        ContentValues cv = new ContentValues();
        // then we put the data :
        cv.put(COLUMN_NOM,last_name);
        cv.put(COLUMN_PRENOM,first_name);
        long result =db.insert(TABLE_NAME,null,cv);
        if(result == -1 )
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully !", Toast.LENGTH_SHORT).show();
        }
    }

}