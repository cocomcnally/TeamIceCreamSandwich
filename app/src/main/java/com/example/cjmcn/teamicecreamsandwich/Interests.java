package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Interests extends Activity implements View.OnClickListener {

    TextView textViewInterests;
    Button buttonHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        textViewInterests = findViewById(R.id.textViewInterests);
        buttonHomepage = findViewById(R.id.buttonHomepage);

        buttonHomepage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){

            Intent intentHomepage = new Intent(Interests.this, HomePage.class);
            startActivity(intentHomepage);
        }
    }
}
