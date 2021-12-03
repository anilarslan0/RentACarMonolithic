package com.etiya.rentACarSpring.businnes.request.RentalRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    private int rentalId;

    private Date rentDate;

    private Date returnDate;

    private  String returnKilometer;

    private int carId;

    private int takeCityId;

    private int returnCityId;


}
