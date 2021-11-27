package com.etiya.rentACarSpring.entities.complexTypes;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.CorparateCustomer;
import com.etiya.rentACarSpring.entities.IndividualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetail {

	private int rentalId;
	
	private int carId;
	
	private int findexScore;
		
	private int individualCustomer;
	
	private int corparateCustomer;
	
	private int userId;
}
