package com.example.win81version2.bt5;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Win 8.1 Version 2 on 3/27/2018.
 */

public class FragmentBlue extends Fragment implements FragmentCallbacks{
    // this fragment shows a ListView
    MainActivity main;
    Context context = null;
    String message = "";
    ListView listView;
    // data to fill-up the ListView
    private String items[] = { "Lop 1", "Lop 2",
            "Lop 3", "Lop 4", "Lop 5",
            "Lop 6", "Lop 7", "Lop 8",
            "Lop 9" };
    // convenient constructor(accept arguments, copy them to a bundle, binds bundle to fragment)
    public static FragmentBlue newInstance(String strArg) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// inflate res/layout_blue.xml to make GUI holding a TextView and a ListView
        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue, null);
// plumbing – get a reference to textview and listview
       // final TextView txtBlue = (TextView) layout_blue.findViewById(R.id.textView1Blue);
        listView = (ListView) layout_blue.findViewById(R.id.listView1Blue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));
// define a simple adapter to fill rows of the listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
// show listview from the top
        listView.setSelection(0);
        listView.smoothScrollToPosition(0);
// react to click events on listview’s rows
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // inform enclosing MainActivity of the row’s position just selected
                for(int i=0;i<=8;i++){
                    parent.getChildAt(i).setBackgroundColor(Color.parseColor("#ffccddff"));
                }
                parent.getChildAt(position).setBackgroundColor(Color.parseColor("#ff1234"));
                main.onMsgFromFragToMain("BLUE-FRAG", items[position]);
                //txtBlue.setText("Blue selected row=" + position);
            }
        });
// do this for each row (ViewHolder-Pattern could be used for better performance!)
        return layout_blue;
    }// onCreateView
    @Override
    public void onMsgFromMainToFragment(String strValue) {
// receiving a message from MainActivity (it may happen at any point in time)
        int position = Integer.parseInt(strValue);
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        for(int i=0;i<=8;i++){
            listView.getChildAt(i-firstListItemPosition).setBackgroundColor(Color.parseColor("#ffccddff"));
        }
        listView.getChildAt(position-firstListItemPosition).setBackgroundColor(Color.parseColor("#ff1234"));
    }
}// class