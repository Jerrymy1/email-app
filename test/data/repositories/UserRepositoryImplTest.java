package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private User user;

    private User user1;

    private User user2;

    AccountRepository accountRepository = new AccountRepositoryImpl();

    @BeforeEach
    public void initialize() {
        user = new User();
        accountRepository = new AccountRepositoryImpl();
    }


    @Test
    public void createOneUser_CountOfUserIsOne() {
        accountRepository.createAccount(user);
        assertEquals(1, accountRepository.count());
    }

    @Test
    public void createTwoUser_CountOfUserIsTwo() {
        user1 = new User();
        accountRepository.createAccount(user);
        accountRepository.createAccount(user1);
        assertEquals(2, accountRepository.count());
    }

   @Test
    public void createThreeUser_DeleteTwoAccountById_CountOfUserIsOne() {
        user1 = new User();
        user2 = new User();
        accountRepository.createAccount(user);
        accountRepository.createAccount(user1);
        accountRepository.createAccount(user2);
        accountRepository.deleteAccountById(1);
        accountRepository.deleteAccountById(2);
        assertEquals(1, accountRepository.count());
    }

    @Test
    public void createThreeUser_DeleteAllUser_CountIsZero() {
        user1 = new User();
        user2 = new User();
        accountRepository.createAccount(user);
        accountRepository.createAccount(user1);
        accountRepository.createAccount(user2);
        accountRepository.deleteAllAccount();
        assertEquals(0, accountRepository.count());
    }

}