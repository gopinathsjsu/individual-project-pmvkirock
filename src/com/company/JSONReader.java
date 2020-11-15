package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONReader implements AdapterFileReader {
    public ArrayList<String> readCSV(String fileName){
        return null;
    }
    public ArrayList<String> readJSON(String fileName){
        try {
            String text = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONArray arr = new JSONArray(text);
            ArrayList<String> cardNo = new ArrayList<String>();
            for (int i = 0; i < arr.length(); i++) {
                JSONObject curr_card = arr.getJSONObject(i);
                BigInteger bd = curr_card.getBigInteger("CardNumber");
                //get issuer of the card
                String x = bd.toString();
                cardNo.add(x);
            }
            return cardNo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public ArrayList<String> readXML(String fileName){
        return null;
    }

    public void writeCSV(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){

    }

    public void writeJSON(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){
        JSONArray card_arr = new JSONArray();

        for (int i = 0; i < cardNo.size(); i++) {
            String error = "";
            if(cardType.get(i) == "Wrong Card"){
                error = "Please enter a valid card No";
            }else{
                error = "No error";
            }

            JSONObject curr_card = new JSONObject();
            String temp = cardNo.get(i);
            String type = cardType.get(i);

            curr_card.put("CardNumber", temp);
            curr_card.put("CardType", type);
            curr_card.put("Error", error);
            card_arr.put(curr_card);
        }
        try {
            FileWriter file = new FileWriter(fileName + ".json");
            file.write(card_arr.toString(2));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeXML(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){

    }
}
