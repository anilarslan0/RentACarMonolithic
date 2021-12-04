package com.etiya.rentACarSpring.businnes.abstracts;

import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.CreateCorparateRequest;
import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.DeleteCorparateRequest;
import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.UpdateCorparateRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface CorparateCustomerService {

	Result Add(CreateCorparateRequest createCorparateRequest);
	Result update(UpdateCorparateRequest updateCorparateRequest);
	Result delete(DeleteCorparateRequest deleteCorparateRequest);

	

}
