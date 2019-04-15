package com.example.joker.pregnancyhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CommentPage extends AppCompatActivity {
    private ListView cList;
    private CommentListAdapter adapter;
    private List<Comment> commentList;
    private DatabaseHelper mDBHelper;
    TextView qus;
    Button addcBtn;
    int userID,postID;
    String cName;
    ArrayList<String> rUserData = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_page);

        addcBtn =(Button)findViewById(R.id.addComBtn);
        cList = (ListView) findViewById(R.id.commentListTV);
        qus = (TextView)findViewById(R.id.cpostTV);

        mDBHelper = new DatabaseHelper(this);
        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        postID = rBundle.getInt("POST_ID");
        String postmsg = rBundle.getString("POST");
        String type =rBundle.getString("TYPE");
        if(type.equals("Doctor")){
            rUserData = mDBHelper.docInfo(userID);
        }
        else
            rUserData = mDBHelper.userInfo(userID);

        cName = rUserData.get(0);
        qus.setText(postmsg);

        commentList = mDBHelper.getCommentList(rBundle.getInt("POST_ID"));
        //Init adapter
        adapter = new CommentListAdapter(this, commentList);
        //Set adapter for listview
        cList.setAdapter(adapter);

        addcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(CommentPage.this,AddComment.class);
                Bundle data = new Bundle();
                data.putInt("POST_ID",postID);
                data.putString("USER_NAME",cName);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });

    }
}
