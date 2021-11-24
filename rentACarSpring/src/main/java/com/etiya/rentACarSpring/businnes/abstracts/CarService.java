package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CarRequest.CreateCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.DeleteCarRequest;
import com.etiya.rentACarSpring.businnes.request.CarRequest.UpdateCarRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;

public interface CarService {
	DataResult<List<CarSearchListDto>> getAll();
	DataResult<List<CarSearchListDto>> getByDailyPrice(Integer dailyPrice);
	DataResult<List<CarDetail>> getCarWithBrandAndColorDetails();
	Result Save(CreateCarRequest createCarRequest);
	Result Update(UpdateCarRequest updateCarRequest);
	Result Delete(DeleteCarRequest deleteCarRequest);
}
