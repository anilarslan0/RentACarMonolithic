package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.complexTypes.RentalDetail;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	Rental getByReturnDate(Date returnDate);

//	@Query("Select new com.etiya.rentACarSpring.business.dtos.RentalSearchListDto"
//            + "(c.id, r.returnDate) " 
//            +     "From Car c Inner Join c.rentals r where c.id=:carId and r.returnDate is null")
//    RentalSearchListDto getByIdWhereReturnDateIsNull(int carId);

	List<Rental> getByCar_CarId(int carId);
	
//	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.RentalDetail"
//			+ "(c.id,b.brandId,cl.colorId,b.brandName,cl.colorName,c.dailyPrice,c.description,i.imageUrl) "
//			+ "From Rental r Inner Join  c.brand b Inner Join c.color cl inner join c.images i where c.carId=:carId")
//	List<RentalDetail> getUserIfIndexScoreIsNull(int userId);
	
}
