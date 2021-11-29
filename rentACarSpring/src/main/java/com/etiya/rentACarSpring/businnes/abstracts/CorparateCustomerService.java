package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;


import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.CreateCorparateRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface CorparateCustomerService {

	Result Add(CreateCorparateRequest createCorparateRequest);

	

}
