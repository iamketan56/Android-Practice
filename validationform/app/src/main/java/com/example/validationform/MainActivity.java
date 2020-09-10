package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText etName, etMobile, etEmail, etWebsite, etPassword, etConfirmpassword;
    AwesomeValidation awesomeValidation;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mobile);
        etEmail = findViewById(R.id.email);
        etWebsite = findViewById(R.id.et_website);
        etPassword = findViewById(R.id.et_password);
        etConfirmpassword = findViewById(R.id.et_confirm_password);
        checkBox=findViewById(R.id.check);
        button = findViewById(R.id.bt_sumbit);
        //initilize validation sctyle
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //add validation for name
        awesomeValidation.addValidation(this, R.id.et_name,
                RegexTemplate.NOT_EMPTY, R.string.invaild_name);
        //for mobile number
        awesomeValidation.addValidation(this, R.id.et_mobile,
                "[5-9]{1}[0-9]{9}$", R.string.invalid_mobile_no);
        //for email
        awesomeValidation.addValidation(this, R.id.email,
                Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        //for website
        awesomeValidation.addValidation(this, R.id.et_website
                , Patterns.WEB_URL, R.string.invaild_website);
        awesomeValidation.addValidation(this, R.id.et_password,
                ".{6,}", R.string.invaild_password);
        awesomeValidation.addValidation(this, R.id.et_confirm_password,
                R.id.et_confirm_password, R.string.invaild_confirmpassword);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check validation
                if (awesomeValidation.validate()) {
                    //on sucess
                    Toast.makeText(getApplicationContext(), "from validate sucessfully..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "validation fail", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
