package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText nameEditText, emailEditText, usernameEditText, passwordEditText;
    Button signupButton;

    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nameEditText = findViewById(R.id.signupNameEditTextId);
        emailEditText = findViewById(R.id.signupEmailEditTextId);
        usernameEditText = findViewById(R.id.signupUsernameEditTextId);
        passwordEditText = findViewById(R.id.signupPasswordEditTextId);
        signupButton = findViewById(R.id.signupButtonId);

        signupButton.setOnClickListener(this);

        userDetails = new UserDetails();
        databaseHelper = new DatabaseHelper(this);

    }

    @Override
    public void onClick(View view) {

            String name = nameEditText.getText().toString();
            userDetails.setName(name);

        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();


        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseHelper.insertData(userDetails);

        if (rowId > 0) {
            Intent intent = new Intent(Signup.this,Login.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Row " + rowId + " is successfully inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Row insertion failed", Toast.LENGTH_SHORT).show();
        }
    }
}