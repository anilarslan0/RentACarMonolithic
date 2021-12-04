package com.etiya.rentACarSpring.businnes.request.RentalRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    @NotNull
    private int rentalId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rentDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    private  String returnKilometer;

    private int carId;

    private int takeCityId;

    private int returnCityId;


}
