package com.etiya.rentACarSpring.businnes.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.BrandService;
import com.etiya.rentACarSpring.businnes.request.BrandRequest.CreateBrandRequest;
import com.etiya.rentACarSpring.businnes.request.BrandRequest.DeleteBrandRequest;
import com.etiya.rentACarSpring.businnes.request.BrandRequest.UpdateBrandRequest;
import com.etiya.rentACarSpring.core.utilities.businnessRules.BusinnessRules;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.ErrorResult;
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
		Result result = BusinnessRules.run(checkBrandNameDublicated(createBrandRequest.getBrandName()));
		if (result != null) {
			return result;
		}
		
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
	
	private Result checkBrandNameDublicated(String brandName) {
		Brand brand=this.brandDao.getByBrandName(brandName);
		if (brand!=null) {
			return new ErrorResult("Bu marka daha önce tanımlanmıştır");
		}
		
		return new SuccesResult();
	}

}
