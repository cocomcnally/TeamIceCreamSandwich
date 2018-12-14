package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends Activity implements View.OnClickListener{

    Button  buttonInterests, buttonSecutrity;
    Button  buttonFAQ, buttonLegal, buttonAbout, buttonUsername;
    Button  buttonHomepage;
    TextView    textViewSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        buttonInterests = findViewById(R.id.buttonInterests);
        buttonSecutrity = findViewById(R.id.buttonSecurity);
        buttonFAQ = findViewById(R.id.buttonFAQ);
        buttonLegal = findViewById(R.id.buttonLegal);
        buttonAbout = findViewById(R.id.buttonAbout);
        buttonUsername = findViewById(R.id.buttonUsername);
        buttonHomepage = findViewById(R.id.buttonHomepage);
        textViewSettings= findViewById(R.id.textViewSettings);


        buttonInterests.setOnClickListener(this);
        buttonSecutrity.setOnClickListener(this);
        buttonFAQ.setOnClickListener(this);
        buttonLegal.setOnClickListener(this);
        buttonAbout.setOnClickListener(this);
        buttonUsername.setOnClickListener(this);
        buttonHomepage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){
            Intent intentHomePage = new Intent(Settings.this, HomePage.class);
            startActivity(intentHomePage);
        }



    }
}

