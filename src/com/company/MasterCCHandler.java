package com.company;

import java.util.regex.Pattern;

public class MasterCCHandler implements Handler{
    private Handler successor = null;
    public String handleRequest(String number){
        if(number.length() == 16 && Pattern.compile("^[5][1-5]").matcher(number).find()){
            return "MasterCC";
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
