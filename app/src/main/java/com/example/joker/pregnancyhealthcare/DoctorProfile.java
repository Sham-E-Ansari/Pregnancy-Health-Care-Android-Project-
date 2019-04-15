package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorProfile extends AppCompatActivity {

    private int docID;
    String type;
    private TextView docName, docEmail,docPhone,docPassword;
    ArrayList<String> rUserData = new ArrayList<String>();
    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);


        docName = (TextView)findViewById(R.id.docnameTV);
        docEmail = (TextView)findViewById(R.id.docemailTV);
        docPhone = (TextView)findViewById(R.id.docphoneTV);
        docPassword = (TextView)findViewById(R.id.docpassTV);


        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        docID = rBundle.getInt("USER_ID");
        type= rBundle.getString("TYPE");
        rUserData = helper.docInfo(docID);


        docName.setText(rUserData.get(0));
        docEmail.setText(rUserData.get(1));
        docPhone.setText(rUserData.get(2));
        docPassword.setText(rUserData.get(3));

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
                Intent i = new Intent(DoctorProfile.this,EditDoctorProfile.class);
                i.putExtra("CURRENT_INFO",rUserData);
                i.putExtra("USER_ID",docID);
                i.putExtra("TYPE",docID);
                startActivity(i);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
