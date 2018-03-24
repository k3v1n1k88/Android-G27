package com.example.administrator.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Administrator on 18/03/2018.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    EditText txtDate;
    public DateDialog(){}

    public void setEditText(View v){
        txtDate = (EditText) v;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar= Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
        String date = year+"/"+month+"/"+day;
        txtDate.setText(date);
    }
}
