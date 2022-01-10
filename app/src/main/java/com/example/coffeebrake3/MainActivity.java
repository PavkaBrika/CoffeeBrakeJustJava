package com.example.coffeebrake3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int cups = 0;



    public void addition(View view) {
        cups = cups + 1;
        display(cups);
    }

    public void substraction(View view) {
        cups = cups - 1;
        if (cups < 0)
            cups = 0;
        display(cups);
    }

    public void order(View view) {
        displayPrice(cups*5);

    }

    public void displayPrice(int num) {
        TextView priceTextView = (TextView) findViewById(R.id.numberofprice);
        priceTextView.setVisibility(View.VISIBLE);
        CheckBox cream = (CheckBox) findViewById(R.id.chckbx);
        boolean check = cream.isChecked();
        if (check==true)
        priceTextView.setText("Add whipped cream? true \nTotal = " + NumberFormat.getCurrencyInstance(Locale.US).format(num)+ "\nThank you");
        else
            priceTextView.setText("Add whipped cream? false \nTotal = " + NumberFormat.getCurrencyInstance(Locale.US).format(num)+ "\nThank you");
    }

    public void display(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.numbofquant);
        quantityTextView.setText("" + num);
    }
}