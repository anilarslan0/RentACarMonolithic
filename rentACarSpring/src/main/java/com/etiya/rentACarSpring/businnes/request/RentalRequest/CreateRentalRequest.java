package com.etiya.rentACarSpring.businnes.request.RentalRequest;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
	
	@JsonIgnore
	private int rentalId;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rentDate;

	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;

	@NotNull
	private int individualCustomersId;

	@NotNull
	private int carId;

}
