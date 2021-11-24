package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;


import com.etiya.rentACarSpring.businnes.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.CreateRentalRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.DeleteRentaRequest;
import com.etiya.rentACarSpring.businnes.request.RentalRequest.UpdateRentalRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;


public interface RentalService {
	DataResult<List<RentalSearchListDto>> getAll();
	Result Add(CreateRentalRequest createRentalRequest);
	Result Update(UpdateRentalRequest updateRentalRequest);
	Result Delete(DeleteRentaRequest deleteRentalRequest);
}
