package com.example.coffeeeight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView counter,ourBill;
    public Button minus,plus,order;
    public int no_coffee=0,price_per_cup=100,total_price=0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = findViewById(R.id.counter);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        ourBill = findViewById(R.id.ourBill);
        order = findViewById(R.id.order);


    }

//    public void btnMinus
    public void btnMinus(View view){

        no_coffee--;
        if(no_coffee < 1) {
            Toast.makeText(getApplicationContext(), "no cups selected ", Toast.LENGTH_LONG).show();
            no_coffee = 0;
        }

       else{
            total_price = no_coffee * price_per_cup;
            counter.setText(""+no_coffee);

            setOurBill();
        }

    }

    public void btnPlus(View view){

        no_coffee++;
        if(no_coffee > 19) {
            no_coffee = 20;
        }


        total_price = no_coffee * price_per_cup;
        counter.setText("" + no_coffee);


        setOurBill();

    }

    public void btnOrder(View view){
        Toast.makeText(getApplicationContext(),"coffee ordered "+no_coffee+" total price"+total_price,Toast.LENGTH_LONG).show();
    }

//    function when called should display our bill
    public void setOurBill(){
        ourBill.setText("coffee ordered :"+no_coffee+"\t"+"the total price"+total_price);
        Toast.makeText(getApplicationContext(),"total price of "+no_coffee+" cups is   "+total_price,Toast.LENGTH_LONG).show();

    }
}