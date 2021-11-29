package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;


import com.etiya.rentACarSpring.businnes.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.CreateRentalRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.DeleteRentaRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.UpdateRentalRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetailForColorAndBrand;
import com.etiya.rentACarSpring.entities.complexTypes.RentalDetail;


public interface RentalService {
	DataResult<List<RentalSearchListDto>> getAll();
	Result Add(CreateRentalRequest createRentalRequest);
	Result Update(UpdateRentalRequest updateRentalRequest);
	Result Delete(DeleteRentaRequest deleteRentalRequest);
	DataResult<List<Rental>> getByCar(int carId);
	//DataResult<List<RentalDetail>> getCarById(Integer carId);
	Result checkCarRentalStatus(int carId);
}
