package com.etiya.rentACarSpring.businnes.concretes;

import com.etiya.rentACarSpring.businnes.abstracts.CarDamageService;
import com.etiya.rentACarSpring.businnes.constants.Messages;
import com.etiya.rentACarSpring.businnes.dtos.CarDamageSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.dtos.CreditCardSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CarDamageRequest.CreateCarDamageRequest;
import com.etiya.rentACarSpring.businnes.request.CarDamageRequest.DeleteCarDamageRequest;
import com.etiya.rentACarSpring.businnes.request.CarDamageRequest.UpdateCarDamageRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.CarDamageDao;

import com.etiya.rentACarSpring.entities.CarDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarDamageManager implements CarDamageService {

    private CarDamageDao carDamageDao;
    private ModelMapperService modelMapperService;
    @Autowired
    public CarDamageManager(CarDamageDao carDamageDao, ModelMapperService modelMapperService) {
        this.carDamageDao = carDamageDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CarDamageSearchListDto>> getAll() {
        List<CarDamage> result = this.carDamageDao.findAll();
        List<CarDamageSearchListDto> response = result.stream()
                .map(car -> modelMapperService.forDto().map(car, CarDamageSearchListDto.class))
                .collect(Collectors.toList());
        return new SuccesDataResult<List<CarDamageSearchListDto>>(response);
    }

    @Override
    public Result add(CreateCarDamageRequest createCarDamageRequest) {
        CarDamage carDamage = modelMapperService.forRequest().map(createCarDamageRequest, CarDamage.class);
        this.carDamageDao.save(carDamage);
        return new SuccesResult("Eklendi");
    }

    @Override
    public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
        CarDamage carDamage = modelMapperService.forRequest().map(updateCarDamageRequest, CarDamage.class);
        this.carDamageDao.save(carDamage);
        return new SuccesResult("Güncellendi");
    }

    @Override
    public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) {
        this.carDamageDao.deleteById(deleteCarDamageRequest.getCarDamageId());
        return new SuccesResult("Silindi");
    }
}
