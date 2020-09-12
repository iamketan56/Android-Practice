package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textView2=findViewById(R.id.textView2);
        //how to get in second activity
        //use of bundle to get data
        Intent i3=getIntent();
        String email=i3.getStringExtra("email");
       // String password=i3.getStringExtra("pass");
     //display welcome
     textView2.setText("welcome,"+email);
    }
}
