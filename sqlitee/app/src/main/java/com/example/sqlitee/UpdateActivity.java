package com.example.sqlitee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
EditText number,email,name;
Button update;
DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dataBaseHelper =new DataBaseHelper(this);

        number=(EditText)findViewById(R.id.etNumber);
        email=(EditText)findViewById(R.id.etEmail);
        name=(EditText)findViewById(R.id.etName);
        update=(Button)findViewById(R.id.btnupdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
dataBaseHelper.updaateData(number.getText().toString(),name.getText().toString(),email.getText().toString());
            }
        });
    }
}
