package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand;

public interface CarDao extends JpaRepository<Car, Integer> { // car'ın Id'sinin veri tipi integer
	List<Car> getByDailyPrice(Integer dailyPrice);

	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.CarDetail"
			+ "(c.id,b.brandName,cl.colorName,c.dailyPrice,c.description) "
			+ "From Car c Inner Join  c.brand b Inner Join c.color cl")
	List<CarDetail> getCarWithBrandAndColorDetails();

	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand"
			+ "(c.id,b.brandId,cl.colorId,b.brandName,cl.colorName,c.dailyPrice,c.description,i.imageUrl) "
			+ "From Car c Inner Join  c.brand b Inner Join c.color cl inner join c.images i where cl.colorId=:colorId")
	List<CarDetailForColorAndBrand> getCarDetailByColor(int colorId);

	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand"
			+ "(c.id,b.brandId,cl.colorId,b.brandName,cl.colorName,c.dailyPrice,c.description,i.imageUrl) "
			+ "From Car c Inner Join  c.brand b Inner Join c.color cl inner join c.images i where b.brandId=:brandId")
	List<CarDetailForColorAndBrand> getCarDetailByBrand(int brandId);

	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand"
			+ "(c.id,b.brandId,cl.colorId,b.brandName,cl.colorName,c.dailyPrice,c.description,i.imageUrl) "
			+ "From Car c Inner Join  c.brand b Inner Join c.color cl inner join c.images i where c.carId=:carId")
	List<CarDetailForColorAndBrand> getCarDetailByCarId(int carId);

	@Query("Select new com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto" + "(c.id,c.dailyPrice,c.description) "
			+ "From Car c Left Join  c.carMaintenances cm WHERE (cm.maintananceDate is not null AND cm.returnDate is not null) or (cm.maintananceDate is null AND cm.returnDate is null)")
	List<CarSearchListDto> getAllWithoutMaintenanceOfCar();

//	@Query(value = "SELECT c.id,c.daily_price,c.description FROM cars c\r\n"
//			+ "				LEFT JOIN car_maintenances cm ON c.id=cm.id \r\n"
//			+ "			WHERE (cm.maintenance_date is not null AND cm.return_date is not null) or \r\n"
//			+ "				(cm.maintenance_date is null AND cm.return_date is null)", nativeQuery = true)
//	List<CarSearchListDto> getAllWithoutMaintenanceOfCar();
}
