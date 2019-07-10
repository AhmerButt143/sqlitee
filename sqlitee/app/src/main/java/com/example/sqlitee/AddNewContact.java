package com.example.sqlitee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;
    EditText name,mobile_number,email;
Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        name=(EditText) findViewById(R.id.etname);
        mobile_number=(EditText)findViewById(R.id.etmobilenumber);
        email=(EditText)findViewById(R.id.etemail);
        save=(Button)findViewById(R.id.btnsave);
        dataBaseHelper=new DataBaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         boolean result=dataBaseHelper.insertData(name.getText().toString(),Integer.parseInt(mobile_number.getText().toString()),
                 email.getText().toString());
         if (result)
             Toast.makeText(AddNewContact.this,"Data inserted",Toast.LENGTH_SHORT).show();
         else
         Toast.makeText(AddNewContact.this,"not inserted ",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
