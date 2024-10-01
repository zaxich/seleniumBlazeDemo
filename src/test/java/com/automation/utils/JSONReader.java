package com.automation.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {

    public static String existingUser(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/java/com/automation/resources/testData/ExistingUser.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingUser = (JSONObject) obj;
        return (String) existingUser.get(data);
    }

    public static String accountDetails(String type, String data) throws IOException, ParseException {
        String accountFile = "src/test/java/com/automation/resources/testData/AccountDetails.json";
        if (type.equals("existing")){
            accountFile = "src/test/java/com/automation/resources/testData/ExistingAccountDetails.json";
        }
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(accountFile);
        Object obj = jsonParser.parse(fileReader);
        JSONObject accountDetails = (JSONObject) obj;
        return (String)accountDetails.get(data);
    }

    public static String paymentDetails(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/java/com/automation/resources/testData/PaymentDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject paymentDetails = (JSONObject) obj;
        return (String)paymentDetails.get(data);
    }
}