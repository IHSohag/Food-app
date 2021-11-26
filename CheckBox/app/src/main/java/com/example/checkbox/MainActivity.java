package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox coffee,sugar,water,juice;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffee = findViewById(R.id.coffeeId);
        sugar = findViewById(R.id.sugarId);
        water = findViewById(R.id.waterId);
        juice = findViewById(R.id.juiceId);
        button = findViewById(R.id.buttonId);
        textView = findViewById(R.id.textViewID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder builder = new StringBuilder();
                if (coffee.isChecked()){
                    String value = coffee.getText().toString();
                    builder.append(value);
                }if (sugar.isChecked()){
                    String value = sugar.getText().toString();
                    builder.append(value);
                }if (water.isChecked()){
                    String value = water.getText().toString();
                    builder.append(value);
                }if (juice.isChecked()){
                    String value = juice.getText().toString();
                    builder.append(value);
                }
                textView.setText(builder);
            }
        });

    }
}