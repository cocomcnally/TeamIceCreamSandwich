package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                    textViewSearch.setText("Events by selected date: " + findEvent.title);
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

                    textViewSearch.setText("Events by title: " + findEvent.title);
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
            String findType = editFindbyname.getText().toString();
            myRef.orderByChild("type").limitToFirst(5).equalTo(findType).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String findKey = dataSnapshot.getKey();
                    Eventstorage findEvent = dataSnapshot.getValue(Eventstorage.class);

                    textViewSearch.setText("Events by type: " + findEvent.title);
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
