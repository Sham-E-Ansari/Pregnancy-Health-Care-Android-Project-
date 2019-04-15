package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorHome extends AppCompatActivity {

    Button docprofile,helthForumBTN;
    private DatabaseHelper helper = new DatabaseHelper(this);
    private int docID;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        docID = rBundle.getInt("USER_ID");
        type = rBundle.getString("TYPE");

        docprofile =(Button)findViewById(R.id.docprofileBtn);
        docprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DoctorHome.this,DoctorProfile.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",docID);
                data.putString("TYPE",type);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });
        helthForumBTN =(Button)findViewById(R.id.docHealthForum);
        helthForumBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(DoctorHome.this,FindPage.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",docID);
                data.putString("TYPE",type);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });

    }
}
