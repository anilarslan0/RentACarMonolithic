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

import com.etiya.rentACarSpring.businnes.abstracts.BrandService;
import com.etiya.rentACarSpring.businnes.request.CreateBrandRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteBrandRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateBrandRequest;
import com.etiya.rentACarSpring.entities.Brand;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@GetMapping("all")
	public List<Brand> getAll() {
		List<Brand> brands = new ArrayList<Brand>();
		brands.add(new Brand(1, "Opel"));

		return brands;
	}

	@PostMapping("add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.save(createBrandRequest);
	}

	@PutMapping("update")
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping("delete")
	public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		this.brandService.delete(deleteBrandRequest);
	}
}
