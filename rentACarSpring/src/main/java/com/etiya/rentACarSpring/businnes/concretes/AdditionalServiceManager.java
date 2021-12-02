package com.etiya.rentACarSpring.businnes.concretes;

import com.etiya.rentACarSpring.businnes.abstracts.AdditionalService;
import com.etiya.rentACarSpring.businnes.dtos.AdditionalServiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.AdditionalServiceRequest.CreateAdditionalServiceRequest;
import com.etiya.rentACarSpring.businnes.request.AdditionalServiceRequest.DeleteAdditionalServiceRequest;
import com.etiya.rentACarSpring.businnes.request.AdditionalServiceRequest.UpdateAdditionalServiceRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.dataAccess.abstracts.AdditionalServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionalServiceManager implements AdditionalService {

    private AdditionalServiceDao additionalServiceDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapperService modelMapperService) {
        this.additionalServiceDao = additionalServiceDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result save(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
        return null;
    }

    @Override
    public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
        return null;
    }

    @Override
    public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
        return null;
    }

    @Override
    public DataResult<AdditionalServiceSearchListDto> getAll() {
        return null;
    }
}
