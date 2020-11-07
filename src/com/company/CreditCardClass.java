package com.company;

public class CreditCardClass implements CreditCard {
    public void print(){
        System.out.println("Anonymous Credit Card");
    }
    public String getType() { return "Anonymous Card"; }
}
