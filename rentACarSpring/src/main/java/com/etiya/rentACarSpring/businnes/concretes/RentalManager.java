package com.etiya.rentACarSpring.businnes.concretes;

import java.sql.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.CarMaintenanceService;
import com.etiya.rentACarSpring.businnes.abstracts.CarService;
import com.etiya.rentACarSpring.businnes.abstracts.CreditCardService;
import com.etiya.rentACarSpring.businnes.abstracts.InvoiceService;
import com.etiya.rentACarSpring.businnes.abstracts.RentalService;
import com.etiya.rentACarSpring.businnes.abstracts.UserService;
import com.etiya.rentACarSpring.businnes.constants.Messages;
import com.etiya.rentACarSpring.businnes.dtos.CarMaintenanceSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.CreditCardSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.businnes.fakeServices.findexService;
import com.etiya.rentACarSpring.businnes.request.CreditCardRequest.CreateCreditCardRequest;
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
import com.etiya.rentACarSpring.entities.CarMaintenance;
import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.complexTypes.RentalDetail;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private CarService carService;
	private UserService userService;
	private CreditCardService creditcardService;
	private InvoiceService invoiceService;
	private CarMaintenanceService carMaintenanceService;

	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, CarService carService,
			UserService userService, CreditCardService creditcardService, InvoiceService invoiceService,
			@Lazy CarMaintenanceService carMaintenanceService) {

		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
		this.userService = userService;
		this.creditcardService = creditcardService;
		this.invoiceService = invoiceService;
		this.carMaintenanceService = carMaintenanceService;

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
		Result result = BusinnessRules.run(checkCarRentalStatus(createRentalRequest.getCarId()),
				checkUserAndCarFindexScore(createRentalRequest.getUserId(), createRentalRequest.getCarId()),
				carMaintenanceService.CheckIfCarIsAtMaintenance(createRentalRequest.getCarId()));

		if (result != null) {
			return result;
		}

		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		this.rentalDao.save(rental);

		return new SuccesResult(Messages.succesRental);
	}

	@Override
	public Result Update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

		Rental result = this.rentalDao.getByRentalId(updateRentalRequest.getRentalId());
		rental.setRentDate(result.getRentDate());
		rental.setTakeCity(result.getTakeCity());
		rental.setUser(result.getUser());
		rental.setCar(result.getCar());

		this.rentalDao.save(rental);
		return new SuccesResult(Messages.updatedRental);
	}

	@Override
	public Result Delete(DeleteRentaRequest deleteRentalRequest) {
		this.rentalDao.deleteById(deleteRentalRequest.getRentalId());
		return new SuccesResult(Messages.deletedRental);
	}

	@Override
	public DataResult<List<Rental>> getByCar(int carId) {
		return null;
	}

	public Result checkCarRentalStatus(int carId) {
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

	private Result checkUserAndCarFindexScore(int userId, int carId) {
		if (this.carService.getbyId(carId).getData().getFindexScore() > this.userService.getById(userId).getData()
				.getFindexScore()) {
			return new ErrorResult("Findex Puanı yeterli değildir.");
		}

		return new SuccesResult();
	}

}
