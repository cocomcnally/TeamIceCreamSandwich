package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signup extends Activity implements View.OnClickListener{

    EditText    editTextEnterName, editTextEnterPhoneNumber, editTextEnterUserName, editTextEnterInterests;
    EditText    editTextEnterCurrentLocation, editTextEnterEmail, editTextEnterPassword, editTextConfirmPassword;
    TextView    textViewPrivacy;
    Button      buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        editTextEnterName = findViewById(R.id.editTextEnterName);
        editTextEnterPhoneNumber = findViewById(R.id.editTextEnterPhoneNumber);
        editTextEnterUserName = findViewById(R.id.editTextEnterName);
        editTextEnterInterests = findViewById(R.id.editTextEnterInterests);
        editTextEnterCurrentLocation = findViewById(R.id.editTextEnterCurrentLocation);
        editTextEnterEmail = findViewById(R.id.editTextEnterPhoneNumber);
        editTextEnterPassword = findViewById(R.id.editTextEnterName);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        textViewPrivacy = findViewById(R.id.textViewPrivacy);

        buttonSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
