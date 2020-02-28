package com.example.facebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String Db_Name= "students.db";



    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Db_Name, null, 1);
        SQLiteDatabase db= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table tbl_student (id integer primary key autoincrement, name text, age integer, marks integer)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_student");
        onCreate(db);
    }

    public String addRecords(String name, String age, String marks){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("age",age);
        cv.put("marks",marks);

        long data = db.insert("tbl_student",null,cv);
        if(data== -1){
            return "Fail";
        }else{
            return "success";
        }

    }


}
