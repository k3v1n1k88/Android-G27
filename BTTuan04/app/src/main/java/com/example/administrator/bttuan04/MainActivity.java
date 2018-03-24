package com.example.administrator.bttuan04;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity{
    TextView txtMsg;
    ListView list;
    // The n-th row in the list will consist of [icon, label]
// where icon = thumbnail[n] and label=items[n]
    String[] items = { "Data-1", "Data-2", "Data-3", "Data-4", "Data-5",
            "Data-6", "Data-7", "Data-8", "Data-9" };
    Integer[] thumbnails = { R.drawable.hinh2,
            R.drawable.hinh3, R.drawable.hinh4,
            R.drawable.hinh5, R.drawable.hinh6,
            R.drawable.hinh7, R.drawable.hinh8,
            R.drawable.hinh9, R.drawable.hinh10};
    Integer[] pic = { R.drawable.hinh2,
            R.drawable.hinh3, R.drawable.hinh4,
            R.drawable.hinh5, R.drawable.hinh6,
            R.drawable.hinh7, R.drawable.hinh8,
            R.drawable.hinh9, R.drawable.hinh10};
    int idItemPrevious = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        list = (ListView) findViewById(R.id.list) ;
        // the arguments of the custom adapter are:
        // activityContex, layout-to-be-inflated, labels, icons
        final CustomIconLabelAdapter adapter = new CustomIconLabelAdapter(
                this,
                R.layout.custom_row_icon_label,
                items,
                thumbnails,
                pic);
        // bind intrinsic ListView to custom adapter
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = " Position: " + position + " " + items[position];
                txtMsg.setText(text);
                if(idItemPrevious != -1){
                    View viewPre = list.getChildAt(idItemPrevious - list.getFirstVisiblePosition());
                    ImageView imgPicPre = (ImageView) viewPre.findViewById(R.id.imgPic);
                    imgPicPre.setVisibility(View.GONE);
                }

                View viewCurrent = list.getChildAt(position - list.getFirstVisiblePosition());
                if(viewCurrent != null) {
                    ImageView imgPicCurrent = (ImageView) viewCurrent.findViewById(R.id.imgPic);
                    imgPicCurrent.setVisibility(View.VISIBLE);
                    idItemPrevious = position;
                }
            }
        });

    }//onCreate
    // react to user's selection of a row

}//class


