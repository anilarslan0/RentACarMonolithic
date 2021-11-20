package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CreateCarRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteCarRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateCarRequest;

public interface CarService {
	List<CarSearchListDto> getAll();

	void Save(CreateCarRequest createCarRequest);
	void Update(UpdateCarRequest updateCarRequest);
	void Delete(DeleteCarRequest deleteCarRequest);
}
