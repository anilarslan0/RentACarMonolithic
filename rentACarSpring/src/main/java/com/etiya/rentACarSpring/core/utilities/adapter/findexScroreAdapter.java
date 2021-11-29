package com.etiya.rentACarSpring.core.utilities.adapter;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.fakeServices.findexService;

@Service
public class findexScroreAdapter implements findexScoreService {

	findexService findexService=new findexService();
	
	@Override
	public Integer sendUserFindexScore() {

		return	findexService.getCustomerScore();
	}
	
	@Override
	public Integer sendCarFindexScore() {

		return	findexService.getCarScore();
	}


	

}
