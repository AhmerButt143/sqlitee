package com.example.sqlitee;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {
EditText searchtext;
Button search;
TextView name,email;
DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);
        searchtext=(EditText)findViewById(R.id.etmobilenumber);
        search=(Button)findViewById(R.id.btnsearch);
        name=(TextView)findViewById(R.id.tvname);
        email=(TextView)findViewById(R.id.tvemail);
        dataBaseHelper=new DataBaseHelper(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Cursor curser=dataBaseHelper.getData(searchtext.getText().toString());
             name.setText(" ");
             email.setText(" ");

             while (curser.moveToNext())
             {
                 name.setText(curser.getString(1));
                 name.setText(curser.getString(3));
             }
            }
        });



    }
}
