package com.example.administrator.myapplication;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class registerform extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPassword;
    EditText edtRetypePassword;
    EditText edtBirthdate;
    RadioButton rbtnMale;
    RadioButton rbtnFemale;
    CheckBox chkboxTennis;
    CheckBox chkboxFutbal;
    CheckBox chkboxOther;
    Button btnReset;
    Button btnSign;
    Button btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerform);
        connectElement();
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUsername.getText().toString();
                String passWord = edtPassword.getText().toString();
                String retypePassword = edtRetypePassword.getText().toString();
                String birthDay= edtBirthdate.getText().toString();
                String gender="";
                String hobbies = "";

                if(rbtnMale.isChecked()){
                    gender = "Male";
                }
                if(rbtnFemale.isChecked()){
                    gender = "Female";
                }
                if(chkboxTennis.isChecked()){
                    hobbies+="Tennis ";
                }
                if(chkboxFutbal.isChecked()){
                    hobbies+="Fulbal ";
                }
                if(chkboxOther.isChecked()){
                    hobbies = "Others";
                }

                if(userName.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please input your name!",Toast.LENGTH_LONG).show();
                }
                else if(!passWord.equals(retypePassword)){
                    Toast.makeText(getApplicationContext(),"Make sure password and retype-password is the same",Toast.LENGTH_LONG).show();
                }
                else if(birthDay.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please choose your birthday!",Toast.LENGTH_LONG).show();
                }
                else if(!rbtnFemale.isChecked()&&!rbtnMale.isChecked()){
                    Toast.makeText(getApplicationContext(),"Please choose your gentle",Toast.LENGTH_LONG).show();
                }
                else if(!chkboxOther.isChecked()&&!chkboxFutbal.isChecked()&&!chkboxTennis.isChecked()){
                    Toast.makeText(getApplicationContext(),"Please choose your hobbies",Toast.LENGTH_LONG).show();
                }
                else {
                    int lenPassword = passWord.length();
                    passWord = "";
                    for(int i=0;i<lenPassword;i++){
                        passWord+="*";
                    }
                    Intent intentActivity1 = new Intent(registerform.this, resultform.class);
                    intentActivity1.putExtra("username", userName);
                    intentActivity1.putExtra("password", passWord);
                    intentActivity1.putExtra("birthday", birthDay);
                    intentActivity1.putExtra("gender", gender);
                    intentActivity1.putExtra("hobbies", hobbies);
                    startActivity(intentActivity1);
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAllElements();
            }
        });
        rbtnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtnMale.isChecked()){
                    rbtnMale.setChecked(false);
                }
            }
        });
        rbtnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtnFemale.isChecked()){
                    rbtnFemale.setChecked(false);
                }
            }
        });
        chkboxOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkboxFutbal.isChecked()){
                    chkboxFutbal.setChecked(false);
                }
                if(chkboxTennis.isChecked()){
                    chkboxTennis.setChecked(false);
                }
            }
        });
        chkboxTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkboxOther.isChecked()){
                    chkboxOther.setChecked(false);
                }
            }
        });
        chkboxFutbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkboxOther.isChecked()){
                    chkboxOther.setChecked(false);
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog dateDialog = new DateDialog();
                dateDialog.setEditText(edtBirthdate);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                dateDialog.show(fragmentTransaction,"DataPicker");
            }
        });
    }


    private void connectElement(){
        edtUsername = (EditText) findViewById(R.id.edtUsename);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtRetypePassword = (EditText) findViewById(R.id.edtRetypePassword);
        edtBirthdate = (EditText) findViewById(R.id.edtBirthdate);
        rbtnMale = (RadioButton) findViewById(R.id.rbtnMale);
        rbtnFemale = (RadioButton) findViewById(R.id.rbtnFemale);
        chkboxFutbal = (CheckBox) findViewById(R.id.chkboxFutbal);
        chkboxTennis = (CheckBox) findViewById(R.id.chkboxTennis);
        chkboxOther = (CheckBox) findViewById(R.id.chkboxOther);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnSelect =(Button) findViewById(R.id.btnSelect);
    }
    private void resetAllElements(){
        edtUsername.setText("");
        edtPassword.setText("");
        edtRetypePassword.setText("");
        edtBirthdate.setText("");
        rbtnMale.setChecked(false);
        rbtnFemale.setChecked(false);
        chkboxFutbal.setChecked(false);
        chkboxTennis.setChecked(false);
        chkboxOther.setChecked(false);
    }
}
