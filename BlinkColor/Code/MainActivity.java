// Created By Rahul Timbaliya
package com.example.blinkcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.IpSecManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    RelativeLayout r;
    String color="RED";
    int GivenNumber=0;
    int RecievedNumber=0;
    Handler h=new Handler();
    Button b,b1;
    Random random=new Random();
    TextView t;
    Uri alaramsoud= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r=findViewById(R.id.Rahul);
        b=(Button)findViewById(R.id.btn1);
        b1=(Button)findViewById(R.id.btn2);
        t=(TextView) findViewById(R.id.text1);



        b.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             int randomgiven=random.nextInt(6);
             if(randomgiven==1){
                 t.setText("Stop Blinking At A RED Color");
                 GivenNumber=1;
             }
             else if(randomgiven==2){
                 t.setText("Stop Blinking At A GREEN Color");
                 GivenNumber=2;
             }
             else if(randomgiven==3){
                 t.setText("Stop Blinking At A YELLOW Color");
                 GivenNumber=3;
             }
             else if(randomgiven==0){
                 t.setText("Stop Blinking At A BLACK Color");
                 GivenNumber=0;
             }
             else if(randomgiven==4){
                 t.setText("Stop Blinking At A BLUE Color");
                 GivenNumber=4;
             }
             else if(randomgiven==5){
                 t.setText("Stop Blinking At A CYAN Color");
                 GivenNumber=5;
             }
             blink();
         }
     });


     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             stop();
//             b1.setVisibility(View.GONE);
         }

     });


    }
    public void blink(){
        ru.run();
    }

    public void stop(){
        if(GivenNumber==RecievedNumber) {
            h.removeCallbacks(ru);
            t.setText("!!!!!. You Win .!!!!!");
        }
        else{
            Toast.makeText(this, "Not Match The Color", Toast.LENGTH_SHORT).show();
        }
    }

    private Runnable ru=new Runnable() {
        @Override
        public void run() {
            int ran=random.nextInt(6);

                if(ran==1) {
                    r.setBackgroundColor(Color.parseColor("RED"));
                    RecievedNumber=1;
                }
                else if(ran==2) {
                    r.setBackgroundColor(Color.parseColor("BLACK"));
                    RecievedNumber=0;
                }
                else if(ran==3) {
                    r.setBackgroundColor(Color.parseColor("BLUE"));
                    RecievedNumber=4;
                }
                else if(ran==0) {
                    r.setBackgroundColor(Color.parseColor("CYAN"));
                    RecievedNumber=5;
                }
                else if(ran==4) {
                    r.setBackgroundColor(Color.parseColor("YELLOW"));
                    RecievedNumber=3;
                }
                else if(ran==5) {
                    r.setBackgroundColor(Color.parseColor("GREEN"));
                    RecievedNumber=2;
                }


            h.postDelayed(this,100);
            }

    };
}