package com.etiya.rentACarSpring.businnes.fakeServices;

import java.util.Random;

public class findexService {
	
	public Integer getCustomerScore() {
		return 1000;
	}
	
	public Integer getCarScore() {
		Random rand=new Random();
		return rand.nextInt(1900);
	}


	
}
