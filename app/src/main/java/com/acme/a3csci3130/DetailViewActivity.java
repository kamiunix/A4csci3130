package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Detailed view activity that generates info of any given business
 */
public class DetailViewActivity extends Activity {

    private EditText nameField ,numberField, addressField,provinceField, primaryField;

    Business receivedBusinessInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField= (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
        primaryField = (EditText) findViewById(R.id.primary);

        if(receivedBusinessInfo != null){
            nameField.setText(receivedBusinessInfo.name);
            numberField.setText(receivedBusinessInfo.number);
            provinceField.setText(receivedBusinessInfo.province);
            addressField.setText(receivedBusinessInfo.address);
            primaryField.setText(receivedBusinessInfo.primary);
        }
    }

    /**
     * after update button, update a given business
     * @param v = context view
     */
    public void updateContact(View v){
        String businessID = receivedBusinessInfo.bid;
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String province = provinceField.getText().toString();
        String address = addressField.getText().toString();
        String primary = primaryField.getText().toString();
        Business business = new Business(businessID, name,number,province,address,primary);
        appState.firebaseReference.child(receivedBusinessInfo.bid).setValue(business);

        finish();
    }

    /**
     * after erase button, erase given business
     * @param v = context view
     */
    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedBusinessInfo.bid).removeValue();

        finish();
    }
}
