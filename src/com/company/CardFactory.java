package com.company;

import java.util.regex.Pattern;

public class CardFactory {
    public CreditCard getCardClass(String number){
        Handler master = new MasterCCHandler();
        Handler visa = new VisaCCHandler();
        Handler amex = new AmExCCHandler();
        Handler disc = new DiscoverCCHandler();
        Handler cc = new CCHandler();

        master.setSuccessor(visa);
        visa.setSuccessor(amex);
        amex.setSuccessor(disc);
        disc.setSuccessor(cc);

        String cardType = master.handleRequest(number);
        if(cardType == "WrongCC"){
            return null;
        }else if(cardType == "MasterCC"){
            return new MasterCardCC();
        }else if(cardType == "VisaCC"){
            return new VisaCC();
        }else if(cardType == "AmExCC"){
            return new AmExCC();
        }else if(cardType == "DiscoverCC"){
            return new DiscoverCC();
        }else if(cardType == "AnonCC"){
            return new CreditCardClass();
        }else{
            return null;
        }
    }
}
