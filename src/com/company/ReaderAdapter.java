package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class ReaderAdapter implements FileReader {
    AdapterFileReader adapterFileReader;

    public ReaderAdapter(String fileType){
        if(fileType.equalsIgnoreCase("csv")){
            adapterFileReader = new CSVReader();
        }else if(fileType.equalsIgnoreCase("json")){
            adapterFileReader = new JSONReader();
        }else if(fileType.equalsIgnoreCase("xml")){
            adapterFileReader = new XMLReader();
        }
    }

    @Override
    public ArrayList<String> read(String readerType, String fileName) throws IOException {
        if(readerType.equalsIgnoreCase("csv")){
            return adapterFileReader.readCSV(fileName);
        }else if(readerType.equalsIgnoreCase("json")){
            return adapterFileReader.readJSON(fileName);
        }else{
            return adapterFileReader.readXML(fileName);
        }
    }

    public void write(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName){
        if(readerType.equalsIgnoreCase("csv")){
            adapterFileReader.writeCSV(readerType, cardNo, cardType, fileName);
        }else if(readerType.equalsIgnoreCase("json")){
            adapterFileReader.writeJSON(readerType, cardNo, cardType, fileName);
        }else{
            adapterFileReader.writeXML(readerType, cardNo, cardType, fileName);
        }
    }
}
