package com.example.justjavaapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int quantity;
    String whippedcream;
    int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolateChecked = chocolateCheckBox.isChecked();
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        createOrderSummary(quantity, hasWhippedCream, hasChocolateChecked, name);


    }

    public void createOrderSummary(int price, boolean addWhippedCream, boolean addChoco, String nam) {
        total = quantity * 5;
        if (addWhippedCream) {
            total = total + quantity * 1;

        }
        if (addChoco) {
            total = total + quantity * 2;


        }

        String totalPrice = "Total Price is $" + total;


        String priceMessage = "Name: " + nam + "\nAdd whipped Cream? " + addWhippedCream + "\nAdd Chocolate ? " + addChoco +
                "\nQuantity :" + quantity + "\n" + totalPrice + "\nThank You";
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity != 0) {
            quantity = quantity - 1;
        } else {
            quantity = 0;
        }


        display(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


}
