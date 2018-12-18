package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Security extends Activity implements View.OnClickListener{

    Button buttonHomepage;
    TextView textViewSecurity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        buttonHomepage = findViewById(R.id.buttonHomepage);
        textViewSecurity = findViewById(R.id.textViewSecurity);

        buttonHomepage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){

            Intent intentHomepage = new Intent(Security.this, HomePage.class);
            startActivity(intentHomepage);
        }
    }
}
