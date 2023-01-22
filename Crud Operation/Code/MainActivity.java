// Created By Rahul Timbaliya
package com.example.crudoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      Button insert,search,view,delete,crdt,update;
      SQLiteDatabase stu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert=(Button) findViewById(R.id.Insertdata);
        search=(Button) findViewById(R.id.SearchData);
        view=(Button) findViewById(R.id.Viewdata);
        delete=(Button) findViewById(R.id.Deletedata);
        crdt=(Button) findViewById(R.id.DataBase);
        update=(Button) findViewById(R.id.update);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),InsertData.class);
                startActivity(in);
//                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),ViewDate.class);
                startActivity(in);
//                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),SearchData.class);
                startActivity(in);
//                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),DeleteData.class);
                startActivity(in);
//
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),UpdateData.class);
                startActivity(in);
//
            }
        });
        crdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stu=openOrCreateDatabase("Student.db",MODE_PRIVATE,null);
                stu.execSQL(("DROP TABLE IF EXISTS studeta"));
                stu.execSQL("CREATE TABLE studeta(name varchar(225),department varchar(225),rollnumber varchar(225))");
                Toast.makeText(MainActivity.this, "Database And Table Is Created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}