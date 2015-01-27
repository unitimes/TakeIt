package com.botong.android.takeitproto.realtime;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.botong.android.takeitproto.R;

import java.util.ArrayList;

/**
 * Created by cob_macpro on 2015. 1. 26..
 */
public class CustomAdapter extends ArrayAdapter<ListData> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ListData> listData;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<ListData> listData) {
        super(context, layoutResourceId, listData);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.listData = listData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        TextView txtViewContent = (TextView) row.findViewById(R.id.txtViewContentListItemRealTime);
        TextView txtViewCounts = (TextView) row.findViewById(R.id.txtViewCountsListItemRealTime);

        txtViewContent.setText(listData.get(position).getContent());
        txtViewCounts.setText(Integer.toString(listData.get(position).getCounts()));

        return row;
    }
}
