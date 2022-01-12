package com.example.coffeebrake3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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

    public String CheckTop(View view) {
        String TopCond = "";
        CheckBox top = (CheckBox) view;
        boolean check = top.isChecked();
        if (view.getId() == R.id.chckbx) {
            if (check == true)
                TopCond = "Whipped cream? True ";
            else
                TopCond = "Whipped cream? False ";
        }
        else {
            if (check == true)
                TopCond = "Chocolate top? True ";
            else
                TopCond = "Chocolate top? False ";
        }
        return TopCond;
    }

    public String CheckName(View view) {
        EditText Name = (EditText) view;
        String OrderName = Name.getText().toString();
        return OrderName;
    }

    public void displayPrice(int num) {
        TextView priceTextView = (TextView) findViewById(R.id.numberofprice);
        priceTextView.setVisibility(View.VISIBLE);
        priceTextView.setText("Name: " + CheckName(findViewById(R.id.EdtTxtName)) + "\n" +  CheckTop(findViewById(R.id.chckbx)) + "\n" + CheckTop(findViewById(R.id.chckbx2)) + "\nTotal = " + NumberFormat.getCurrencyInstance(Locale.US).format(num)+ "\nThank you");
    }

    public void display(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.numbofquant);
        quantityTextView.setText("" + num);
    }
}