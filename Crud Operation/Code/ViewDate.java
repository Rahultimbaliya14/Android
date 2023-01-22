// Created By Rahul Timbaliya
package com.example.crudoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewDate extends AppCompatActivity {
     TextView name,department,rollnumber;
     Button  next,privious;
     SQLiteDatabase sq;
     Cursor c;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_date);
        name=(TextView) findViewById(R.id.txtname);
        department=(TextView) findViewById(R.id.txtdepartment);
        rollnumber=(TextView) findViewById(R.id.txtroll);
        next=(Button) findViewById(R.id.btnnext);
        privious=(Button) findViewById(R.id.btnPrivious);
        try {
            String []a={"name,department,rollnumber"};
            sq=openOrCreateDatabase("Student.db",MODE_PRIVATE,null);
            c=sq.query("studeta",a,null,null,null,null,null,null);
            c.moveToFirst();
            name.setText(c.getString(c.getColumnIndex("name")));
            department.setText(c.getString(c.getColumnIndex("department")));
            rollnumber.setText(c.getString(c.getColumnIndex("rollnumber")));

        }
        catch (Exception e){
            System.out.println(e);
            Toast.makeText(this, "Data No Found", Toast.LENGTH_SHORT).show();
        }
        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                try {

                    c.moveToNext();
                    System.out.println(c.getCount());
                    name.setText(c.getString(c.getColumnIndex("name")));
                    department.setText(c.getString(c.getColumnIndex("department")));
                    rollnumber.setText(c.getString(c.getColumnIndex("rollnumber")));
                }
                catch (Exception e){
                    System.out.println(e);
                    Toast.makeText(ViewDate.this, "This Is Last Record", Toast.LENGTH_SHORT).show();
                }


            }
        });
        privious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    c.moveToPrevious();
                    System.out.println(c.getCount());
                    name.setText(c.getString(c.getColumnIndex("name")));
                    department.setText(c.getString(c.getColumnIndex("department")));
                    rollnumber.setText(c.getString(c.getColumnIndex("rollnumber")));
                }
                catch (Exception e){
                    System.out.println(e);
                    Toast.makeText(ViewDate.this, "This Is First Record", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}