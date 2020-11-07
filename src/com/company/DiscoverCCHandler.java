package com.company;


import java.util.regex.Pattern;

public class DiscoverCCHandler implements Handler{
    private Handler successor = null;
    public String handleRequest(String number){
        if(number.length() == 16 && Pattern.compile("^[6][0][1][1]").matcher(number).find()){
            return "DiscoverCC";
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
