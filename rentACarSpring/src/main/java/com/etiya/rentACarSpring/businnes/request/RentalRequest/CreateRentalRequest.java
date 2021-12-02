package com.etiya.rentACarSpring.businnes.request.RentalRequest;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
	
	@JsonIgnore
	private int rentalId;
	@NotBlank
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date rentDate;

	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;

	@NotNull
	private int userId;

	@NotNull
	private int carId;

	private int returnKilometer;
	@NotBlank
	private int takeCityId;

	private int returnCityId;

	
}
