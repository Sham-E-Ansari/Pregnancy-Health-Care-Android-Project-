package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button profile, emergency,weightTracker,forumBTN,nutrition, symptoms;
    private DatabaseHelper helper = new DatabaseHelper(this);
    private int userID;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        type = rBundle.getString("TYPE");

        profile =(Button)findViewById(R.id.profileBtn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomePage.this,Profile.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                data.putString("TYPE",type);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });
        forumBTN =(Button)findViewById(R.id.forumBtn);
        forumBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,FindPage.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                data.putString("TYPE",type);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });

        symptoms = (Button)findViewById(R.id.symptomsBtn);
        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(HomePage.this,Symptoms.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });
        weightTracker=(Button)findViewById(R.id.weightBtn);
        weightTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,WeightTracker.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });
        emergency=(Button)findViewById(R.id.emergencyBtn);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,EmergencyPage.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });
        nutrition = (Button)findViewById(R.id.nutritionBtn);
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,NutritionPage.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                i.putExtra("USER_DATA",data);
                startActivity(i);

            }
        });

    }
}
