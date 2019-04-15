package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddComment extends AppCompatActivity {
    EditText cmnET;
    Button saveBTN;
    private DatabaseHelper helper = new DatabaseHelper(this);
    ArrayList<String> rUserData = new ArrayList<String>();
    int postID;
    String cName;
    String commentt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        cmnET = (EditText)findViewById(R.id.comET);
        saveBTN = (Button)findViewById(R.id.saveComBTN);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        postID = rBundle.getInt("POST_ID");
        cName = rBundle.getString("USER_NAME");


        //commentt = cmnET.getText().toString();
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ctext= cmnET.getText().toString();
                if(ctext.isEmpty())
                {
                    Toast.makeText(AddComment.this,"Please, Fill All The Field !",Toast.LENGTH_SHORT).show();
                }
                else{
                    Comment c = new Comment();
                    //Set values name,email,mobile etc.
                    c.setPostId(postID);
                    c.setCommentUser(cName);
                    c.setComment(ctext);
                    Toast msg = Toast.makeText(AddComment.this,"Your Comment is submitted!", Toast.LENGTH_SHORT);
                    msg.show();
                    helper.insertComment(c);
                    finish();
                }
            }
        });

    }
}
