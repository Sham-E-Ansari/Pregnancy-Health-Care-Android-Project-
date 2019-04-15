package com.example.joker.pregnancyhealthcare;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joker on 29-Jan-18.
 */

public class HospitalListAdapter extends BaseAdapter {
    private Context mContext;
    private List<HospitalDetails> hospitalList;

    public HospitalListAdapter(Context mContext, List<HospitalDetails> hospitalList) {
        this.mContext = mContext;
        this.hospitalList = hospitalList;
    }
    @Override
    public int getCount() {
        return hospitalList.size();
    }

    @Override
    public Object getItem(int position) {
        return hospitalList.get(position);
    }
    public long getItemId(int position) {
        return hospitalList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.hospital_listview, null);
        TextView hosName = (TextView)v.findViewById(R.id.hosNameTV);
        hosName.setText(hospitalList.get(position).gethName());
        return v;
    }
}
