package com.example.cjmcn.teamicecreamsandwich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends Activity implements View.OnClickListener{

    EditText    editTextEnterName, editTextEnterPhoneNumber, editTextEnterUserName, editTextEnterInterests;
    EditText    editTextEnterCurrentLocation, editTextEnterEmail, editTextEnterPassword, editTextConfirmPassword;
    TextView    textViewPrivacy;
    Button      buttonSignUp;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        editTextEnterName = findViewById(R.id.editTextEnterName);
        editTextEnterPhoneNumber = findViewById(R.id.editTextEnterPhoneNumber);
        editTextEnterUserName = findViewById(R.id.editTextEnterUserName);
        editTextEnterInterests = findViewById(R.id.editTextEnterInterests);
        editTextEnterCurrentLocation = findViewById(R.id.editTextEnterCurrentLocation);
        editTextEnterEmail = findViewById(R.id.editTextEnterEmail);
        editTextEnterPassword = findViewById(R.id.editTextEnterPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        textViewPrivacy = findViewById(R.id.textViewPrivacy);

        buttonSignUp.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        if (v == buttonSignUp) {
            mAuth.createUserWithEmailAndPassword(editTextEnterUserName.getText().toString(), editTextEnterPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                FirebaseUser user = mAuth.getCurrentUser();
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(Signup.this, "Welcome", Toast.LENGTH_SHORT).show();
                                Intent intentHomePage = new Intent(Signup.this, HomePage.class );
                                startActivity(intentHomePage);

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(Signup.this, "Access Denied", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        } /*else if(v == buttonLogIn) {

            mAuth.signInWithEmailAndPassword(editTextEnterUserName.getText().toString(), editTextEnterPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser currentUser = mAuth.getCurrentUser();
                                Toast.makeText(Signup.this, "Login Successful ", Toast.LENGTH_SHORT).show();
                                Intent intentMainScreen = new Intent(Signup.this, HomePage.class);
                                startActivity(intentMainScreen);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(Signup.this, "Access Denied", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });


        }*/


    }



}


