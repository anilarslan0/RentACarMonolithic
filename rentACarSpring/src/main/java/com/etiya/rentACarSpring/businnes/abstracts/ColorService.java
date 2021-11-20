package com.etiya.rentACarSpring.businnes.abstracts;

import com.etiya.rentACarSpring.businnes.request.CreateColorRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteColorRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateColorRequest;

public interface ColorService {
	void save(CreateColorRequest createColorRequest);
	void update(UpdateColorRequest updateColorRequest);
	void delete(DeleteColorRequest deleteColorRequest);
}
