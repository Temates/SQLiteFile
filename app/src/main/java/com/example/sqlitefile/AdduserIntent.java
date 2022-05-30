package com.example.sqlitefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdduserIntent extends AppCompatActivity {
    TextView tv1, tv2;
    EditText et1, et2;
    Button bt1;
    DataModel usermodel;
    DBHandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser_intent);
        mydb = new DBHandler(this);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        bt1 = (Button) findViewById(R.id.bt1);
    }


    public void addUser(View view) {
        if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty())//check whether the entered text is not null
        {
            Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
        } else
        {
            String nama = et1.getText().toString();
            String password = et2.getText().toString();
            usermodel = new DataModel(0,nama ,password );
            Log.d("SQLITE", nama);
            Log.d("SQLITE", password);
            mydb.insertUser(usermodel);
            Intent o = new Intent(this, MainActivity.class);
            startActivity(o);
        }


    }


}