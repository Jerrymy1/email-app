package service;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dto.requestDTO.RegisterAccountRequest;
import dto.responseDTO.SignUpResponse;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private AccountService accountService;
    private RegisterAccountRequest registerAccountRequest;
    private SignUpResponse signUpRequest;

    User user = new User();

    @BeforeEach
    public void setUp() {
        registerAccountRequest = new RegisterAccountRequest();
        signUpRequest = new SignUpResponse();
        accountService = new AccountServiceImpl();
        registerAccountRequest.setFirstName("john");
        registerAccountRequest.setLastName("doe");
        registerAccountRequest.setPassword("Pass123!");
        registerAccountRequest.setEmailAddress("johndoe@gmail.com");
        registerAccountRequest.setPhoneNumber("07069498128");
    }

    @Test
    public void testThatNewUserCanRegisterAnAccountAndOpenEmailAccount() {
        registerAccountRequest = new RegisterAccountRequest();
        accountService = new AccountServiceImpl();
        registerAccountRequest.setFirstName("john");
        registerAccountRequest.setLastName("doe");
        registerAccountRequest.setPassword("Pass123!");
        registerAccountRequest.setEmailAddress("johndoe@gmail.com");
        registerAccountRequest.setPhoneNumber("07069498128");

        User savedUser = accountService.register(registerAccountRequest);
        assertTrue(savedUser.getAccountId() != 0);
    }

    @Test public void testThatAnExistingUserTriesToRegisterNewWithTheSameEmailAddressThrowsException() {
        registerAccountRequest.setEmailAddress("johndoe@gmail.com");
        accountService.register(registerAccountRequest);
        registerAccountRequest.setEmailAddress("johndoe@gmail.com");
        assertThrows(IllegalArgumentException.class, ()-> accountService.register(registerAccountRequest));
    }

    @Test public void testExistingAccountTriedToRegisterAgainWithAnExistingPhoneNumberThrowsException() {
        registerAccountRequest.setPhoneNumber("08122770000");
        registerAccountRequest.setPhoneNumber("08122770000");
        assertThrows(IllegalArgumentException.class, ()-> accountService.register(registerAccountRequest));
    }

    @Test public void testThatOneTriesToRegisterWithInvalidEmailAddress_ThrowsException() {
        registerAccountRequest.setEmailAddress("emailWIthNo@Notation.com");
        assertThrows(IllegalArgumentException.class, ()-> accountService.register(registerAccountRequest));
    }

    @Test public void testAccountTryingToRegisterWithIncompletePhoneNumberThrowsException() {
        registerAccountRequest.setPhoneNumber("0704567890");
        assertThrows(IllegalArgumentException.class, ()-> accountService.register(registerAccountRequest));
    }

//    @Test public void testThatOldUserAccountCanAlmSignUpToTheirAccount() {
//        accountService.register(registerAccountRequest);
//        signUpRequest.setEmailAddress("yinka@gmail.com");
//        signUpRequest.setPassword("newPassword");
//        User savedUser = accountService.signUp(signUpRequest);
//        assertNotNull(savedUser);
//        assertEquals("yinka@gmail.com", savedUser.getEmailAddress());
//        assertNotEquals("password", savedUser.getPassword());
//    }


//    @Test public void testOldUserWithIncorrectEmailAddressThrowsException() {
//        user.setEmailAddress("correctEmail@gmail.com");
//        registerAccountRequest.setEmailAddress("IncorrectEmail@gmail.com");
//        accountService.register(registerAccountRequest);
//        signUpRequest.setEmailAddress("correctEmail@gmail.com");
//        assertThrows(IllegalArgumentException.class, ()-> accountService.signUp(signUpRequest));
//    }


//    @Test public void testExistingUserTriesLoginWithIncorrectPasswordThrowsException() {
//        registerAccountRequest.setPassword("MyPassword1!");
//        accountService.register(registerAccountRequest);
//        //signUpRequest.setFirstName("incorrectPassword");
//        assertThrows(IllegalArgumentException.class, ()-> accountService.signUp(signUpRequest));
//    }

}