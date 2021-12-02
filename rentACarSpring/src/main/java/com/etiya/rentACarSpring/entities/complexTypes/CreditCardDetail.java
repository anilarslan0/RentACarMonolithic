package com.etiya.rentACarSpring.entities.complexTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDetail {

    private String cardName;

    private String cardNumber;

    private String cvv;

}
