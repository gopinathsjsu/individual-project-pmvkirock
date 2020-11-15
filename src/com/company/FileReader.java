package com.company;

import java.io.IOException;
import java.util.ArrayList;

public interface FileReader {
    public ArrayList<String> read(String readerType, String fileName) throws IOException;
    public void write(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName);
}
