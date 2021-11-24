package com.etiya.rentACarSpring.businnes.concretes;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.CarService;
import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CarRequest.CreateCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.DeleteCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.UpdateCarRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.CarDao;
import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
		List<Car> result = this.carDao.findAll();
		List<CarSearchListDto> response = result.stream()
				.map(car -> modelMapperService.forDto().map(car, CarSearchListDto.class)).collect(Collectors.toList());

		return new SuccesDataResult<List<CarSearchListDto>>(response);
	}

	@Override
	public Result Save(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccesResult("Ekleme İslemi Basarili");
	}

	@Override
	public Result Update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccesResult("Guncelleme İslemi Basarili");
	}

	@Override
	public Result Delete(DeleteCarRequest deleteCarRequest) {

		this.carDao.deleteById(deleteCarRequest.getCarId());
		return new SuccesResult("Silme İslemi Basarili");

	}

	@Override
	public DataResult<List<CarSearchListDto>> getByDailyPrice(Integer dailyPrice) {

		List<CarSearchListDto> response = this.carDao.getByDailyPrice(dailyPrice).stream()
				.map(car -> modelMapperService.forDto().map(car, CarSearchListDto.class)).collect(Collectors.toList());

		return new SuccesDataResult<List<CarSearchListDto>>(response);
	}

	@Override
	public DataResult<List<CarDetail>> getCarWithBrandAndColorDetails() {

		List<CarDetail> response = this.carDao.getCarWithBrandAndColorDetails();

		return new SuccesDataResult<List<CarDetail>>(response);
	}

}