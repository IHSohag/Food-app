package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    Spinner spinner;
    EditText numberEditText,passwordEditText;
    Button confirmButton;
    String paymentMethod[]={"Select one","Bkash","Nogod","Dutch Bangla","Rocket","U-pay"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        spinner = findViewById(R.id.spinnerId);
        numberEditText = findViewById(R.id.numberEditTextId);
        passwordEditText = findViewById(R.id.passwordEditTextId);
        confirmButton = findViewById(R.id.confirmButtonId);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.sippiner_layout,R.id.itemLayoutId,paymentMethod);
        spinner.setAdapter(arrayAdapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = numberEditText.getText().toString();
                    Toast.makeText(getApplicationContext(), "Your payment is successfully done!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}