package com.example.administrator.bttuan04;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 23/03/2018.
 */

class CustomIconLabelAdapter extends ArrayAdapter<String> {
    Context context;
    Integer[] thumbnails;
    String[] items;
    Integer[] imageSelected;
    public CustomIconLabelAdapter( Context context, int layoutToBeInflated,
                                   String[] items, Integer[] thumbnails, Integer[] imageSelected) {
        super(context, R.layout.custom_row_icon_label, items);
        this.context = context;
        this.thumbnails = thumbnails;
        this.items = items;
        this.imageSelected = imageSelected;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_row_icon_label, null);
        TextView label = (TextView) row.findViewById(R.id.label);
        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        ImageView pic = (ImageView) row.findViewById(R.id.imgPic);
        label.setText(items[position]);
        icon.setImageResource(thumbnails[position]);
        pic.setImageResource(imageSelected[position]);
        return (row);
    }

}// CustomAdapter

