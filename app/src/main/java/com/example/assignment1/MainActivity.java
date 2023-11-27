package com.example.assignment1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnMilk;
    private Button btnSugar;
    private Button btnFlour;
    private Button btnBread;
    private TextView milkPriceTextView;
    private TextView milkVatTextView;
    private TextView milkActualPriceTextView;
    private TextView sugarPriceTextView;
    private TextView sugarVatTextView;
    private TextView sugarActualPriceTextView;
    private TextView flourPriceTextView;
    private TextView flourVatTextView;
    private TextView flourActualPriceTextView;
    private TextView breadPriceTextView;
    private TextView breadVatTextView;
    private TextView breadActualPriceTextView;
    private TextView grandTotalTextView;
    private TextView discountTextView;
    private TextView netPayTextView;


    private double milkPrice = 100.0; // Initial price of milk
    private double sugarPrice = 250.0; // Initial price of
    private double flourPrice = 200.0; // Initial price of flour
    private double breadPrice = 50.0; // Initial price of bread
    private double grandTotal = 0.0; //Initial grand-total

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMilk = findViewById(R.id.btnMilk);
        btnSugar = findViewById(R.id.btnSugar);
        btnFlour = findViewById(R.id.btnFlour);
        btnBread = findViewById(R.id.btnBread);
        milkPriceTextView = findViewById(R.id.priceMilk);
        milkVatTextView = findViewById(R.id.vatMilk);
        milkActualPriceTextView = findViewById(R.id.actualPriceMilk);
        sugarPriceTextView = findViewById(R.id.priceSugar);
        sugarVatTextView = findViewById(R.id.vatSugar);
        sugarActualPriceTextView = findViewById(R.id.actualPriceSugar);
        flourPriceTextView = findViewById(R.id.priceFlour);
        flourVatTextView = findViewById(R.id.vatFlour);
        flourActualPriceTextView = findViewById(R.id.actualPriceFlour);
        breadPriceTextView = findViewById(R.id.priceBread);
        breadVatTextView = findViewById(R.id.vatBread);
        breadActualPriceTextView = findViewById(R.id.actualPriceBread);
        grandTotalTextView = findViewById(R.id.grandTotal);
        discountTextView = findViewById(R.id.discount);
        netPayTextView = findViewById(R.id.netPay);




        btnMilk.setOnClickListener(new View.OnClickListener() {
            int clickCount = 0; // Keep track of button clicks

            @Override
            public void onClick(View v) {
                if (clickCount < 5) {
                    clickCount++;

                    // Calculate the prices
                    double price = milkPrice * clickCount;
                    double vatPrice = price * 0.16;
                    double actualPrice = price * 0.84;

                    // Update the TextViews with the calculated values
                    milkPriceTextView.setText(String.valueOf(price));
                    milkVatTextView.setText(String.valueOf(vatPrice));
                    milkActualPriceTextView.setText(String.valueOf(actualPrice));

                    grandTotal += actualPrice;
                    grandTotalTextView.setText(String.valueOf(grandTotal));
                    calculateDiscount();
                    calculateNetPay();

                }
            }
        });

        btnSugar.setOnClickListener(new View.OnClickListener() {
            int clickCount = 0; // Keep track of button clicks

            @Override
            public void onClick(View v) {
                if (clickCount < 5) {
                    clickCount++;

                    // Calculate the prices for Sugar
                    double price = sugarPrice * clickCount;
                    double vatPrice = price * 0.16;
                    double actualPrice = price * 0.84;

                    // Update the TextViews with the calculated values for Sugar
                    sugarPriceTextView.setText(String.valueOf(price));
                    sugarVatTextView.setText(String.valueOf(vatPrice));
                    sugarActualPriceTextView.setText(String.valueOf(actualPrice));

                    grandTotal += actualPrice;
                    grandTotalTextView.setText(String.valueOf(grandTotal));
                    calculateDiscount();
                    calculateNetPay();
                }
            }
        });

        btnFlour.setOnClickListener(new View.OnClickListener() {
            int clickCount = 0; // Keep track of button clicks

            @Override
            public void onClick(View v) {
                if (clickCount < 5) {
                    clickCount++;

                    // Calculate the prices
                    double price = flourPrice * clickCount;
                    double vatPrice = price * 0.16;
                    double actualPrice = price * 0.84;

                    // Update the TextViews with the calculated values
                    flourPriceTextView.setText(String.valueOf(price));
                    flourVatTextView.setText(String.valueOf(vatPrice));
                    flourActualPriceTextView.setText(String.valueOf(actualPrice));

                    grandTotal += actualPrice;
                    grandTotalTextView.setText(String.valueOf(grandTotal));
                    calculateDiscount();
                    calculateNetPay();
                }
            }
        });

        btnBread.setOnClickListener(new View.OnClickListener() {
            int clickCount = 0; // Keep track of button clicks

            @Override
            public void onClick(View v) {
                if (clickCount < 5) {
                    clickCount++;

                    // Calculate the prices
                    double price = breadPrice * clickCount;
                    double vatPrice = price * 0.16;
                    double actualPrice = price * 0.84;

                    // Update the TextViews with the calculated values
                    breadPriceTextView.setText(String.valueOf(price));
                    breadVatTextView.setText(String.valueOf(vatPrice));
                    breadActualPriceTextView.setText(String.valueOf(actualPrice));

                    grandTotal += actualPrice;
                    grandTotalTextView.setText(String.valueOf(grandTotal));
                    calculateDiscount();
                    calculateNetPay();
                }
            }
        });

    }



    // Calculate the discount
    private void calculateDiscount() {
        if (grandTotal > 1000) {
            double discount = grandTotal * 0.15;
            String formattedDiscount = String.format("%.2f", discount); // Format the discount value to two decimal places
            discountTextView.setText(formattedDiscount);
        } else {
            discountTextView.setText("");
            showNoDiscountToast();
        }
    }

    // Show a toast message for no discount
    private void showNoDiscountToast() {
        Toast.makeText(this, "No discount awarded", Toast.LENGTH_SHORT).show();
    }

    // Calculate the net pay
    private void calculateNetPay() {
        if (grandTotal > 1000) {
            double netPay = grandTotal * 0.85;
            String formattedNetPay = String.format("%.2f", netPay); // Format netPay to two decimal places
            netPayTextView.setText(formattedNetPay);
        } else {
            netPayTextView.setText(""); // Clear the net pay if not eligible
        }
    }




}

