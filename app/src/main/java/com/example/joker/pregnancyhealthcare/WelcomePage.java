package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class WelcomePage extends AppCompatActivity {

    EditText userName, userPass;
    private RadioGroup radioGroup;
    private RadioButton radiobtn;
    Button login;
    TextView reg;
    private static int count=0;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        radioGroup = (RadioGroup)findViewById(R.id.loginGrp);
        reg = (TextView)findViewById(R.id.regTV);
        userName = (EditText)findViewById(R.id.usernameET);
        userPass = (EditText)findViewById(R.id.userpasswordET);
        login = (Button) findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radiobtn=(RadioButton)findViewById(selectedId);
                String text = radiobtn.getText().toString();

                if(text.equals("Mother")){
                    String email =userName.getText().toString();
                    String pass = userPass.getText().toString();
                    if (email.isEmpty() || pass.isEmpty())
                        Toast.makeText(WelcomePage.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT).show();

                    else{
                        String rpass = helper.searchPassword(email);
                        if(pass.equals(rpass))
                        {
                            int ID = helper.getID();
                            Intent i = new Intent(WelcomePage.this,HomePage.class);
                            Bundle data = new Bundle();
                            data.putInt("USER_ID",ID);
                            data.putString("TYPE",text);
                            i.putExtra("USER_DATA",data);
                            finish();
                            startActivity(i);
                            finish();
                        }
                        else
                            Toast.makeText(WelcomePage.this,"Wrong Email or Password!!!",Toast.LENGTH_SHORT).show();
                    }
                }
                else if (text.equals("Doctor")){
                    String email =userName.getText().toString();
                    String pass = userPass.getText().toString();
                    if (email.isEmpty() || pass.isEmpty())
                        Toast.makeText(WelcomePage.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT).show();

                    else{
                        String rpass = helper.searchDocPassword(email);
                        if(pass.equals(rpass))
                        {
                            int ID = helper.getID();
                            Intent i = new Intent(WelcomePage.this,DoctorHome.class);
                            Bundle data = new Bundle();
                            data.putInt("USER_ID",ID);
                            data.putString("TYPE",text);
                            i.putExtra("USER_DATA",data);
                            finish();
                            startActivity(i);
                            finish();
                        }
                        else
                            Toast.makeText(WelcomePage.this,"Wrong Email or Password!!!",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomePage.this,RegistrationPage.class));
            }
        });




        if(count==0)
        {
            inputWeight();
            count++;

        }

    }
    void inputWeight()
    {
        Weight a1 = new Weight("N","0","0" ,"0");
        helper.insertWeight(a1);

        Weight a2 = new Weight("N","2" ,"0.28" ,"0.4");
        helper.insertWeight(a2);

        Weight a3 = new Weight("N","4" ,"0.28" ,"0.4");
        helper.insertWeight(a3);

        Weight a4 = new Weight("N","6" , "0.28","0.4");
        helper.insertWeight(a4);

        Weight a5 = new Weight("N","8" ,"0.28" ,"0.4");
        helper.insertWeight(a5);

        Weight a6 = new Weight("N","10" ,"0.28" ,"0.4");
        helper.insertWeight(a6);

        Weight a7 = new Weight("N","12" ,"1.42" ,"1.98");
        helper.insertWeight(a7);

        Weight a8 = new Weight("N","14", "1.42" ,"1.98");
        helper.insertWeight(a8);

        Weight a9 = new Weight("N","16" ,"1.42" ,"1.98");
        helper.insertWeight(a9);

        Weight a10 = new Weight("N","18" ,"1.42" ,"1.98");
        helper.insertWeight(a10);

        Weight a11 = new Weight("N","20" ,"1.88" ,"2.64");
        helper.insertWeight(a11);

        Weight a12 = new Weight("N","22" ,"1.88" ,"2.64");
        helper.insertWeight(a12);

        Weight a13 = new Weight("N","24" ,"1.88" ,"2.64");
        helper.insertWeight(a13);

        Weight a14 = new Weight("N","26" , "1.88","2.64");
        helper.insertWeight(a14);

        Weight a15 = new Weight("N","28" ,"1.88" ,"2.64");
        helper.insertWeight(a15);

        Weight a16 = new Weight("N","30" ,"1.42" ,"1.98");
        helper.insertWeight(a16);

        Weight a17 = new Weight("N","32" ,"1.42" ,"1.98");
        helper.insertWeight(a17);

        Weight a18 = new Weight("N","34" ,"1.42" ,"1.98");
        helper.insertWeight(a18);

        Weight a19 = new Weight("N","36","1.42" ,"1.98");
        helper.insertWeight(a19);

        Weight a20 = new Weight("N","38" ,"1.42" ,"1.98");
        helper.insertWeight(a20);

        Weight a21 = new Weight("N","40" ,"1.42" ,"1.98");
        helper.insertWeight(a21);

        Weight b1 = new Weight("O","0","0" ,"0");
        helper.insertWeight(b1);

        Weight b2 = new Weight("O","2 ","0.17" ,"0.28");
        helper.insertWeight(b2);

        Weight b3 = new Weight("O","4" ,"0.17" ,"0.28");
        helper.insertWeight(b3);

        Weight b4 = new Weight("O","6" , "0.17","0.28");
        helper.insertWeight(b4);

        Weight b5 = new Weight("O","8" ,"0.17" ,"0.28");
        helper.insertWeight(b5);

        Weight b6 = new Weight("O","10" ,"0.17" ,"0.28");
        helper.insertWeight(b6);

        Weight b7 = new Weight("O","12" ,"0.85" ,"1.42");
        helper.insertWeight(b7);

        Weight b8 = new Weight("O","14", "0.85" ,"1.42");
        helper.insertWeight(b8);

        Weight b9 = new Weight("O","16" ,"0.85" ,"1.42");
        helper.insertWeight(b9);

        Weight b10 = new Weight("O","18" ,"0.85" ,"1.42");
        helper.insertWeight(b10);

        Weight b11 = new Weight("O","20" ,"1.13" ,"1.88");
        helper.insertWeight(b11);

        Weight b12 = new Weight("O","22" ,"1.13" ,"1.88");
        helper.insertWeight(b12);

        Weight b13 = new Weight("O","24" ,"1.13" ,"1.88");
        helper.insertWeight(b13);

        Weight b14 = new Weight("O","26" , "1.13","1.88");
        helper.insertWeight(b14);

        Weight b15 = new Weight("O","28" ,"1.13" ,"1.88");
        helper.insertWeight(b15);

        Weight b16 = new Weight("O","30" ,"0.85" ,"1.42");
        helper.insertWeight(b16);

        Weight b17 = new Weight("O","32" ,"0.85" ,"1.42");
        helper.insertWeight(b17);

        Weight b18 = new Weight("O","34" ,"0.85" ,"1.42");
        helper.insertWeight(b18);

        Weight b19 = new Weight("O","36" ,"0.85" ,"1.42");
        helper.insertWeight(b19);

        Weight b20 = new Weight("O","38" ,"0.85" ,"1.42");
        helper.insertWeight(b20);

        Weight b21 = new Weight("O","40" ,"0.85","1.42");
        helper.insertWeight(b21);

        Weight c1 = new Weight ("U","0","0","0");
        helper.insertWeight(c1);

        Weight c2 = new Weight ("U","2","0.32","0.45");
        helper.insertWeight(c2);

        Weight c3 = new Weight("U","4","0.32","0.45");
        helper.insertWeight(c3);

        Weight c4 = new Weight ("U","6", "0.32","0.45");
        helper.insertWeight(c4);

        Weight c5 = new Weight ("U","8" ,"0.32" ,"0.45");
        helper.insertWeight(c5);

        Weight c6 = new Weight ("U","10" ,"0.32" ,"0.45");
        helper.insertWeight(c6);

        Weight c7 = new Weight ("U","12" , "1.59","2.27");
        helper.insertWeight(c7);

        Weight c8 = new Weight ("U","14", "1.59" ,"2.27");
        helper.insertWeight(c8);

        Weight c9 = new Weight ("U","16" ,"1.59" ,"2.27");
        helper.insertWeight(c9);

        Weight c10 = new Weight ("U","18" ,"1.59" ,"2.27");
        helper.insertWeight(c10);

        Weight c11 = new Weight ("U","20" ,"2.11","3.01");
        helper.insertWeight(c11);

        Weight c12 = new Weight ("U","22" ,"2.11" ,"3.01");
        helper.insertWeight(c12);

        Weight c13 = new Weight ("U","24" ,"2.11" ,"3.01");
        helper.insertWeight(c13);

        Weight c14 = new Weight ("U","26" , "2.11","3.01");
        helper.insertWeight(c14);

        Weight c15 = new Weight ("U","28" ,"2.11" ,"3.01");
        helper.insertWeight(c15);

        Weight c16 = new Weight ("U","30" ,"1.59" ,"2.27");
        helper.insertWeight(c16);

        Weight c17 = new Weight ("U","32" ,"1.59" ,"2.27");
        helper.insertWeight(c17);

        Weight c18 = new Weight ("U","34" ,"1.59" ,"2.27");
        helper.insertWeight(c18);

        Weight c19 = new Weight ("U","36" ,"1.59" ,"2.27");
        helper.insertWeight(c19);

        Weight c20 = new Weight ("U","38" ,"1.59" ,"2.27");
        helper.insertWeight(c20);

        Weight c21 = new Weight ("U","40" ,"1.59" ,"2.27");
        helper.insertWeight(c21);

    }

}
