package com.company;

import java.util.regex.Pattern;

public class AmExCCHandler implements Handler{
    private Handler successor = null;
    public String handleRequest(String number){
        if((number.length() == 15) && Pattern.compile("^[3][4|7]").matcher(number).find()){
            return "AmExCC";
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

