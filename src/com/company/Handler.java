package com.company;

public interface Handler {
    String handleRequest(String number);
    void setSuccessor(Handler next);
}
