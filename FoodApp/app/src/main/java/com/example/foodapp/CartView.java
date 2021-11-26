package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CartView extends AppCompatActivity {

    ImageView imageView;
    TextView foodName,mainPriceTextView,countTextView,descriptionTextView,priceTextView;
    Button plusButton,minusButton,orderButton;
    float price;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        initialized();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String info =  bundle.getString("Tag");
            showDetails(info);
        }
        workingWithButton();
    }
    private void initialized() {
        imageView = findViewById(R.id.headingImageId);
        foodName = findViewById(R.id.foodNameId);
        mainPriceTextView = findViewById(R.id.mainPriceTextViewId);
        countTextView = findViewById(R.id.countTextViewId);
        descriptionTextView = findViewById(R.id.description2TextViewId);
        priceTextView = findViewById(R.id.priceTextViewId);
        plusButton = findViewById(R.id.plusButtonId);
        minusButton = findViewById(R.id.minusButtonId);
        orderButton = findViewById(R.id.orderButtonId);
    }
    private void workingWithButton() {

        //int value = Integer.parseInt(mainPriceTextView.getText().toString());
        float value = Float.parseFloat(mainPriceTextView.getText().toString());

            plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price =  (price+value);
                priceTextView.setText(""+price);
                count = count+1;
                countTextView.setText(""+count);
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count !=0 && price !=0){
                    count--;
                    price = (price-value);
                    priceTextView.setText(""+price);
                    countTextView.setText(""+count);
                }
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price==0.00){
                    Toast.makeText(getApplicationContext(), "Please change count value", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(CartView.this,payment.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void showDetails(String info) {
        if (info.equals("Beaf Burger")){
            imageView.setImageResource(R.drawable.beaf_burger);
            mainPriceTextView.setText("5.50");
            foodName.setText("Beaf Burger");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Burger")){
            imageView.setImageResource(R.drawable.burger);
            mainPriceTextView.setText("5");
            foodName.setText("Burger");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Chicken Burger")){
            imageView.setImageResource(R.drawable.chicken_burger);
            mainPriceTextView.setText("5");
            foodName.setText("Chicken Burger");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Diamonds Pizza")){
            imageView.setImageResource(R.drawable.dimaonds_pizza);
            mainPriceTextView.setText("5");
            foodName.setText("Diamonds Pizza");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Fresh Pizza")){
            imageView.setImageResource(R.drawable.fresh_pizza);
            mainPriceTextView.setText("5");
            foodName.setText("Fresh Pizza");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Instant Burger")){
            imageView.setImageResource(R.drawable.instant_burger);
            mainPriceTextView.setText("5");
            foodName.setText("Instant Burger");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Pizza")){
            imageView.setImageResource(R.drawable.pizza);
            mainPriceTextView.setText("5");
            foodName.setText("Pizza");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Pizza Burger")){
            imageView.setImageResource(R.drawable.pizza_burger);
            mainPriceTextView.setText("5");
            foodName.setText("Pizza Burger");
            descriptionTextView.setText("this is description.here you will ...");
        }
        if (info.equals("Vegetable Burger")){
            imageView.setImageResource(R.drawable.vegitable_burger);
            mainPriceTextView.setText("5");
            foodName.setText("Vegetable Burger");
            descriptionTextView.setText("this is description.here you will ...");
        }
    }
}