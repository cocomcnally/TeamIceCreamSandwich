package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchEvent extends Activity implements View.OnClickListener {

    Button buttonFindbyname, buttonFindbytype, buttonFindbydate;
    EditText editFindbyname, editFindbydate, editFindbytype;
    TextView textViewSearch;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);

    buttonFindbydate = findViewById(R.id.buttonFindbydate);
    buttonFindbyname = findViewById(R.id.buttonFindbyname);
    buttonFindbytype = findViewById(R.id.buttonFindbytype);
    editFindbydate = findViewById(R.id.editFindbydate);
    editFindbyname = findViewById(R.id.editFindbyname);
    editFindbytype = findViewById(R.id.editFindbytype);
    textViewSearch = findViewById(R.id.textViewSearch);

    buttonFindbytype.setOnClickListener(this);
    buttonFindbyname.setOnClickListener(this);
    buttonFindbydate.setOnClickListener(this);

     mAuth = FirebaseAuth.getInstance();

    }



    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.navmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuLogout) {
            Intent intentLogout = new Intent(this, MainActivity.class);
            startActivity(intentLogout);
        } else if (item.getItemId() == R.id.menuSearch) {
            Toast.makeText(this, "You are already on Search Page", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menuEvents) {
            Intent intentEvents = new Intent(this, Events.class);
            startActivity(intentEvents);
        } else if (item.getItemId() == R.id.menuSetting){
            Intent intentSettings = new Intent(this, Settings.class);
            startActivity(intentSettings);
        } else if (item.getItemId() == R.id.menuHomepage){
            Intent intentHomepage = new Intent(this, HomePage.class);
            startActivity(intentHomepage);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Eventstorage");

        if(v==buttonFindbydate){

            String findDate = editFindbydate.getText().toString();
            myRef.orderByChild("date").equalTo(findDate).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String findKey = dataSnapshot.getKey();
                    Eventstorage findEvent = dataSnapshot.getValue(Eventstorage.class);

                    textViewSearch.setText("Events by selected date: " + findEvent.title + "\n" + "Taking place on: " + findEvent.date + "\n" + "With a group of: " + findEvent.numpeople + "\n" + "Enjoy the " + findEvent.type + " event!");
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } else if (v==buttonFindbyname){

            String findTitle = editFindbyname.getText().toString();
            myRef.orderByChild("title").limitToFirst(5).equalTo(findTitle).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String findKey = dataSnapshot.getKey();
                    Eventstorage findEvent = dataSnapshot.getValue(Eventstorage.class);

                    textViewSearch.setText("Events by title: " + findEvent.title + "\n" + "Taking place on: " + findEvent.date + "\n" + "With a group of: " + findEvent.numpeople + "\n" + "Enjoy the " + findEvent.type + " event!");
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } else if (v==buttonFindbytype) {
            String findType = editFindbytype.getText().toString();
            myRef.orderByChild("type").limitToFirst(5).equalTo(findType).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String findKey = dataSnapshot.getKey();
                    Eventstorage findEvent = dataSnapshot.getValue(Eventstorage.class);

                    textViewSearch.setText("Events by type: " + findEvent.title + "\n" + "Taking place on: " + findEvent.date + "\n" + "With a group of: " + findEvent.numpeople + "\n" + "Enjoy the " + findEvent.type + " event!");
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
}
