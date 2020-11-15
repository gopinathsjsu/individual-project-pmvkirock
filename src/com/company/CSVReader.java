package com.company;
import com.opencsv.CSVWriter;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader implements AdapterFileReader {
    public ArrayList<String> readCSV(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        ArrayList<String> cardNo = new ArrayList<String>();
        String line = "";
        int i = 0;
        while((line = br.readLine()) != null){
            String[] card = line.split(",");
            if(i != 0)
                cardNo.add(card[0]);
            i++;
        }
        return cardNo;
    }
    public ArrayList<String> readJSON(String fileName){

        return null;
    }
    public ArrayList<String> readXML(String fileName){

        return null;
    }

    public void writeCSV(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){
        File file = new File(fileName + ".csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "CardNo", "Type", "Error" };
            writer.writeNext(header);
            for(int i = 0; i < cardNo.size(); i++) {
                String error = "";
                if(cardType.get(i) == "Wrong Card"){
                    error = "Please enter a valid card No";
                }else{
                    error = "No error";
                }
                String[] data1 = {cardNo.get(i), cardType.get(i), error};
                writer.writeNext(data1);
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){

    }

    public void writeXML(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){

    }
}
