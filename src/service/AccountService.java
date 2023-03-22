package service;

import data.models.User;
import dto.requestDTO.RegisterAccountRequest;
import dto.responseDTO.SignUpResponse;

public interface AccountService {
    User register(RegisterAccountRequest registerAccountRequest);

    SignUpResponse signUp(SignUpResponse signUpResponse);
}
