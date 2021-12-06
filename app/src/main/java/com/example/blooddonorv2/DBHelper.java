package com.example.blooddonorv2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME= "BloodDonor.db";
    //THis is for test
    public DBHelper(Context context) {
        super(context, "BloodDonor.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key,password TEXT, contact TEXT, status TEXT, country TEXT, bloodgroup TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }
    public boolean insertData(String username, String password,String contact,String status, String country, String bloodgroup)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("contact",contact);
        contentValues.put("status",status);
        contentValues.put("country",country);
        contentValues.put("bloodgroup",bloodgroup);

        long result  = MyDB.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public boolean checkUsername(String username)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?" , new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkUsernameAndPassword(String username, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password =?",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;

    }
}
