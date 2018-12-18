package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends Activity implements View.OnClickListener{

    Button  buttonInterests, buttonSecurity;
    Button  buttonFAQ, buttonLegal, buttonAbout, buttonUsername;
    Button  buttonHomepage;
    TextView    textViewSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        buttonInterests = findViewById(R.id.buttonInterests);
        buttonSecurity = findViewById(R.id.buttonSecurity);
        buttonFAQ = findViewById(R.id.buttonFAQ);
        buttonLegal = findViewById(R.id.buttonLegal);
        buttonAbout = findViewById(R.id.buttonAbout);
        buttonUsername = findViewById(R.id.buttonUsername);
        buttonHomepage = findViewById(R.id.buttonHomepage);
        textViewSettings= findViewById(R.id.textViewSettings);


        buttonInterests.setOnClickListener(this);
        buttonSecurity.setOnClickListener(this);
        buttonFAQ.setOnClickListener(this);
        buttonLegal.setOnClickListener(this);
        buttonAbout.setOnClickListener(this);
        buttonUsername.setOnClickListener(this);
        buttonHomepage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){
            Intent intentHomePage = new Intent(this, HomePage.class);
            startActivity(intentHomePage);
        }

        else if(v == buttonInterests){
            Intent  intentInterests = new Intent(this, Interests.class);
            startActivity(intentInterests);
        }

        else if(v == buttonUsername){
            Intent  intentUsername = new Intent(this, Username.class);
            startActivity(intentUsername);
        }

        else if(v == buttonSecurity){
            Intent  intentSecurity = new Intent(this, Security.class);
            startActivity(intentSecurity);
        }

        else if(v == buttonFAQ){
            Intent  intentFAQ = new Intent(this, FAQ.class);
            startActivity(intentFAQ);
        }

        else if(v == buttonLegal){
            Intent  intentLegal = new Intent(this, Legal.class);
            startActivity(intentLegal);
        }

        else if(v == buttonAbout){
            Intent  intentAbout = new Intent(this, About.class);
            startActivity(intentAbout);
        }



    }
}

