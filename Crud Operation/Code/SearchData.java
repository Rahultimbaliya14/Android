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
import android.widget.TextView;
import android.widget.Toast;

public class SearchData extends AppCompatActivity {
     Button search;
     EditText roll;
     TextView name;
     TextView department;
     SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_search_data);
        search=findViewById(R.id.btnsearch);
        roll=findViewById(R.id.sRollNumber);
        name=findViewById(R.id.txtName);
        department=findViewById(R.id.txtDepartment);
        search.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String []a={"name,department"};
                String []b={roll.getText().toString()};
                try {
                    sq=openOrCreateDatabase("Student.db",MODE_PRIVATE,null);
                    Cursor c=sq.query("studeta",a,"rollnumber=?",b,null,null,null,null);
                    if(c==null){


                    }
                    else{
                        c.moveToFirst();
                        System.out.println(c.getCount());
                        roll.setText("");
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
    }
}