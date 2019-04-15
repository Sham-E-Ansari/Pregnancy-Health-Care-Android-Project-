package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPost extends AppCompatActivity {

    private int userID;
    EditText post,topic;
    Button addPost;

    private DatabaseHelper helper = new DatabaseHelper(this);
    ArrayList<String> rUserData = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        post =(EditText)findViewById(R.id.postET);
        topic = (EditText)findViewById(R.id.topicET);
        addPost = (Button)findViewById(R.id.savePostBTN);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        String type = rBundle.getString("TYPE");
        if(type.equals("Doctor")){
            rUserData = helper.docInfo(userID);
        }
        else
            rUserData = helper.userInfo(userID);



        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = rUserData.get(0);
                String ptext= post.getText().toString();
                String ttext=topic.getText().toString();
                if(ptext.isEmpty()|| ttext.isEmpty())
                {
                    Toast.makeText(AddPost.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //Insert Donor Info in Database
                    Question q = new Question();
                    //Set values name,email,mobile etc.
                    q.setPostUser(name);
                    q.setPost(ptext);
                    q.setPostTopic(ttext);

                    Toast msg = Toast.makeText(AddPost.this,"Your Post is submitted!", Toast.LENGTH_SHORT);
                    msg.show();
                    helper.insertQuestion(q);
                    finish();
                }
            }
        });




    }
}
