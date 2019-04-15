package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private int userID;
    private TextView myName,myMobNo, myEmail,myEMob1,myBloodGRP,myEMob2,myDob,myplastDate,myHeight, myWeight,myLoca;
    ArrayList<String> rUserData = new ArrayList<String>();
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        myName = (TextView)findViewById(R.id.nameTV);
        myMobNo = (TextView)findViewById(R.id.phoneTV);
        myEmail = (TextView)findViewById(R.id.emailTV);
        myEMob1 = (TextView)findViewById(R.id.ephone1TV);
        myBloodGRP = (TextView)findViewById(R.id.bloodTV);
        myEMob2 = (TextView)findViewById(R.id.ephone2TV);
        myDob = (TextView)findViewById(R.id.dobTV);
        myplastDate = (TextView)findViewById(R.id.pDateTV);
        myWeight= (TextView)findViewById(R.id.pweightTV);
        myHeight= (TextView)findViewById(R.id.heightTV);
        myLoca = (TextView)findViewById(R.id.LocTV);
        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        rUserData = helper.userInfo(userID);

        myName.setText(rUserData.get(0));
        myMobNo.setText(rUserData.get(1));
        myEmail.setText(rUserData.get(2));
        myDob.setText(rUserData.get(3));
        myBloodGRP.setText(rUserData.get(4));
        myEMob1.setText(rUserData.get(5));
        myEMob2.setText(rUserData.get(6));
        myHeight.setText(rUserData.get(7));
        myWeight.setText(rUserData.get(8));
        myLoca.setText(rUserData.get(9));

        myplastDate.setText(rUserData.get(10)+"-"+rUserData.get(11)+"-"+rUserData.get(12));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.editIn:
                Intent i = new Intent(Profile.this,EditProfile.class);
                i.putExtra("CURRENT_INFO",rUserData);
                i.putExtra("USER_ID",userID);
                startActivity(i);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
