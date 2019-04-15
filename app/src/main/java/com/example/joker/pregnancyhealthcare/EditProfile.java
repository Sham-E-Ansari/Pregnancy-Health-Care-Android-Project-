package com.example.joker.pregnancyhealthcare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Calendar;

public class EditProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseHelper helper = new DatabaseHelper(this);
    EditText curName,curMobNo,curEmail,curDob,curEmer1,curEmer2,curDop,curHeight,curWeight,curLoc;
    Button saveUpdateInfo,selectDate,selectDate2;
    Spinner curBldGrp;
    private int userID;
    private String updateBloodGrp;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    int pyear, pmonth,pday;

    private EditText fixedDate;
    private ArrayList<String> currentInfo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        curName = (EditText)findViewById(R.id.editNameET);
        curMobNo = (EditText)findViewById(R.id.eidtMobileET);
        curEmail = (EditText)findViewById(R.id.editEmailET);
        curBldGrp = (Spinner)findViewById(R.id.editBloodSP);
        curDob = (EditText)findViewById(R.id.editDobET);
        curDop = (EditText)findViewById(R.id.editPlastDateET);
        curEmer1 = (EditText)findViewById(R.id.editEmer1ET);
        curEmer2 = (EditText)findViewById(R.id.editEmer2ET);
        curHeight = (EditText)findViewById(R.id.editHeightET);
        curWeight = (EditText)findViewById(R.id.editWeightET);
        curLoc = (EditText)findViewById(R.id.editLocET);

        saveUpdateInfo = (Button)findViewById(R.id.saveBTN);
        selectDate = (Button)findViewById(R.id.editDobBTN);
        selectDate2 = (Button)findViewById(R.id.editdopBtn);



        currentInfo = (ArrayList<String>)getIntent().getSerializableExtra("CURRENT_INFO");
        userID = getIntent().getIntExtra("USER_ID",0);

        setCurrentInfo();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.bloodGroup, android.R.layout.simple_spinner_item);
        curBldGrp.setAdapter(adapter);
        curBldGrp.setOnItemSelectedListener(this);


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(999);
            }
        });
        selectDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(900);
            }
        });

        saveUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateName = curName.getText().toString();
                String updateMobNo = curMobNo.getText().toString();
                String updateEmail = curEmail.getText().toString();
                String updateEm1 = curEmer1.getText().toString();
                String updateEm2 = curEmer2.getText().toString();
                String updatePLastDate = curDop.getText().toString();
                String updateDob = curDob.getText().toString();
                String updateHeight = curHeight.getText().toString();
                String updateWeight = curHeight.getText().toString();
                String updateLoc = curLoc.getText().toString();


                if(updateName.isEmpty()||updateMobNo.isEmpty()||updateEmail.isEmpty()||updateDob.isEmpty()||
                        updateBloodGrp.equals("Select Blood Group")||updateEm1.isEmpty()||updateEm2.isEmpty()
                        ||updatePLastDate.isEmpty() || updateHeight.isEmpty()||updateWeight.isEmpty() || updateLoc.isEmpty())
                {
                    Toast msg = Toast.makeText(EditProfile.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT);
                    msg.show();
                }
                else
                {
                    //Insert Donor Info in Database
                    User c = new User();
                    //Set values name,email,mobile etc.
                    c.setuName(updateName);
                    c.setuMob(updateMobNo);
                    c.setuEmail(updateEmail);
                    c.setuBld(updateBloodGrp);
                    c.setuDob(updateDob);
                    c.setuEmob1(updateEm1);
                    c.setuEmob2(updateEm2);
                    c.setuHeight(updateHeight);
                    c.setuWeight(updateWeight);
                    c.setuLoc(updateLoc);
                    c.setYear(pyear);
                    c.setMonth(pmonth);
                    c.setDay(pday);


                    Toast msg = Toast.makeText(EditProfile.this,"Update Completed !",Toast.LENGTH_SHORT);
                    msg.show();
                    helper.updateUser(c,userID);
                    Intent i = new Intent(EditProfile.this,Profile.class);
                    Bundle data = new Bundle();
                    data.putInt("USER_ID",userID);
                    i.putExtra("USER_DATA",data);
                    finish();
                    startActivity(i);
                }
            }
        });





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
                    curDob.setText(arg1+"-"+(arg2+1 )+"-"+arg3);
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
                    curDop.setText(pyear+"-"+pmonth+"-"+pday);
                }
            };

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView text = (TextView) view;
        if(i==0)
        {
            text.setText(currentInfo.get(4));
            updateBloodGrp = currentInfo.get(4);
        }
        else
        {
            //Toast msg = Toast.makeText(Regeistration.this,"BLD "+text.getText(),Toast.LENGTH_SHORT);
            //msg.show();
            updateBloodGrp = text.getText().toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void setCurrentInfo()
    {
        curName.setText(currentInfo.get(0));
        curMobNo.setText(currentInfo.get(1));
        curEmail.setText(currentInfo.get(2));
        curDob.setText(currentInfo.get(3));
        //curBldGrp.setText(currentInfo.get(4));
        curEmer1.setText(currentInfo.get(5));
        curEmer2.setText(currentInfo.get(6));
        curHeight.setText(currentInfo.get(7));
        curWeight.setText(currentInfo.get(8));
        curLoc.setText(currentInfo.get(9));
        curDop.setText(currentInfo.get(10)+"-"+currentInfo.get(11)+"-"+currentInfo.get(12));

    }
}
