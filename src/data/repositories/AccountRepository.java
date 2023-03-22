package data.repositories;

import data.models.User;
import dto.responseDTO.SignUpResponse;

public interface AccountRepository {

    User createAccount(User user);

    long count();

    void deleteAllAccount();

    User findEmailAddress(String emailAddress);

    User findAccount(SignUpResponse signUpResponse);


    User saveAccount(User user);

    void deleteAccountById(int accountId);

}
