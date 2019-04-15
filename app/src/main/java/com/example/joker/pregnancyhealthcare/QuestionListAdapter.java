package com.example.joker.pregnancyhealthcare;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joker on 30-Jan-18.
 */

public class QuestionListAdapter extends BaseAdapter {


    private Context mContext;
    private List<Question> dquesList;


    public QuestionListAdapter(Context mContext, List<Question> dquesList) {
        this.mContext = mContext;
        this.dquesList = dquesList;
    }
    @Override
    public int getCount() {
        return dquesList.size();
    }

    @Override
    public Object getItem(int position) {
        return dquesList.get(position);
    }
    public long getItemId(int position) {
        return dquesList.get(position).get_id();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.post_listview, null);
        TextView userName = (TextView)v.findViewById(R.id.posterNameTV);
        TextView topic = (TextView)v.findViewById(R.id.TopicNameTV);
        TextView post = (TextView)v.findViewById(R.id.postTV);

        userName.setText(dquesList.get(position).getPostUser());
        topic.setText(dquesList.get(position).getPostTopic());
        post.setText(dquesList.get(position).getPost());
        return v;
    }

}
