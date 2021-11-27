package com.etiya.rentACarSpring.businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.CarMaintenanceService;
import com.etiya.rentACarSpring.businnes.dtos.CarMaintenanceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CarMaintenanceRequest.CreateCarMaintenanceRequest;
import com.etiya.rentACarSpring.businnes.request.CarMaintenanceRequest.DeleteCarMaintenanceRequest;
import com.etiya.rentACarSpring.businnes.request.CarMaintenanceRequest.UpdateCarMaintenanceRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.dataAccess.abstracts.CarMaintenanceDao;
@Service
public class CarMaintenanceManager implements CarMaintenanceService{

	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService) {
		super();
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarMaintenanceSearchListDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result Add(CreateCarMaintenanceRequest createCarMaintenanceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result Update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result Delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
