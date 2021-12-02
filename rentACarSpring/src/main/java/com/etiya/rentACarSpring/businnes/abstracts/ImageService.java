package com.etiya.rentACarSpring.businnes.abstracts;

import java.io.IOException;
import java.util.List;

import com.etiya.rentACarSpring.businnes.dtos.ImageSearchListDto;
import com.etiya.rentACarSpring.businnes.request.CityRequest.ImageRequest.CreateImageRequest;
import com.etiya.rentACarSpring.businnes.request.CityRequest.ImageRequest.DeleteImageRequest;
import com.etiya.rentACarSpring.businnes.request.CityRequest.ImageRequest.UpdateImageRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface ImageService {
	DataResult<List<ImageSearchListDto>> getAll();	
	Result Add(CreateImageRequest createImageRequest) throws IOException;
	Result Update(UpdateImageRequest updateImageRequest) throws IOException;
	Result Delete(DeleteImageRequest deleteImageRequest);
	DataResult<List<ImageSearchListDto>> getCarImageDetailByCarId(int carId); 
}
