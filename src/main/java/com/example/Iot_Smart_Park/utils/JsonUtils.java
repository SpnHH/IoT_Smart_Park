package com.example.Iot_Smart_Park.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

    public static JSONObject stringToJson(String jsonString) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(jsonString);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
