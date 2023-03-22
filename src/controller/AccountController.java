package controller;

import dto.requestDTO.RegisterAccountRequest;
import dto.responseDTO.SignUpResponse;
import service.AccountService;
import service.AccountServiceImpl;

public class AccountController {
    private AccountService accountService = new AccountServiceImpl();

    public Object register(RegisterAccountRequest registerAccountRequest) {
        try {
            return accountService.register(registerAccountRequest);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object signUp(SignUpResponse signUpResponse) {
        try {
            return accountService.signUp(signUpResponse);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
