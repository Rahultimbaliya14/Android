// Created By Rahul Timbaliya

package com.example.call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     EditText phone,sms,many1;
     Button call,send;
     ConstraintLayout c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=(EditText) findViewById(R.id.phone);
        call=(Button) findViewById(R.id.call);
        sms=(EditText) findViewById(R.id.sms);
        many1=(EditText) findViewById(R.id.many) ;
        send=(Button)findViewById(R.id.send);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent=new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:"+phone.getText().toString()));
                startActivity(callintent);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager sm = SmsManager.getDefault();
                int n = Integer.parseInt(many1.getText().toString());
                for (int i = 0; i <= n; i++) {
                    sm.sendTextMessage(phone.getText().toString(), null, sms.getText().toString(), null, null);
                }
            }
        });

    }
}