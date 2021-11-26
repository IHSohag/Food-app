package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int images[] = {R.drawable.beaf_burger,R.drawable.burger,R.drawable.chicken_burger,R.drawable.dimaonds_pizza,
                    R.drawable.fresh_pizza,R.drawable.instant_burger,R.drawable.pizza,R.drawable.pizza_burger,R.drawable.vegitable_burger};
    String foodNames[];
    String descriptionNames[];
    String[] foodPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);

        foodNames = getResources().getStringArray(R.array.food_Name);
        descriptionNames = getResources().getStringArray(R.array.food_Description);
        foodPrice = getResources().getStringArray(R.array.food_Price);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),images,foodNames,descriptionNames,foodPrice);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //set onCreate method
       customAdapter.setOnItemClickListener(new CustomAdapter.ClickListener() {
           @Override
           public void onItemClick(int position, View view) {
               String price = foodPrice[position];
               String string = foodNames[position];
               //Toast.makeText(getApplicationContext(), string+" item "+position+" is clicked", Toast.LENGTH_SHORT).show();

               if (position==0){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==1){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==2){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==3){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==4){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==5){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==6){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==7){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
               if (position==8){
                   Intent intent = new Intent(MainActivity.this,CartView.class);
                   intent.putExtra("Tag",string);
                   startActivity(intent);
               }
           }
       });

    }
}