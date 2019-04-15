package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class WeightTracker extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    int userID;
    float height;
    float weight;
    float bGain,aGain;
    String bmiCat;
    String pk;
    float res;
    //float presWeight;
    //int pWeek;
    Button calculate;
    EditText prweek,presentWeight;
    TextView bmi,cat,result;


    DatabaseHelper db;
     float preW, res2;
     int re, preWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);

        bmi =(TextView)findViewById(R.id.bmiTV);
        cat = (TextView)findViewById(R.id.categoryTV);
        result = (TextView)findViewById(R.id.resultTV);
       // prweek= (EditText)findViewById(R.id.pregnancyweekET);
       // presentWeight = (EditText)findViewById(R.id.presentWeET);

        calculate = (Button)findViewById(R.id.calculateBtn);
        final EditText T1= (EditText) findViewById(R.id.editText3);
        final EditText T2= (EditText) findViewById(R.id.editText4);



        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");

        height = helper.getUserheight(userID);
        weight = helper.getUserWeight(userID);

        float hm = height/100;
        float bmiresult= weight/(hm*hm);
        bmi.setText("Your BMI was: "+bmiresult);

        if(bmiresult <20)
        {
            cat.setText("You were Underweighted!!!");
            bmiCat = "U";
        }
        else if(bmiresult> 26)
        {
            cat.setText("You were Overweighted!!!");
            bmiCat = "O";
        }
        else {
            cat.setText("You were AverageWeighted!!!");
            bmiCat = "N";
        }
       // pk = prweek.getText().toString();


        Toast.makeText(this," "+pk+" ",Toast.LENGTH_LONG).show();
/*
        try{


            pWeek = Integer.parseInt(pk);
            bGain = helper.getBgain(bmiCat,pWeek);
            aGain = helper.getAgain(bmiCat,pWeek);
            presWeight = Float.parseFloat(presentWeight.getText().toString());
            Toast.makeText(this," "+pWeek+" ",Toast.LENGTH_LONG).show();

            res =(float)((presWeight*2.2046) - (weight*2.2046));
        }
        catch (NumberFormatException e)
        {

        }
*/


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Toast.makeText(WeightTracker.this," "+preW+" "+preWeek+" ",Toast.LENGTH_LONG).show();
                if(T1.getText().toString().equals("50")
                        || T1.getText().toString().equals("51")
                        || T1.getText().toString().equals("52")
                        || T1.getText().toString().equals("53")
                        || T1.getText().toString().equals("54")
                        || T1.getText().toString().equals("55")
                        || T1.getText().toString().equals("56")
                        || T1.getText().toString().equals("57")
                        || T1.getText().toString().equals("58")
                        || T1.getText().toString().equals("59")
                        || T1.getText().toString().equals("40")
                        || T1.getText().toString().equals("41")
                        || T1.getText().toString().equals("42")
                        || T1.getText().toString().equals("45")
                        || T1.getText().toString().equals("46")
                        || T1.getText().toString().equals("47")
                        || T1.getText().toString().equals("48")
                        || T1.getText().toString().equals("49")
                        )
                    result.setText("Your Gain is Under Avg.!!!");

                else if(T1.getText().toString().equals("60")
                        || T1.getText().toString().equals("61")
                        || T1.getText().toString().equals("62")
                        || T1.getText().toString().equals("63")
                        || T1.getText().toString().equals("64")
                        || T1.getText().toString().equals("65")
                        || T1.getText().toString().equals("66")
                        || T1.getText().toString().equals("67")
                        || T1.getText().toString().equals("68")
                        || T1.getText().toString().equals("69")
                        || T1.getText().toString().equals("70")
                        || T1.getText().toString().equals("71")
                        || T1.getText().toString().equals("72")

                        )
                    result.setText("Your Gain is Above Avg.!!!");

                else
                    result.setText("Your Gain is Avg.!!!");//+bGain+"   "+aGain+ "  ... "+bmiCat+"  "+pk+"  ");


            }
        });


    }
}
