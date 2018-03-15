package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateBusinessAcitivity extends Activity {

    private EditText nameField ,numberField, addressField, provinceField, primaryField;
    private MyApplicationData appState;

    /**
     *  create new business activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField= (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
        primaryField = (EditText) findViewById(R.id.primary);
    }

    /**
     * once submit button pressed, create new business in firebase db from user data
     * @param v = context view
     */
    public void submitInfoButton(View v) {
        String businessID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        String primary_business = primaryField.getText().toString();
        Business person = new Business(businessID, name,number,province,address, primary_business);

        appState.firebaseReference.child(businessID).setValue(person);

        finish();

    }
}
