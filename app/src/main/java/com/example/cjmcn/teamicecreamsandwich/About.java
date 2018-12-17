package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

public class About extends Activity implements View.OnClickListener{

    Button buttonHomepage;
    TextView textViewAbout, textViewObjective, textViewObjectiveDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        buttonHomepage.findViewById(R.id.buttonHomepage);
        textViewAbout.findViewById(R.id.textViewAbout);
        textViewObjective.findViewById(R.id.textViewObjective);
        textViewObjectiveDescription.findViewById(R.id.textViewObjectiveDescription);

        buttonHomepage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == buttonHomepage){

            Intent  intentHomepage = new Intent(About.this, HomePage.class);
            startActivity(intentHomepage);
        }
    }
}


