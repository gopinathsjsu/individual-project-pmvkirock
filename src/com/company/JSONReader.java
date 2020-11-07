package com.company;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.simple.*;
import java.io.FileReader;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.parser.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

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
                Long bd = curr_card.getLong("CardNumber");
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

    public void writeCSV(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType){

    }

    public void writeJSON(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType){
        JSONArray card_arr = new JSONArray();

        for (int i = 0; i < cardNo.size(); i++) {
            JSONObject curr_card = new JSONObject();
            String temp = cardNo.get(i);
            String type = cardType.get(i);

            curr_card.put("CardNumber", temp);
            curr_card.put("CardType", type);
            card_arr.put(curr_card);
        }
        try {
            FileWriter file = new FileWriter("/Users/haackpad/Desktop/Desktop - MacBook Pro/CMPE 202/individual-project-pmvkirock/src/com/company/Output.json");
            file.write(card_arr.toString(2));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeXML(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType){

    }
}
