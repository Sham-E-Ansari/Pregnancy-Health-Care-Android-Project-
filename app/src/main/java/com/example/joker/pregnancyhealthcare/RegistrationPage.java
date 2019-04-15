package com.example.joker.pregnancyhealthcare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegistrationPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DatabaseHelper helper = new DatabaseHelper(this);
    EditText uName,uMobile,uEmail,uPass,udob,uPLastDate,uEmob1,uEmob2,uheight,uweight,uLocation;
    Button pickdob, pickdop, regBTN;
    String uBloodgroup;
    Spinner uBldgrp;
    private Calendar calendar;
    private int year, month, day;
    String exDate;

    int pyear, pmonth,pday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);


        uBldgrp = (Spinner)findViewById(R.id.bloodgroupSP);
        uName = (EditText)findViewById(R.id.uNameET);
        uMobile = (EditText)findViewById(R.id.uPhoneET);
        uEmail = (EditText)findViewById(R.id.uEmailET);
        uPass = (EditText)findViewById(R.id.uPassET);
        udob = (EditText)findViewById(R.id.bDateET);
        uPLastDate = (EditText)findViewById(R.id.pDateET);
        uEmob1 = (EditText)findViewById(R.id.uEPhone1ET);
        uEmob2 = (EditText)findViewById(R.id.uEPhone2ET);
        uheight = (EditText)findViewById(R.id.uHeightET);
        uweight = (EditText)findViewById(R.id.uPweightET);
        uLocation = (EditText)findViewById(R.id.uLocET);


        pickdob = (Button)findViewById(R.id.bDateBtn);
        pickdop = (Button)findViewById(R.id.pDateBtn);
        regBTN = (Button)findViewById(R.id.regBtn);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.bloodGroup, android.R.layout.simple_spinner_item);
        uBldgrp.setAdapter(adapter);
        uBldgrp.setOnItemSelectedListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        pickdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(999);
            }
        });
        pickdop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(900);
            }
        });

        regBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = uName.getText().toString();
                String mobile = uMobile.getText().toString();
                String email = uEmail.getText().toString();
                String password = uPass.getText().toString();
                String plastdate = uPLastDate.getText().toString();
                String emob1 = uEmob1.getText().toString();
                String emob2 = uEmob2.getText().toString();
                String bday =  udob.getText().toString();
                String weight = uweight.getText().toString();
                String height = uheight.getText().toString();
                String loc = uLocation.getText().toString();

                if(name.isEmpty()||mobile.isEmpty()||email.isEmpty()||plastdate.isEmpty()||password.isEmpty()||
                        emob1.isEmpty()||uBloodgroup.equals("Select Blood Group")||emob2.isEmpty()||
                       weight.isEmpty() || height.isEmpty() ||plastdate.isEmpty() ||plastdate.isEmpty()
                        )
                {
                    Toast.makeText(RegistrationPage.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //Insert Donor Info in Database
                    User c = new User();
                    //Set values name,email,mobile etc.
                    c.setuName(name);
                    c.setuMob(mobile);
                    c.setuEmail(email);
                    c.setuBld(uBloodgroup);
                    c.setuDob(bday);
                    c.setuEmob1(emob1);
                    c.setuEmob2(emob2);
                    c.setuPass(password);
                    c.setuHeight(height);
                    c.setuWeight(weight);
                    c.setuLoc(loc);
                    c.setYear(pyear);
                    c.setMonth(pmonth);
                    c.setDay(pday);
                    Toast msg = Toast.makeText(RegistrationPage.this,"Regestration Completed !", Toast.LENGTH_SHORT);
                    msg.show();
                    helper.insertUser(c);
                    finish();
                }
            }
        });



    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView text = (TextView) view;
        if(i==0)
        {
            text.setTextColor(Color.GRAY);
        }
        else
        {
            uBloodgroup = text.getText().toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==999){
            return new DatePickerDialog(this,myDateListener,year,month,day);
        }
        else if(id==900){
            return new DatePickerDialog(this,myDateListener2,year,month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3)
                {
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    udob.setText(arg1+"-"+(arg2+1 )+"-"+arg3);


                }
            };

    private DatePickerDialog.OnDateSetListener myDateListener2 = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3)
                {

                    pyear=arg1;
                    pmonth = arg2+1;
                    pday= arg3;
                    uPLastDate.setText(arg1+"-"+(arg2+1)+"-"+arg3);
                }
            };



}
