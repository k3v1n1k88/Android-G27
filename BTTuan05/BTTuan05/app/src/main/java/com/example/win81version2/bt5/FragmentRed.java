package com.example.win81version2.bt5;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Win 8.1 Version 2 on 3/27/2018.
 */

public class FragmentRed extends Fragment implements FragmentCallbacks {
    MainActivity main;
    TextView txtView1Red;
    Button btn1,btn2,btn3,btn4;
    int indexCurrentItem= 0;
    private String items[] = { "Lop 1", "Lop 2",
            "Lop 3", "Lop 4", "Lop 5",
            "Lop 6", "Lop 7", "Lop 8",
            "Lop 9", };
    private String items1[] = {"HS1 1","HS1 2","HS1 3","HS1 4","HS1 5 ","HS1 6","HS1 7","HS1 8", "HS1 9",};
    public static FragmentRed newInstance(String strArg1) {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }// newInstance
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Activities containing this fragment must implement interface: MainCallbacks
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException( " Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// inflate res/layout_red.xml which includes a textview and a button
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(
                R.layout.layout_red, null);
// plumbing - get a reference to widgets in the inflated layout
        txtView1Red = (TextView) view_layout_red.findViewById(R.id.textView1Red);
        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("arg1", "");
            txtView1Red.setText(redMessage);
        } catch (Exception e) {
            Log.e("RED BUNDLE ERROR - ", "" + e.getMessage());
        }
        // clicking the button changes the time displayed and sends a copy to MainActivity
        btn1 = (Button) view_layout_red.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView1Red.setText(items1[0]);
                main.onMsgFromFragToMain("RED-FRAG", String.valueOf(0));
            }
        });
        btn2 = (Button) view_layout_red.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexCurrentItem>0) {
                    indexCurrentItem--;
                    txtView1Red.setText(items1[indexCurrentItem]);
                    main.onMsgFromFragToMain("RED-FRAG", String.valueOf(indexCurrentItem));
                }
            }
        });
        btn3 = (Button) view_layout_red.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexCurrentItem<8) {
                    indexCurrentItem++;
                    txtView1Red.setText(items1[indexCurrentItem]);
                    main.onMsgFromFragToMain("RED-FRAG", String.valueOf(indexCurrentItem));
                }
            }
        });
        btn4 = (Button) view_layout_red.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView1Red.setText(items1[8]);
                main.onMsgFromFragToMain("RED-FRAG", String.valueOf(8));
            }
        });

        return view_layout_red;
    }
    @Override
    public void onMsgFromMainToFragment(String strValue) {
// receiving a message from MainActivity (it may happen at any point in time)
        for(int i=0;i<9;i++)
        {
            if(strValue.equals(items[i])) {
                txtView1Red.setText(items1[i]);
                indexCurrentItem = i;
            }
        }
    }
}// FragmentRed
