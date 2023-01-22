// Created By Rahul Timbaliya
package com.example.crudoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {
           Button rsearch,Update;
           EditText name,department,rollnumber;
           SQLiteDatabase sq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        rsearch=(Button) findViewById(R.id.btnrsearch);
        Update=(Button) findViewById(R.id.Update);
        name=(EditText) findViewById(R.id.Uname);
        department=(EditText) findViewById(R.id.Udepartment);
        rollnumber=(EditText) findViewById(R.id.Urollnumber);
        rsearch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String []a={"name,department"};
                String []b={rollnumber.getText().toString()};

                try {
                    sq=openOrCreateDatabase("Student.db",MODE_PRIVATE,null);
                    Cursor c=sq.query("studeta",a,"rollnumber=?",b,null,null,null,null);
                    if(c==null){


                    }
                    else{
                        c.moveToFirst();
                        System.out.println(c.getCount());
                        name.setText(c.getString(c.getColumnIndex("name")));
                        department.setText(c.getString(c.getColumnIndex("department")));
                    }

                }
                catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Hello2");
                    Toast.makeText(getApplicationContext(), "Data Is Not Found", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    sq = openOrCreateDatabase("Student.db", MODE_PRIVATE, null);
                    String uname = name.getText().toString();
                    String udepartment = department.getText().toString();
                    String uroll=rollnumber.getText().toString();
                    sq.execSQL("UPDATE studeta SET name='"+uname+"',department='"+udepartment+"'WHERE rollnumber='"+uroll+"'");
                    Toast.makeText(UpdateData.this, "Data Updated SuccesFully", Toast.LENGTH_SHORT).show();
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