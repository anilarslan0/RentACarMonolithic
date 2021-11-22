package com.etiya.rentACarSpring.businnes.abstracts;

import com.etiya.rentACarSpring.businnes.request.CreateColorRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteColorRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateColorRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface ColorService {
	Result save(CreateColorRequest createColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
}
