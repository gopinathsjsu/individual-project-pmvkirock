package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestCard {

    @Test
    public void testCardType() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("5410000000000000");
        if(cc1 != null){
            assertEquals("MasterCard",cc1.getType());
        }

    }

    @Test
    public void testCardType2() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("4120000000000");
        if(cc1 != null){
            assertEquals("Visa",cc1.getType());
        }
    }

    @Test
    public void testCardType3() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("1234000000000000000000000");
        if(cc1 != null){
            assertEquals("Wrong Card",cc1.getType());
        }
    }

    @Test
    public void testCardType4() {
        CardFactory cardFactory = new CardFactory();
        CreditCard cc1 = cardFactory.getCardClass("6010000000000000");
        if(cc1 != null){
            assertEquals("Anonymous Card",cc1.getType());
        }
    }
}
