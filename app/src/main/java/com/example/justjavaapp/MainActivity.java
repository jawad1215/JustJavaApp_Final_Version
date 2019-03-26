package com.example.justjavaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage="Total= $" + (quantity*5);
        priceMessage=priceMessage+ "\nThank You";
        displayMessage(priceMessage);
        Toast.makeText(getApplicationContext(),"Order Submitted",Toast.LENGTH_SHORT).show();


    }

    public void increment(View view)
    {
        quantity=quantity+1;
        display(quantity);
        displayPrice(quantity*5);
    }
    public void decrement(View view)
    {
        if(quantity!=0)
        {
            quantity=quantity-1;
        } else
            {
            quantity=0;
        }


        display(quantity);
        displayPrice(quantity*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number)
    {
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message)
    {
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
