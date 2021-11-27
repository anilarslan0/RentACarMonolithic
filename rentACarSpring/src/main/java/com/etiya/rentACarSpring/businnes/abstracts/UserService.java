package com.etiya.rentACarSpring.businnes.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.businnes.dtos.UserSearchListDto;
import com.etiya.rentACarSpring.businnes.request.UserRequest.CreateUserRequest;
import com.etiya.rentACarSpring.businnes.request.UserRequest.DeleteUserRequest;
import com.etiya.rentACarSpring.businnes.request.UserRequest.UpdateUserRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface UserService {
	DataResult<List<UserSearchListDto>> getAll();
	Result Add(CreateUserRequest createUserRequest);
	Result Update(UpdateUserRequest updateUserRequest);
	Result Delete(DeleteUserRequest deleteUserRequest);
	Result existByEmail(String email);
}
