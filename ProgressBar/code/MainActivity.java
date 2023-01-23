package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
     ProgressBar p;
     Button b;
     int process=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.btn1);
        p=(ProgressBar) findViewById(R.id.progressBar1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   process=1;
                   setpValue(process);
            }
        });

    }

  protected void setpValue(final int pro){
       p.setProgress(pro);
       Thread t=new Thread(new Runnable() {
           @Override
           public void run() {
                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){

                }
                 if(pro>=100){
                     p.setProgress(0);
                     return;
                 }
                 else{
                     setpValue(pro+10);
                 }

           }
       });
       t.start();
    }
}