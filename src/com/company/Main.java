package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        CardFactory cardFactory = new CardFactory();

        FileReader fileReader = new ReaderAdapter("xml");
        ArrayList<String> cardNo = new ArrayList<String>();
        cardNo = fileReader.read("xml","/Users/haackpad/Desktop/Desktop - MacBook Pro/CMPE 202/individual-project-pmvkirock/src/com/company/Sample.xml");

        ArrayList<String> cardType = new ArrayList<String>();
        for(int i = 0; i < cardNo.size(); i++) {
                CreditCard cc1 = cardFactory.getCardClass(cardNo.get(i));
                if(cc1 != null){
                    cardType.add(cc1.getType());
                }else {
                    cardType.add("Wrong Card");
                }
        }
        FileReader fileReader2 = new ReaderAdapter("xml");
        fileReader2.write("xml", cardNo, cardType);
    }
}
