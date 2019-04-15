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

public class CommentListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Comment> dcomList;


    public CommentListAdapter(Context mContext, List<Comment> dcomList) {
        this.mContext = mContext;
        this.dcomList = dcomList;
    }
    @Override
    public int getCount() {
        return dcomList.size();
    }

    @Override
    public Object getItem(int position) {
        return dcomList.get(position);
    }
    public long getItemId(int position) {
        return dcomList.get(position).get_id();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.comment_listview, null);
        TextView userName = (TextView)v.findViewById(R.id.comenterNameTV);
        TextView comment = (TextView)v.findViewById(R.id.commentTV);
        userName.setText(dcomList.get(position).getCommentUser());
        comment.setText(dcomList.get(position).getComment());
        return v;
    }


}
