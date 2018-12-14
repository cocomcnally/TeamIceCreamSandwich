package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends Activity implements View.OnClickListener {

    Button buttonLogout, buttonSettings, buttonCreate, buttonSearch;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonLogout = findViewById(R.id.buttonLogout);

        buttonCreate.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
        buttonSettings.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.navmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onClick(View v) {
        if (v == buttonCreate){
            Intent intentEvents = new Intent(this, Events.class);
            startActivity(intentEvents);
        } else if (v == buttonLogout){
            Intent intentLogout = new Intent(this, MainActivity.class);
            startActivity(intentLogout);
        } else if (v == buttonSettings) {
            Intent intentSettings = new Intent(this, Settings.class);
            startActivity(intentSettings);
        } else if (v == buttonSearch) {
            Intent intentSearch = new Intent(this, SearchEvent.class);
            startActivity(intentSearch);
        }
    }
}
