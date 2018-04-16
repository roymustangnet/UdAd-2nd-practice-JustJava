package com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText userNameEditText = (EditText) findViewById(R.id.name_field);
        String value = userNameEditText.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCreamCheckBox = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolateCheckBox = chocolateCheckbox.isChecked();

        int price = calculatePrice(hasWhippedCreamCheckBox, hasChocolateCheckBox);
        String displayMessage = createOrderSummary(price, hasWhippedCreamCheckBox, hasChocolateCheckBox, value);
        displayMessage(displayMessage);
    }

    private String createOrderSummary(int price, boolean addWhippedCreamCheckBox, boolean addChocolate, String name) {
        String displayMessage = "Name: " + name;
        displayMessage += "\nAdd whipped cream? " + addWhippedCreamCheckBox;
        displayMessage += "\nAdd chocolate? " + addChocolate;
        displayMessage += "\nQuantity: " + quantity;
        displayMessage += "\nTotal: $" + price;
        displayMessage += "\nThank you!";
        return displayMessage;
    }

    private int calculatePrice(boolean addWhippedCreamCheckBox, boolean addChocolateCheckBox){
        int singlePrice = 5;
        if (addWhippedCreamCheckBox)
            singlePrice += 1;
        if (addChocolateCheckBox)
            singlePrice += 2;
        return quantity * singlePrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    public void increment(View view) {
        quantity ++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity --;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}