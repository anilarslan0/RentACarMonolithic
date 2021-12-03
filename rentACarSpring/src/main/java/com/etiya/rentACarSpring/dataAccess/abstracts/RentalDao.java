package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiya.rentACarSpring.businnes.dtos.CarMaintenanceSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.entities.Invoice;
import com.etiya.rentACarSpring.entities.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	Rental getByReturnDate(Date returnDate);

	List<Rental> getByCar_CarId(int carId);

	Rental getByRentalId(int rentalId);

	@Query(value = "Select ads.additional_service_price from additional_services as ads \n" +
			"inner join rental_additional_services as rads on ads.additional_service_id=rads.additional_service_id \n" +
			"inner join rentals as r on rads.rental_id=r.rental_id \n" +
			"where r.rental_id=:rentalId ", nativeQuery = true)
	List<Integer> getAdditionalRentalPrice(int rentalId);

	@Query(value = "select c.daily_price from cars as c inner join rentals as r on c.id=r.id where r.rental_id=:rentalId ", nativeQuery = true)
	Integer getDailyPriceOfCar(int rentalId);

	//@Query(value = "select c.id from cars as c inner join rentals as r on c.id=r.id where r.rental_id=:rentalId ", nativeQuery = true)
	//Rental getCarIdByRentalId(int rentalId);


}
