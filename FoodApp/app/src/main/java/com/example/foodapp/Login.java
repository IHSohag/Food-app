package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    EditText usernameEditText,passwordEditText;
    Button signInButton,firstSignupButton;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.signInUsernameEditTextId);
        passwordEditText = findViewById(R.id.signInPasswordEditTextId);
        signInButton = findViewById(R.id.signInButtonId);
        firstSignupButton = findViewById(R.id.signUpHereButtonId);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        signInButton.setOnClickListener(this);
        firstSignupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (view.getId() == R.id.signInButtonId){
            // Boolean result = databaseHelper.findPassword(username,password);
            Boolean result = databaseHelper.findPassword(username,password);
            if (result==true){
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "username and password didn't match", Toast.LENGTH_SHORT).show();
            }
        }

        else if (view.getId()==R.id.signUpHereButtonId){
            //Toast.makeText(MainActivity.this, "signup button is clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this,Signup.class);
            startActivity(intent);
        }

    }
}