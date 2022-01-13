package com.example.coffeebrake3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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
        if (cups > 10) {
            Snackbar snackbar = Snackbar.make(view, getString(R.string.morethan10cups), Snackbar.LENGTH_SHORT);
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.morethan10cups), Toast.LENGTH_SHORT);
            toast.show();
            snackbar.show();
            cups = 10;
        }
        display(cups);
    }

    public void substraction(View view) {
        cups = cups - 1;
        if (cups < 0) {
            Snackbar snackbar = Snackbar.make(view, getString(R.string.lessthan0cups), Snackbar.LENGTH_SHORT);
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.lessthan0cups), Toast.LENGTH_SHORT);
            toast.show();
            snackbar.show();
            cups = 0;
        }

        display(cups);
    }

    public void order(View view) {
        int ToppingPrice = 0;
        if (((CheckBox) findViewById(R.id.chckbx)).isChecked() == true)
            ToppingPrice += 1;
        if (((CheckBox) findViewById(R.id.chckbx2)).isChecked() == true)
            ToppingPrice += 2;
        displayPrice(cups*(5 + ToppingPrice));
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
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, CheckName(findViewById(R.id.EdtTxtName)));
        intent.putExtra(Intent.EXTRA_TEXT, "Name: " + CheckName(findViewById(R.id.EdtTxtName)) + "\n" +  CheckTop(findViewById(R.id.chckbx)) + "\n" + CheckTop(findViewById(R.id.chckbx2)) + "\nTotal = " + NumberFormat.getCurrencyInstance(Locale.US).format(num)+ "\nThank you");
        if (intent.resolveActivity(getPackageManager()) == null) {
            startActivity(intent);
        }
    }

    public void display(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.numbofquant);
        quantityTextView.setText("" + num);
    }
}