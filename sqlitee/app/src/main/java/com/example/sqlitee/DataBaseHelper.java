package com.example.sqlitee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

private  static final String DATABASE_NAME= "contacts.db";
    private  static final String TABEL_NAME= "contacts";
//private static final int VERSION=
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);




    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE "+TABEL_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABEL_NAME);
    onCreate(db);
    }

    public boolean insertData(String name,int mobile_number,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("MOBILE_NUMBER",mobile_number);
        contentValues.put("EMAIL",email);
       long result= db.insert(TABEL_NAME,null,contentValues);
        db.close();

       if(result==-1)
           return false;
       else
           return true;
    }

       public Cursor getData(String mobile_number)
        {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+ TABEL_NAME + "WHERE MOBILE_NUMBER= " + mobile_number +"'";
        Cursor cursor=db.rawQuery(query,null);

        return cursor;


        }

        public void deleteData(String mobile_number)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete(TABEL_NAME," MOBILE_NUMBER= '"+ mobile_number+ "'",null);

        }
        public void updaateData(String number,String name,String email)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("NAME",name);
            contentValues.put("EMAIL",email);
            db.update(TABEL_NAME,contentValues,"MOBILE_NUMBER='"+number+"'",null);
            db.close();
         }



}
