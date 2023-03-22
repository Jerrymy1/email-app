package data.repositories;

import data.models.User;
import dto.responseDTO.SignUpResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    private long count;

    ArrayList<User> users = new ArrayList<>();


    @Override
    public User createAccount (User user) {
        if (user.getAccountId() == 0) {
            user.setAccountId(generateAccountId());
            users.add(user);
            count++;
        }
        return user;
    }


    @Override
    public User saveAccount(User user) {
        boolean accountHasNotBeenSaved = user.getAccountId() == 0;
        if (accountHasNotBeenSaved) return saveNewAccount(user);
        return user;
    }

    private User saveNewAccount(User user) {
        user.setAccountId(generateAccountId());
        user.setTimeCreatedStamp(LocalDateTime.now());
        users.add(0, user);
        count++;
        return user;
    }

    private int generateAccountId() {
        return (int) (count + 1);
    }

    @Override
    public void deleteAccountById(int accountId) {
        for (User acc : users)
            if (acc.getAccountId() == accountId) {
                count--;
                users.remove(acc);
                return;
            }
    }


    @Override
    public long count() {
        return count;
    }

    @Override
    public void deleteAllAccount() {
        for (int i = 0; i < users.size(); i++) {
            users.remove(users.get(i));
        }
        count = 0;
    }

    @Override
    public User findEmailAddress(String emailAddress) {
        for (User acc: users) {
            if (acc.getEmailAddress().equalsIgnoreCase(emailAddress)) return acc;
        }
        return null;
    }

    @Override
    public User findAccount(SignUpResponse signUpResponse) {
        for (User acc: users)
            if (acc.getEmailAddress().equalsIgnoreCase(signUpResponse.getEmailAddress()) &&
                    acc.getPassword().equals(signUpResponse.getPassword())) return acc;

        throw new IllegalArgumentException("Invalid Argument");
    }


    public List<User> findAllAccount() {
        return users;
    }

    public User findAccountById(int accountId) {
        for (User acc : users) {
            if (acc.getAccountId() == accountId)
                return acc;
        }
        return null;
    }
}