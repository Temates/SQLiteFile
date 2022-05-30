 package com.example.sqlitefile;

import androidx.appcompat.app.AppCompatActivity;

 import android.content.Context;
 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.BaseAdapter;
 import android.widget.ImageView;
 import android.widget.TextView;


 public class CustomAdapter extends BaseAdapter {
     Context c;
     String myData[];


     LayoutInflater inflater;

     public CustomAdapter(Context c, String[] myData) {
         this.c = c;
         this.myData = myData;

         inflater = LayoutInflater.from(c);
     }



     @Override
     public int getCount() {
         return myData.length;
     }

     @Override
     public Object getItem(int position) {
         return null;
     }

     @Override
     public long getItemId(int position) {
         return 0;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
         convertView = inflater.inflate(R.layout.my_lvelement, null);

         TextView user1 = (TextView)  convertView.findViewById(R.id.tv1);
//         TextView user2 = (TextView)  convertView.findViewById(R.id.tv2);
//         TextView user3 = (TextView)  convertView.findViewById(R.id.tv3);
         user1.setText(myData[position]);
//         user2.setText(myData[position]);
//         user3.setText(myData[position]);

         return convertView;
     }
 }