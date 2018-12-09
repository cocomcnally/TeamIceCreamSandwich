package com.example.cjmcn.teamicecreamsandwich;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSignin, buttonSignup;
    EditText editTextUser, editTextPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignin = findViewById(R.id.buttonSignin);
        buttonSignup = findViewById(R.id.buttonSignup);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUser = findViewById(R.id.editTextUser);

        buttonSignin.setOnClickListener(this);
        buttonSignup.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonSignup){

            Intent intentSignup = new Intent(this, Signup.class);
            startActivity(intentSignup);

        } else if(v == buttonSignin) {

            mAuth.signInWithEmailAndPassword(editTextUser.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(MainActivity.this, "Logging in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });


        }
    }
}
