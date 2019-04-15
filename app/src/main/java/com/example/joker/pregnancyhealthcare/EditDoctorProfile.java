package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EditDoctorProfile extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    EditText curName,curMobNo,curPass;
    Button saveUpdateInfo;
    private int userID;
    private ArrayList<String> currentInfo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_doctor_profile);

        curName = (EditText)findViewById(R.id.editDocNameET);
        curMobNo = (EditText)findViewById(R.id.eidtDocMobileET);
        curPass = (EditText)findViewById(R.id.editDocPassET);

        saveUpdateInfo = (Button)findViewById(R.id.saveDocBTN);



        currentInfo = (ArrayList<String>)getIntent().getSerializableExtra("CURRENT_INFO");
        userID = getIntent().getIntExtra("USER_ID",0);

        setCurrentInfo();
        saveUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateName = curName.getText().toString();
                String updateMobNo = curMobNo.getText().toString();
                String updatePass = curPass.getText().toString();


                if(updateName.isEmpty()||updateMobNo.isEmpty()||updatePass.isEmpty())
                {
                    Toast msg = Toast.makeText(EditDoctorProfile.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT);
                    msg.show();
                }
                else
                {
                    //Insert Donor Info in Database
                    Doctor d = new Doctor();
                    d.setdName(updateName);
                    d.setdMob(updateMobNo);
                    d.setdPass(updatePass);
                    //Set values name,email,mobile etc.
                    Toast msg = Toast.makeText(EditDoctorProfile.this,"Update Completed !",Toast.LENGTH_SHORT);
                    msg.show();
                    helper.updateDoctor(d,userID);
                    Intent i = new Intent(EditDoctorProfile.this,DoctorProfile.class);
                    Bundle data = new Bundle();
                    data.putInt("USER_ID",userID);
                    i.putExtra("USER_DATA",data);
                    finish();
                    startActivity(i);
                }
            }
        });
    }
    public void setCurrentInfo()
    {
        curName.setText(currentInfo.get(1));
        curMobNo.setText(currentInfo.get(2));
        curPass.setText(currentInfo.get(3));
    }
}
