package com.example.sqlitefile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="MyDB.sqlite";
    private static final String TB_NAME="Users";
    private static final String KEY_ID="id";
    private static final String KEY_NAMA="nama";
    private static final String KEY_PASS="password";

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context c) {
        super(c,DB_NAME,null,DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE "+TB_NAME+"("+KEY_ID+
                " INTEGER PRIMARY KEY,"+KEY_NAMA+" TEXT,"+
                KEY_PASS+" TEXT"+")";
        Log.d("SQLITE","Create DATABASE");
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
        onCreate(db);
    }

//        public  boolean insertUser(String nama, String password) {
//            SQLiteDatabase db = this.getWritableDatabase();
//            ContentValues cv = new ContentValues();
//            cv.put("nama",nama);
//            cv.put("password", password);
//            db.insert(TB_NAME,null,cv);
//            return true;
//        }

    public boolean insertUser(DataModel user) {
        Log.d("SQLITE","Inserting User");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAMA,user.getNama());
        cv.put(KEY_PASS,user.getPassword());
        db.insert(TB_NAME,null,cv);
        db.close();
        return true;
    }

    public int getDataCount(){
        String query = "SELECT * FROM "+ TB_NAME;
        SQLiteDatabase db =  this. getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        c.close();

        return c.getCount();
    }
    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM"+TB_NAME+
                " WHERE id="+id,null);
        return result;
    }
    public List<DataModel> getAll() throws JsonProcessingException {
        List<DataModel> userList = new ArrayList<DataModel>();
        String query = "SELECT * FROM "+ TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if (c.moveToFirst()) {
            do {
                DataModel u = new DataModel();
                //ObjectMapper mapper = new ObjectMapper();
                u.setId(Integer.parseInt(c.getString(0)));
                //Log.d("SQLITE",c.getString(0));
                u.setNama(c.getString(1));
                //Log.d("SQLITE",c.getString(1));
                u.setPassword(c.getString(2));
                //Log.d("SQLITE",c.getString(2));
                userList.add(u);
                //String jsonObject = mapper.writeValueAsString(u);

                //Log.d("SQLITE", jsonObject);
                //Log.d("SQLITE", String.valueOf(userList));
            } while (c.moveToNext());
        }
//        for (int i = 0; i < userList.size(); i++) {
//
//
//            Log.d("SQLITE", String.valueOf(userList.get(i)));
//
//        }
        return userList;


    }

}