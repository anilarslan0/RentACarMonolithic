package com.etiya.rentACarSpring.businnes.concretes;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.RentalService;
import com.etiya.rentACarSpring.businnes.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.businnes.fakeServices.findexService;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.CreateRentalRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.DeleteRentaRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.UpdateRentalRequest;
import com.etiya.rentACarSpring.core.utilities.businnessRules.BusinnessRules;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.ErrorResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.RentalDao;
import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.Rental;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;



	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService) {
		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<RentalSearchListDto>> getAll() {
		List<Rental> result = this.rentalDao.findAll();
		List<RentalSearchListDto> response = result.stream()
				.map(car -> modelMapperService.forDto().map(car, RentalSearchListDto.class))
				.collect(Collectors.toList());

		return new SuccesDataResult<List<RentalSearchListDto>>(response);
	}

	@Override
	public Result Add(CreateRentalRequest createRentalRequest) {
		Result result = BusinnessRules.run(checkCarRentalStatus(createRentalRequest.getCarId()));
		if (result != null) {
			return result;
		}

		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccesResult("Ekleme İslemi Basarili");
	}

	@Override
	public Result Update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccesResult("Güncelleme İslemi Basarili");
	}

	@Override
	public Result Delete(DeleteRentaRequest deleteRentalRequest) {
		this.rentalDao.deleteById(deleteRentalRequest.getRentalId());
		return new SuccesResult("Silme İslemi Basarili");
	}
	
//	private Result checkReturnDateIsEmpty(Date returnDate) {
//	Rental rental = this.rentalDao.getByReturnDate(returnDate);
//	if (returnDate == null) {
//		return new ErrorResult("This car has been rented");
//	}
//	return new SuccesResult();
//}
	
	private Result checkCarRentalStatus(int carId) {
		List<Rental> result = this.rentalDao.getByCar_CarId(carId);
		if (result != null) {
			for (Rental rentals : this.rentalDao.getByCar_CarId(carId)) {
				if (rentals.getReturnDate() == null) {
					return new ErrorResult("Araç bir başkası tarafından kiralanmıştır.");
				}
			}
		}
		return new SuccesResult();
	}
	
//	private Result checkUserIndexScore(int userId) {
//		List<Rental> result = this.rentalDao.getUserIfIndexScoreIsNull(userId);
//		if (result != null) {
//			return new ErrorResult("Arac teslim edilmemistir");
//		}
//		return new SuccesResult();
//	}
//	
//	private Result checkIfCarReturned(int carId) {
//		
//		RentalSearchListDto result = this.rentalDao.getByIdWhereReturnDateIsNull(carId);
//		if (result != null) {
//			return new ErrorResult("Arac teslim edilmemistir");
//		}
//		return new SuccesResult();
//	}
	
//

	


}
