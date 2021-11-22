package com.etiya.rentACarSpring.businnes.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.BrandService;
import com.etiya.rentACarSpring.businnes.request.CreateBrandRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteBrandRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateBrandRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.BrandDao;
import com.etiya.rentACarSpring.entities.Brand;
import com.etiya.rentACarSpring.entities.Car;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result save(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccesResult("Ekleme İslemi Basarili");
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccesResult("Guncelleme İslemi Basarili");
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {

		this.brandDao.deleteById(deleteBrandRequest.getBrandId());
		return new SuccesResult("Silme İslemi Basarili");
	}

}
