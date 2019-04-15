package com.example.joker.pregnancyhealthcare;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EmergencyPage extends AppCompatActivity {
    int userID;
    Button Btn1,Btn2,hospitalBtn;
    TextView loc;
    ArrayList<String> rUserData = new ArrayList<String>();
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_page);

        Btn1 =(Button)findViewById(R.id.smsEm1);
        Btn2 =(Button)findViewById(R.id.smsEm2);
        hospitalBtn = (Button)findViewById(R.id.hosBtn);
        loc =(TextView)findViewById(R.id.locationText);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        rUserData = helper.userInfo(userID);
        String loca = ""+rUserData.get(9);
        loc.setText(loca);


        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = helper.getEphone1(userID);
                String msg ="Hey Please come to me... I'm having trouble now.";
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", number1);
                smsIntent.putExtra("sms_body",msg);
                finish();
                startActivity(smsIntent);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = helper.getEphone2(userID);
                String msg ="Hey Please come to me... I'm having trouble now.";
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", number1);
                smsIntent.putExtra("sms_body",msg);
                finish();
                startActivity(smsIntent);
            }
        });

        hospitalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospital");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }
}
