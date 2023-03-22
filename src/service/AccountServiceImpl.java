package service;

import data.models.User;
import data.repositories.AccountRepository;
import data.repositories.AccountRepositoryImpl;
import dto.requestDTO.RegisterAccountRequest;
import dto.responseDTO.SignUpResponse;
import utils.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository = new AccountRepositoryImpl();
    User user = new User();


    @Override
    public User register(RegisterAccountRequest registerAccountRequest) {
        emailAddressExist(registerAccountRequest.getEmailAddress());
        phoneNumberExist(registerAccountRequest.getPhoneNumber());
        validatePasswordForEmailRegistration(registerAccountRequest.getPassword());

        return accountRepository.createAccount(Mapper.map(registerAccountRequest));
    }



    private boolean registrationSuccessful(RegisterAccountRequest registerAccountRequest) {

        //validateDateOfBirth(registerAccountRequest);
        return true;
    }

    private void validateDateOfBirth(RegisterAccountRequest registerAccountRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime dateOfBirth = LocalDateTime.parse(registerAccountRequest.getDateOfBirth(),formatter);

        if (dateOfBirth.isAfter(currentDate))
            System.out.println("Date of Birth can not be in the future");
    }



    private boolean thisUserExist(String emailAddress) {
        User foundUser = accountRepository.findEmailAddress(emailAddress);
        if (foundUser != null) return true;
        return false;
    }

    @Override
    public SignUpResponse signUp(SignUpResponse signUpResponse) {
        User foundUser = accountRepository.findAccount(signUpResponse);
        SignUpResponse response = new SignUpResponse();
        Mapper.map(foundUser, response);
        return response;

    }

    private void passwordExist(String password) {
        if (Objects.equals(password, user.getEmailAddress()))
            throw new IllegalArgumentException("Email Address Exist");
    }

    private void validatePasswordForEmailRegistration(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{6,}$";
        if (!password.matches(passwordRegex))
            throw new IllegalArgumentException("""
                    ** Password must contain uppercase
                    ** Password must contain lowercase
                    ** Password must contain letter
                    ** Password must be length 8
                    ** At least 1 special character from the set !@#$%^&*""");
    }

    private void phoneNumberExist(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone number can not be empty");

        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("Length 11 required for phone number");

        if (Objects.equals(phoneNumber, user.getPhoneNumber()))
            throw new IllegalArgumentException(phoneNumber + "already exist");
    }

    private void validateEmailForEmailRegistration(String emailAddress) {
        User foundUser = accountRepository.findEmailAddress(emailAddress);
        if (foundUser != null)
            throw new IllegalArgumentException("Email Address Exist");
    }
    private void emailAddressExist(String emailAddress) {
        if (emailAddress == null || emailAddress.isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be null or empty");
        }
        String emailRegex = "([a-z]+@([a-z]+\\.+[a-z]{2}))";
//        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        if (!emailAddress.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email address format");
        }
        validateEmailForEmailRegistration(emailAddress);
    }
}
