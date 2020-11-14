package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        CardFactory cardFactory = new CardFactory();
        String fileName = "/Users/haackpad/Desktop/Desktop - MacBook Pro/CMPE 202/individual-project-pmvkirock/src/com/company/Sample.json";
        String extension = FilenameUtils.getExtension(fileName);
        FileReader fileReader = new ReaderAdapter(extension);
        ArrayList<String> cardNo = new ArrayList<String>();
        cardNo = fileReader.read(extension, fileName);

        ArrayList<String> cardType = new ArrayList<String>();
        for(int i = 0; i < cardNo.size(); i++) {
                System.out.println(cardNo.get(i));
                CreditCard cc1 = cardFactory.getCardClass(cardNo.get(i));
                if(cc1 != null){
                    cardType.add(cc1.getType());
                }else {
                    cardType.add("Wrong Card");
                }
        }
        fileReader.write(extension, cardNo, cardType);
    }
}
