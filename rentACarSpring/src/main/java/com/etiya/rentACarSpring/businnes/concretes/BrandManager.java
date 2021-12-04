package com.etiya.rentACarSpring.businnes.concretes;

import com.etiya.rentACarSpring.businnes.abstracts.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.BrandService;
import com.etiya.rentACarSpring.businnes.constants.Messages;
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

@Service
public class BrandManager implements BrandService {

    private BrandDao brandDao;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    @Autowired
    public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService, MessageService messageService) {
        super();
        this.brandDao = brandDao;
        this.modelMapperService = modelMapperService;
        this.messageService = messageService;
    }

    @Override
    public Result save(CreateBrandRequest createBrandRequest) {
        Result result = BusinnessRules.run(checkBrandNameDublicated(createBrandRequest.getBrandName()));
        if (result != null) {
            return result;
        }

        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandDao.save(brand);

        return new SuccesResult(messageService.getByMessageByMessageId(1).toString());
    }

    @Override
    public Result update(UpdateBrandRequest updateBrandRequest) {
        Result result = BusinnessRules.run(checkBrandNameDublicated(updateBrandRequest.getBrandName()));
        if (result != null) {
            return result;
        }

        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandDao.save(brand);
        return new SuccesResult(Messages.updatedBrand);
    }

    @Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {

        this.brandDao.deleteById(deleteBrandRequest.getBrandId());
        return new SuccesResult(Messages.deletedBrand);
    }

    private Result checkBrandNameDublicated(String brandName) {
        Brand brand = this.brandDao.getByBrandName(brandName);
        if (brand != null) {
            return new ErrorResult("Marka Adı tekrar edemez");
        }

        return new SuccesResult();
    }

}
