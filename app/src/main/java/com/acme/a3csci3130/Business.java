package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Firebase data object class
 */

public class Business implements Serializable {

    public  String bid;
    public  String name;
    public String number;
    public String province;
    public String address;
    public String primary;


    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     *  Create new business given params
     * @param bid = business ID
     * @param name = name of business
     * @param number = number of business (9 digits)
     * @param province = province of business
     * @param address = address of business
     * @param primary = primary business type
     */
    public Business(String bid, String name, String number, String province, String address, String primary){
        this.bid = bid;
        this.name = name;
        this.number = number;
        this.province = province;
        this.address = address;
        this.primary = primary;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("bid", bid);
        result.put("name", name);
        result.put("number", number);
        result.put("province", province);
        result.put("address", address);
        result.put("primary", primary);

        return result;
    }
}
