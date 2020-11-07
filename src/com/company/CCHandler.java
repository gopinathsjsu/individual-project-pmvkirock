package com.company;

import java.util.regex.Pattern;

public class CCHandler implements Handler{
    private Handler successor = null;
    public String handleRequest(String number){
        if(number.length() <= 19){
            return "AnonCC";
        }else {
            return "WrongCC";
        }
    }

    public void setSuccessor(Handler next){
        this.successor = next;
    }

}

