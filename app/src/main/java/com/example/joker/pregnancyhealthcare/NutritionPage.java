package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class NutritionPage extends AppCompatActivity {

    private EditText ageET, weightET;
    private Button calBtn, chartBtn;
    private TextView weekTV, calTV;

    ArrayList<String> rUserData = new ArrayList<String>();
    ArrayList<String> nutritionData = new ArrayList<String>();
    DatabaseHelper helper = new DatabaseHelper(this);
    private int userID;
    private Calendar calendar;
    private int year, month, day;
    private int pyear,pmonth,pday;
    private int call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_page);

        ageET = (EditText)findViewById(R.id.nutAgeET);
        weightET = (EditText)findViewById(R.id.nutWeightET);
        weekTV = (TextView)findViewById(R.id.nutweekTV);
        calTV = (TextView)findViewById(R.id.nutCalTV);
        calBtn = (Button)findViewById(R.id.nutritionCalBtn);
        chartBtn= (Button)findViewById(R.id.nutritionChartBtn);

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
        weekTV.setText(pregWeek);

        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int week = calculateWeek();
                    String agg= ageET.getText().toString();
                    String wee = weightET.getText().toString();
                    if(agg.isEmpty() || wee.isEmpty()){
                        Toast.makeText(NutritionPage.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        int age = Integer.parseInt(agg);
                        int weight = Integer.parseInt(wee);

                        if(week <=13){
                            call = helper.nutInfo(age,1,week,weight);
                        }
                        else if(week <=26 ){
                            call = helper.nutInfo(age,2,week,weight);
                        }
                        else
                            call = helper.nutInfo(age,3,week,weight);

                        calTV.setText(""+call);
                    }
                }
                catch (NumberFormatException e){

                }
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

}
