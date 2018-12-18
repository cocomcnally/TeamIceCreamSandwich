package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Legal extends Activity implements View.OnClickListener{

    Button buttonHomepage;
    TextView textViewLegal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal);

        buttonHomepage = findViewById(R.id.buttonHomepage);
        textViewLegal = findViewById(R.id.textViewLegal);

        buttonHomepage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){

            Intent intentHomepage = new Intent(Legal.this, HomePage.class);
            startActivity(intentHomepage);
        }
    }
}
