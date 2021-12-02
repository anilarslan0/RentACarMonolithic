package com.etiya.rentACarSpring.businnes.abstracts;

import com.etiya.rentACarSpring.businnes.dtos.AdditionalServiceSearchListDto;
import com.etiya.rentACarSpring.businnes.request.AdditionalServiceRequest.DeleteAdditionalServiceRequest;
import com.etiya.rentACarSpring.businnes.request.AdditionalServiceRequest.UpdateAdditionalServiceRequest;
import com.etiya.rentACarSpring.businnes.request.CityRequest.DeleteCityRequest;
import com.etiya.rentACarSpring.businnes.request.AdditionalServiceRequest.CreateAdditionalServiceRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.City;

public interface AdditionalService {
    Result save(CreateAdditionalServiceRequest createAdditionalServiceRequest);
    Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
    Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);
    DataResult<AdditionalServiceSearchListDto> getAll();
}
