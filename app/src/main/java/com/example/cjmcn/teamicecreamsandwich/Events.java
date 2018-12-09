package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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


public class Events extends Activity implements View.OnClickListener {


    Button buttonCreate, buttonEdit, buttonFind;
    EditText editTextCreateEventTitle, editTextCreateEventType, editTextCreateEventDate, editTextCreateNumPeople, editTextEditEventTitle, editTextEditEventDate;
    EditText editTextFindEventType;
    TextView textViewShowEvents;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonFind = findViewById(R.id.buttonFind);

        editTextCreateEventTitle = findViewById(R.id.editTextCreateEventTitle);
        editTextCreateEventType = findViewById(R.id.editTextCreateEventType);
        editTextCreateEventDate = findViewById(R.id.editTextCreateEventDate);
        editTextCreateNumPeople = findViewById(R.id.editTextCreateNumPeople);
        editTextEditEventDate = findViewById(R.id.editTextEditEventDate);
        editTextEditEventTitle = findViewById(R.id.editTextEditEventTitle);
        editTextFindEventType = findViewById(R.id.editTextFindEventType);

        textViewShowEvents = findViewById(R.id.textViewShowEvents);

        buttonCreate.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);
        buttonFind.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Eventstorage");

        //myRef.setValue("Testing");

        if (v == buttonCreate) {


            String createTitle = editTextCreateEventTitle.getText().toString();
            String createType = editTextCreateEventType.getText().toString();
            String createDate = editTextCreateEventDate.getText().toString();
            String createNumPeople = editTextCreateNumPeople.getText().toString();
            //sequence matters! Need to match that of book.java
            Eventstorage newEvent = new Eventstorage(createTitle, createType, createDate, createNumPeople);

            myRef.push().setValue(newEvent);

        } else if (v == buttonEdit) {

            String editTitle = editTextEditEventTitle.getText().toString();
            final String editDate = editTextEditEventDate.getText().toString();

            //Order the titles, sorted by the one I'm editing
            myRef.orderByChild("title").equalTo(editTitle).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    String editKey = dataSnapshot.getKey();

                    //go to the child that matches the key
                    myRef.child(editKey).child("condition").setValue(editDate);

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

        } /*else if (v == buttonDelete) {

            String deleteCondition = editTextDeleteCondition.getText().toString();

            //myRef.orderByChild("author").equalTo(deleteAuthor).limitToFirst(1);
            myRef.orderByChild("condition").equalTo(deleteCondition).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    String deleteKey = dataSnapshot.getKey();

                    myRef.child(deleteKey).setValue(null);

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


        }*/

        else if (v == buttonFind) {

            String findType = editTextFindEventType.getText().toString();

            myRef.orderByChild("type").equalTo(findType).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    String findKey = dataSnapshot.getKey();
                    Eventstorage findEvent = dataSnapshot.getValue(Eventstorage.class);

                    textViewShowEvents.setText("Events by selected type: " + findEvent.title);

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
