package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class Symptoms extends AppCompatActivity {

    private Button button;
    private TextView weekT,Ldate,Fdate;
    private DatabaseHelper helper = new DatabaseHelper(this);
    ArrayList<String> rUserData = new ArrayList<String>();
    private int userID;
    private Calendar calendar;
    private int year, month, day;
    int pyear,pmonth,pday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        weekT = (TextView)findViewById(R.id.weekTV);
        Ldate = (TextView)findViewById(R.id.ldateTV);
        Fdate = (TextView)findViewById(R.id.fdateTV);

        button = (Button)findViewById(R.id.nextBtn);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        rUserData = helper.userInfo(userID);

        pyear= Integer.parseInt(rUserData.get(10));
        pmonth=Integer.parseInt(rUserData.get(11));
        pday= Integer.parseInt(rUserData.get(12));

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

        String pregWeek = ""+calculateWeek();

        weekT.setText(pregWeek);
        Ldate.setText(lexpectedDate());
        Fdate.setText(fexpectedDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calculateWeek() <= 13 )
                    startActivity(new Intent(Symptoms.this,FirstTrimester.class));
                else if(calculateWeek() <= 26 )
                    startActivity(new Intent(Symptoms.this,SecTrimester.class));
                else
                    startActivity(new Intent(Symptoms.this,ThirdTrimester.class));

            }
        });
    }
    int calculateWeek(){
        int week=0;
        if(pday > day)
        {
            month = month - 1;
            day = day + 30;
        }
        if(pmonth > month)
        {
            year = year - 1;
            month = month + 12;
        }
        int cday = day - pday;
        int cmonth = month - pmonth;
        int cyear = year - pyear;

        week = (cyear*365 + cmonth*30 + cday)/7;
        return week;
    }
    String lexpectedDate() {

        int lday,lmnth,lyr;
        lyr = pyear;
        lmnth = pmonth + 9;
        lday= pday+ 24;
        if(lday > 30) {
            lday = lday-30;
            lmnth= lmnth+1;
        }
        if(lmnth > 12) {
            lmnth= lmnth-12;
            lyr = lyr+1;
        }
        String exdate =lyr+"-"+lmnth+"-"+lday;
        return exdate;
    }
    String fexpectedDate() {

        int fday,fmnth,fyr;
        fyr = pyear;
        fmnth = pmonth + 8;
        fday= pday+ 26;
        if(fday > 30) {
            fday = fday-30;
            fmnth= fmnth+1;
        }
        if(fmnth > 12) {
            fmnth= fmnth-12;
            fyr = fyr+1;
        }
        String exdate =fyr+"-"+fmnth+"-"+fday;
        return exdate;
    }
}
