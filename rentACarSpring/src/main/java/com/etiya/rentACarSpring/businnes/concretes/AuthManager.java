package com.etiya.rentACarSpring.businnes.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.AuthService;
import com.etiya.rentACarSpring.businnes.abstracts.CorparateCustomerService;
import com.etiya.rentACarSpring.businnes.abstracts.IndividualCustomerService;
import com.etiya.rentACarSpring.businnes.abstracts.UserService;
import com.etiya.rentACarSpring.businnes.request.AuthRequest.CorparateRegisterRequest;
import com.etiya.rentACarSpring.businnes.request.AuthRequest.IndividualRegisterRequest;
import com.etiya.rentACarSpring.businnes.request.AuthRequest.LoginRequest;
import com.etiya.rentACarSpring.businnes.request.CorparateCustomerRequest.CreateCorparateRequest;
import com.etiya.rentACarSpring.businnes.request.IndividualCustomerRequest.CreateIndividualCustomerRequest;
import com.etiya.rentACarSpring.businnes.request.UserRequest.CreateUserRequest;
import com.etiya.rentACarSpring.core.utilities.businnessRules.BusinnessRules;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.ErrorResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private IndividualCustomerService individualCustomerService;
	private CorparateCustomerService corparateCustomerService;
	private ModelMapperService modelMapperService;

	@Autowired
	public AuthManager(UserService userService, IndividualCustomerService individualCustomerService,
			CorparateCustomerService corparateCustomerService, ModelMapperService modelMapperService) {
		super();
		this.userService = userService;
		this.individualCustomerService = individualCustomerService;
		this.corparateCustomerService = corparateCustomerService;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result individualRegister(IndividualRegisterRequest individualRegisterRequest) {

//		CreateUserRequest createUserRequest = modelMapperService.forRequest().map(individualRegisterRequest,
//				CreateUserRequest.class);
//
//		this.userService.Add(createUserRequest); //sadece usera kayıt atıyor.
		
		CreateIndividualCustomerRequest crateCreateIndividualCustomerRequest = modelMapperService.forRequest()
				.map(individualRegisterRequest, CreateIndividualCustomerRequest.class);
		crateCreateIndividualCustomerRequest.setFindexScore(1000);
		this.individualCustomerService.Save(crateCreateIndividualCustomerRequest);

		return new SuccesResult("Kayıt oluştu");
	}

	@Override
	public Result corparateRegister(CorparateRegisterRequest corparateRegisterRequest) {
//		CreateUserRequest createUserRequest = modelMapperService.forRequest().map(corparateRegisterRequest,
//				CreateUserRequest.class);
//
//		this.userService.Add(createUserRequest);

		CreateCorparateRequest createCorparateRequest = modelMapperService.forRequest().map(corparateRegisterRequest,
				CreateCorparateRequest.class);
		createCorparateRequest.setFindexScore(1000);
		this.corparateCustomerService.Add(createCorparateRequest);
		return new SuccesResult("Kayıt oluştu");
	}

	@Override
	public Result Login(LoginRequest loginRequest) {
		var result = BusinnessRules.run(checkCustomerEmailIsTrue(loginRequest));

		if (result != null) {
			return result;
		}

		return new SuccesResult("Giriş Yapıldı");
	}

	@Override
	public Result checkCustomerEmailIsTrue(LoginRequest loginRequest) {
		if (this.userService.existByEmail(loginRequest.getEmail()).isSuccess()) {
			return new ErrorResult("Mail bulunamadı");
		}
		return new SuccesResult();
	}
	




}
