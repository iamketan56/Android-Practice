package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText passwordeditText3, emaileditText2;
    TextView textView;
    Button button;
  String emailstring;
  String passstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        emaileditText2 = findViewById(R.id.emaileditText2);
        passwordeditText3 = findViewById(R.id.passwordeditText3);
        button = findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailstring = emaileditText2.getText().toString();
                passstring = passwordeditText3.getText().toString();
                Intent i3 = new Intent(getApplicationContext(), ActivityB.class);
                i3.putExtra("email", emailstring);
                i3.putExtra("pass", passstring);
                startActivity(i3);

            }
        });

    }
}