package com.etiya.rentACarSpring.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private int rentalId;
	
	@Column (name ="rent_date")
	private Date rentDate; 

	@Column (name="return_date")
	private Date returnDate;
	
	@ManyToOne 
	@JoinColumn (name= "id")
	private Car car;
	
	@ManyToOne 
	@JoinColumn (name= "individualCustomers_id")
	private IndividualCustomer individualCustomer;
}
