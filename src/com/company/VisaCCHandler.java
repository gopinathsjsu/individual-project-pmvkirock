package com.company;


import java.util.regex.Pattern;

public class VisaCCHandler implements Handler{
    private Handler successor = null;
    public String handleRequest(String number){
        if((number.length() == 16 || number.length() == 13) && Pattern.compile("^[4]").matcher(number).find()){
            return "VisaCC";
        }else {
            if(successor != null)
                return successor.handleRequest(number);
            else
                return "";
        }

    }

    public void setSuccessor(Handler next){
        this.successor = next;
    }

}

