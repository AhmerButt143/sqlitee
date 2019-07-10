package com.example.sqlitee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
DataBaseHelper databaseHelper;
Button insert,searchData,btnDelete,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DataBaseHelper(this);
        insert=(Button)findViewById(R.id.btnadd);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNewContact.class);
                startActivity(intent);

            }
        });
         searchData=(Button)findViewById(R.id.btnsearch);
         searchData.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this,SearchData.class);
                 startActivity(intent);
             }
         });
        btnDelete=(Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DeleteData.class);
                startActivity(intent);
            }
        });

        update=(Button)findViewById(R.id.btnupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}
