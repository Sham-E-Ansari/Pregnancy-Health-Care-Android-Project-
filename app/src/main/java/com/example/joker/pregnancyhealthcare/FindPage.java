package com.example.joker.pregnancyhealthcare;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FindPage extends AppCompatActivity {

    private ListView qList;
    private QuestionListAdapter adapter;
    private List<Question> questionList;
    private DatabaseHelper mDBHelper;

    EditText topicET;
    Button search;
    Button addBtn;
    int userID;
    int post_id ;
    String postC;
    String type;
    ArrayList<String> rUserData = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_page);

        qList = (ListView) findViewById(R.id.quesListTV);
        topicET = (EditText) findViewById(R.id.TopicSearchET);
        search = (Button)findViewById(R.id.topicsearchBTN);

        mDBHelper = new DatabaseHelper(this);

        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");
        type = rBundle.getString("TYPE");
        rUserData = mDBHelper.userInfo(userID);


        addBtn = (Button)findViewById(R.id.addQusBtn);

        questionList = mDBHelper.geQuestionList();
        //Init adapter
        adapter = new QuestionListAdapter(this, questionList);
        //Set adapter for listview
        qList.setAdapter(adapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = topicET.getText().toString();

                if(topic.isEmpty())
                    Toast.makeText(getApplicationContext(),"Fill all field!!!",Toast.LENGTH_SHORT).show();

                else
                {
                    questionList = mDBHelper.gesearchedQuestionList(topic);
                    adapter = new QuestionListAdapter(getApplicationContext(), questionList);
                    qList.setAdapter(adapter);
                }
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FindPage.this,AddPost.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                data.putString("TYPE",type);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });

        registerForContextMenu(qList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.quesListTV) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.post_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.comment:
                post_id = questionList.get(info.position).get_id();
                postC = questionList.get(info.position).getPost();
                Intent i = new Intent(FindPage.this,CommentPage.class);
                Bundle data = new Bundle();
                data.putString("TYPE",type);
                data.putInt("POST_ID",post_id);
                data.putInt("USER_ID",userID);
                data.putString("POST",postC);
                i.putExtra("USER_DATA",data);
                startActivity(i);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

