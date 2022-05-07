package com.interview.visualnuts.exercise2;

import com.interview.visualnuts.exercise2.model.Country;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class CountryMapper {

    public Set<Country> toModel(JSONArray jsonArray) {
        Set countrySet = new HashSet();
        Iterator iterator = jsonArray.iterator();

        while (iterator.hasNext()) {
            Country country = toModel(((JSONObject) iterator.next()));
            countrySet.add(country);
        }
        return countrySet;
    }

    public Country toModel(JSONObject jsonObject) {
        return new Country((String)jsonObject.get("country"), toStringArray((JSONArray) jsonObject.get("languages")));
    }

    private String[] toStringArray(JSONArray jsonArray) {
        if(jsonArray == null)
            return new String[0];

        String[] strArray = new String[jsonArray.size()];
        for(int i=0; i < strArray.length; i++) {
            strArray[i] = (String) jsonArray.get(i);
        }
        return strArray;
    }



}
