package com.etiya.rentACarSpring.businnes.abstracts;

import com.etiya.rentACarSpring.businnes.request.CreateBrandRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteBrandRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateBrandRequest;

public interface BrandService {
	void save(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
}
