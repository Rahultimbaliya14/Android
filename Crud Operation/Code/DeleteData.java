// Created By Rahul Timbaliya
package com.example.crudoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {
     Button delete;
     EditText drollnumber;
     SQLiteDatabase sq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        delete=(Button) findViewById(R.id.btndelete);
        drollnumber=(EditText) findViewById(R.id.drollnumber);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sq=openOrCreateDatabase("Student.db",MODE_PRIVATE,null);
                    String d=drollnumber.getText().toString();
                    sq.execSQL("DELETE FROM studeta WHERE rollnumber='"+d+"'");
                    drollnumber.setText("");
                    Toast.makeText(DeleteData.this, "Data Is Succesfully Deleted", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    System.out.println(e);
                    Toast.makeText(DeleteData.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}