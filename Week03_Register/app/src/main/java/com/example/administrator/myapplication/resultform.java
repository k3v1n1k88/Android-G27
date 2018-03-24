package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultform extends AppCompatActivity {
    TextView edtUsername;
    TextView edtPassword;
    TextView edtBirthday;
    TextView edtGender;
    TextView edtHobbies;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultform);
        connectElement();
        Intent intentActivity2 = getIntent();
        String userName = intentActivity2.getStringExtra("username");
        String passWord = intentActivity2.getStringExtra("password");
        String birthDay = intentActivity2.getStringExtra("birthday");
        String gender = intentActivity2.getStringExtra("gender");
        String hobbies = intentActivity2.getStringExtra("hobbies");
        edtUsername.setText("Username: "+userName);
        edtPassword.setText("Password: "+passWord);
        edtBirthday.setText("Birthdate: "+birthDay);
        edtGender.setText("Gender: "+gender);
        edtHobbies.setText("Hobbies: "+hobbies);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
    private void connectElement(){
        edtUsername = (TextView) findViewById(R.id.txtUsename);
        edtPassword = (TextView) findViewById(R.id.txtPassword);
        edtBirthday = (TextView) findViewById(R.id.txtBirthdate);
        edtGender = (TextView)findViewById(R.id.txtGender);
        edtHobbies = (TextView) findViewById(R.id.txtHobbies);
        btnExit = (Button) findViewById(R.id.btnExit);
    }
}
