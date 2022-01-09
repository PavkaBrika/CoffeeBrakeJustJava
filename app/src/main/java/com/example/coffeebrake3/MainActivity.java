package com.example.coffeebrake3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int cups = 0;



    public void addition(View view) {
        cups = cups + 1;
        TextView quantityTextView = (TextView) findViewById(R.id.numbofquant);
        quantityTextView.setText("" + cups);
    }

    public void substraction(View view) {
        cups = cups - 1;
        if (cups < 0)
            cups = 0;
        TextView quantityTextView = (TextView) findViewById(R.id.numbofquant);
        quantityTextView.setText("" + cups);
    }
}