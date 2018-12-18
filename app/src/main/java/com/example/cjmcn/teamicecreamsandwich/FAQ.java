package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FAQ extends Activity implements View.OnClickListener{

    Button buttonHomepage;
    TextView textViewFAQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        buttonHomepage = findViewById(R.id.buttonHomepage);
        textViewFAQ = findViewById(R.id.textViewFAQ);

        buttonHomepage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){

            Intent intentHomepage = new Intent(FAQ.this, HomePage.class);
            startActivity(intentHomepage);
        }
    }
}
