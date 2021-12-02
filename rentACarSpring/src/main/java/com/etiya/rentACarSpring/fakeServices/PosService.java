package com.etiya.rentACarSpring.fakeServices;

import com.etiya.rentACarSpring.entities.complexTypes.CreditCardDetail;

public class PosService {

    public boolean posService(CreditCardDetail creditCardDetail,double price){

        double creditCardBalance=7500;

        if (price > creditCardBalance || creditCardDetail.getCardNumber().isEmpty())
        {
            return false;
        }
        return true;
    }
}
