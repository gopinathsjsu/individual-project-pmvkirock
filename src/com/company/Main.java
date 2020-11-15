package com.company;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        CardFactory cardFactory = new CardFactory();
        if(args.length != 2)
            System.out.println("Input file and output parameters not given");
        else {
            String inFile = args[0];
            String outFile = args[1];

            String extension = FilenameUtils.getExtension(inFile);
            FileReader fileReader = new ReaderAdapter(extension);
            ArrayList<String> cardNo = new ArrayList<String>();
            cardNo = fileReader.read(extension, inFile);

            ArrayList<String> cardType = new ArrayList<String>();
            for (int i = 0; i < cardNo.size(); i++) {
                System.out.println(cardNo.get(i));
                CreditCard cc1 = cardFactory.getCardClass(cardNo.get(i));
                if (cc1 != null) {
                    cardType.add(cc1.getType());
                } else {
                    cardType.add("Wrong Card");
                }
            }
            fileReader.write(extension, cardNo, cardType, outFile);
        }
    }
}
