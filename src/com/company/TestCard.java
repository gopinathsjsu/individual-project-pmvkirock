package com.company;

import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCard {

    @Test
    public void testCardMasterCard() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("5410000000000000");
        if(cc1 != null){
            assertEquals("MasterCard",cc1.getType());
        }
    }

    @Test
    public void testCardVisa() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("4120000000000");
        if(cc1 != null){
            assertEquals("Visa",cc1.getType());
        }
    }

    @Test
    public void testCardWrong() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("1234000000000000000000000");
        if(cc1 != null){
            assertEquals("Wrong Card",cc1.getType());
        }
    }

    @Test
    public void testCardTypeAnonymous() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("6010000000000000");
        if(cc1 != null){
            assertEquals("Anonymous Card",cc1.getType());
        }
    }

    @Test
    public void testCardTypeAmEx() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("341000000000000");
        if(cc1 != null){
            assertEquals("American Express",cc1.getType());
        }
    }

    @Test
    public void AmexHandler() {
        AmExCCHandler amex = new AmExCCHandler();
        String output = amex.handleRequest("341000000000000");
        assertEquals("AmExCC", output);
    }

    @Test
    public void VisaHandler() {
        VisaCCHandler visa = new VisaCCHandler();
        String output = visa.handleRequest("4120000000000");
        assertEquals("VisaCC", output);
    }

    @Test
    public void DiscoverHandler() {
        DiscoverCCHandler discover = new DiscoverCCHandler();
        String output = discover.handleRequest("6011000000000000");
        assertEquals("DiscoverCC", output);
    }
    @Test
    public void MasterHandler() {
        MasterCCHandler master = new MasterCCHandler();
        String output = master.handleRequest("5410000000000000");
        assertEquals("MasterCC", output);
    }
    @Test
    public void CSVReader() throws IOException {
        String inFile = "src/com/company/Sample.csv";
        String extension = FilenameUtils.getExtension(inFile);
        FileReader fileReader = new ReaderAdapter(extension);
        ArrayList<String> cardNo = new ArrayList<String>();
        cardNo = fileReader.read(extension, inFile);
        assertEquals("5410000000000000", cardNo.get(0));
    }

    @Test
    public void JSONReader() throws IOException {
        String inFile = "src/com/company/Sample.json";
        String extension = FilenameUtils.getExtension(inFile);
        FileReader fileReader = new ReaderAdapter(extension);
        ArrayList<String> cardNo = new ArrayList<String>();
        cardNo = fileReader.read(extension, inFile);
        assertEquals("5410000000000000", cardNo.get(0));
    }

    @Test
    public void XMLReader() throws IOException {
        String inFile = "src/com/company/Sample.xml";
        String extension = FilenameUtils.getExtension(inFile);
        FileReader fileReader = new ReaderAdapter(extension);
        ArrayList<String> cardNo = new ArrayList<String>();
        cardNo = fileReader.read(extension, inFile);
        assertEquals("5410000000000000", cardNo.get(0));
    }
}
