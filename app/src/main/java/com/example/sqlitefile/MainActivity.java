package com.example.sqlitefile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHandler mydb;
    DataModel usermodel;
    ListView mylv;
    int id;
    String  nama, password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHandler(this);

//        //addUser();

        try {

            showData();
            Log.d("SQLITE","get user data1");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

        public void addUser(){
            usermodel = new DataModel(2, "Andi2", "pass2");
            Log.d("SQLITE","AddUser data");
            mydb.insertUser(usermodel);


        }

    public void showData() throws JsonProcessingException {
        //int c = mydb.getDataCount();
        Log.d("SQLITE","AddUser data");
        List<DataModel> a = mydb.getAll();
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonString = mapper.writeValueAsString(a);
        //Log.d("SQLITE", jsonString);
        ArrayList<String> ar = new ArrayList<String>();

        for (int i = 0; i < a.size(); i++){
            id = a.get(i).getId();
            nama= a.get(i).getNama();
            password = a.get(i).getPassword();

            String my_users = "ID: "+id+"\n"+"Nama: "+nama+ "\n"+ "Password:" + password;
            ar.add(my_users);

            Log.d("SQLITE", my_users);

        }
        String MyData[] = ar.toArray(new String[3]);
        Log.d("SQLITE", String.valueOf(MyData));

        //Log.d("SQLITE", String.valueOf(MyData));




//        JSONArray jsonArr = null;
//        try {
//            Log.d("SQLITE","json array");
//            jsonArr = new JSONArray(jsonObject);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Log.d("SQLITE", String.valueOf(jsonArr));




        mylv = (ListView) findViewById(R.id.lv1);
        CustomAdapter cAdapter =
                new CustomAdapter(getApplicationContext(),MyData);
        mylv.setAdapter(cAdapter);
//        final ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1,
//                ar);
//        mylv.setAdapter(adapter);
//        Log.d("SQLITE","get user data3");
//        id[0]= Integer.parseInt(String.valueOf(a.get(0).Id));
//        Log.d("SQLITE","get user data4");
//        nama[0]= String.valueOf(a.get(0).nama);
//        password[0]= String.valueOf(a.get(0).password);
//        Log.d("SQLITE", String.valueOf(id[0]));
//        Log.d("SQLITE", nama[0]);
//        Log.d("SQLITE", password[0]);
        //ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonObject = mapper.writeValueAsString(a);
//            Log.d("SQLITE", jsonObject);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        //usermodel = new DataModel();


        //mylv = (ListView) findViewById(R.id.lv1);
        //List<DataModel> value =  mydb.getAll();

//
//        String MyData[] = new String[value.size()];
//        MyData = value.toArray(MyData);
//        Log.d("SQLITE", String.valueOf(MyData));

    }


    public void buttonClick(View view) {
        Intent i = new Intent(this, AdduserIntent.class);
        startActivity(i);
    }
}