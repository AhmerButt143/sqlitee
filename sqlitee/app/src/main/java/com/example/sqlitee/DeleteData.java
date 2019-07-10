package com.example.sqlitee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {
EditText number;
Button delete;
DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        delete=(Button)findViewById(R.id.btnDelete);
        number=(EditText)findViewById(R.id.etNumber);

        dataBaseHelper=new DataBaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             dataBaseHelper.deleteData(number.getText().toString());
                Toast.makeText(DeleteData.this,"record deletted",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
