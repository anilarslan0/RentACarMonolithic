package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;

public interface CarDao extends JpaRepository<Car, Integer> { // car'ın Id'sinin veri tipi integer
	List<Car> getByDailyPrice(Integer dailyPrice);

	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.CarDetail"
			+ "(c.id,b.brandName,cl.colorName,c.dailyPrice,c.description) "
			+ "From Car c Inner Join  c.brand b Inner Join c.color cl")
	List<CarDetail> getCarWithBrandAndColorDetails();
	
	
}
