// Created By Rahul Timbaliya
package com.example.crudoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {
     Button insert;
     EditText name,department,rollnumber;
     SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        insert=(Button) findViewById(R.id.insert);
        name=(EditText) findViewById(R.id.Name);
        department=(EditText) findViewById(R.id.Department);
        rollnumber=(EditText) findViewById(R.id.RollNumber);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String sname=name.getText().toString();
                  String sdepartment=department.getText().toString();
                  String srollnumber= rollnumber.getText().toString();
                  try {
                      sq=openOrCreateDatabase("Student.db",MODE_PRIVATE,null);
                      sq.execSQL("INSERT INTO studeta(name,department,rollnumber) VALUES('"+sname+"','"+sdepartment+"','"+srollnumber+"')");
                      Toast.makeText(InsertData.this, "Data Inserted Succesfully", Toast.LENGTH_SHORT).show();
                      name.setText("");
                      department.setText("");
                      rollnumber.setText("");
                  }
                  catch (Exception e){
                      System.out.println(e);

                  }

            }
        });
    }
}