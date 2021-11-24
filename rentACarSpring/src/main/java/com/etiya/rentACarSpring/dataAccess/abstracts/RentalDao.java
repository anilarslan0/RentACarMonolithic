package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACarSpring.entities.Rental;

public interface RentalDao  extends JpaRepository<Rental, Integer>  {
	Rental getByReturnDate(Date returnDate);
}
