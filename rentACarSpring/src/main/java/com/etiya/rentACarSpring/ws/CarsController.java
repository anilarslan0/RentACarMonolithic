package com.etiya.rentACarSpring.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.businnes.abstracts.CarService;
import com.etiya.rentACarSpring.businnes.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CreateCarRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteCarRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateCarRequest;
import com.etiya.rentACarSpring.entities.Car;

@RestController
@RequestMapping("api/cars")
public class CarsController {

	CarService carService;
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("check")
	public String check() {
		return "API up";
	}

	@GetMapping("all")
	public List<CarSearchListDto> getAll() {
		return carService.getAll();
	}
	
	@PostMapping("add")
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.Save(createCarRequest);
	}
	
	@PutMapping("update")
	public void update(@RequestBody UpdateCarRequest updateCarRequest) {
		this.carService.Update(updateCarRequest);
	}
	
	@DeleteMapping("delete")
	public void delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		this.carService.Delete(deleteCarRequest);
	}
}
