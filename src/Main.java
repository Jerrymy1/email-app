import controller.AccountController;
import controller.EmailController;
import dto.requestDTO.ComposeEmailRequest;
import dto.requestDTO.RegisterAccountRequest;
import dto.responseDTO.SignUpResponse;

import javax.swing.*;

public class Main {
    static AccountController accountController = new AccountController();
    static EmailController emailController = new EmailController();



    public static void main(String[] args) {
        launchEmailApplication();
        //displayAfterLogIn();


    }


    private static void displayAfterLogIn() {
        String displayMessageAfterLogIn = input("""
                ------------------------------------
                |  1 ----- Compose Mail
                ------------------------------------
                |  2 ----- Inbox
                ------------------------------------
                |  3 ----- Search Mail
                ------------------------------------
                |  4 ----- Delete Mail
                ------------------------------------
                |  5 ----- Home Page 
                ------------------------------------
                |  6 ----- Exit App
                ------------------------------------
                """);

        try {
            validateEmptyStringCanNotBreakCode(displayMessageAfterLogIn);
        } catch (Exception e) {
            display(e.getMessage());
            launchEmailApplication();
        }

        switch (displayMessageAfterLogIn.charAt(0)) {
            case '1' -> composeEmail();
            case '2' -> mailInbox();
            case '3' -> searchEmail();
            case '4' -> deleteMail();
            case '5' -> launchEmailApplication();
            case '6' -> exitEmail();
            default -> displayAfterLogIn();
        }
    }

    public static void validateEmptyStringCanNotBreakCode(String empty) {
        String emptyString = "";
        if (empty.equals(emptyString)) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }

    private static void deleteMail() {
        String mailSubject = input("Enter mail subject to delete mail:::: ");
        emailController.deleteEmail(mailSubject);
        displayAfterLogIn();
    }

    private static void searchEmail() {
        String sendersNameToSearch = input("Enter sender's name to search:::: ");
        display(String.valueOf(emailController.searchEmail(sendersNameToSearch)));
        displayAfterLogIn();
    }

    private static void mailInbox() {
        display(emailController.viewAllInbox().toString());
        displayAfterLogIn();
    }

    private static void composeEmail() {
        ComposeEmailRequest composeEmailRequest = new ComposeEmailRequest();
        composeEmailRequest.setFromEmail(input("Sender's Mail Address:::: "));
        composeEmailRequest.setToEmail(input("Recipient Mail Address:::: "));
        composeEmailRequest.setSubject(input("Enter Mail Subject:::: "));
        composeEmailRequest.setEmailBody(input("Enter Body:::: "));
        var output = emailController.composeEmail(composeEmailRequest);
        display(output.toString());
        displayAfterLogIn();
    }

    private static void launchEmailApplication() {
        String emailFirstPage = input("""
                -------------------------------------------
                |          E    M    A    I    L          
                -------------------------------------------
                |  Press 1    >>>>>>> Register               
                -------------------------------------------
                |  Press 2    >>>>>>> Login                  
                -------------------------------------------
                |  Press 3    >>>>>>> Exit                                       
                -------------------------------------------""");
        try {
            validateEmptyStringCanNotBreakCode(emailFirstPage);

        } catch (Exception e) {
            display(e.getMessage());
            launchEmailApplication();
        }


        switch (emailFirstPage.charAt(0)) {
            case '1':
                registerNewUser();
                break;
            case '2':
                loginForExistingUser();
                break;
            case '3':
                exitEmail();
            default:
                launchEmailApplication();}}

    private static void exitEmail() {
        display("Bye.....");
        System.exit(0);
    }

    private static void loginForExistingUser() {
        SignUpResponse signUpRequest = new SignUpResponse();
        signUpRequest.setEmailAddress(input("Enter your mail address:::: "));
        signUpRequest.setPassword(input("Enter password:::: "));
        var result = accountController.signUp(signUpRequest);
        display(result.toString());
        displayAfterLogIn();
    }

    private static void registerNewUser() {
        RegisterAccountRequest registerAccountRequest = new RegisterAccountRequest();
        registerAccountRequest.setFirstName(input("Enter First Name::::"));
        registerAccountRequest.setLastName(input("Enter Last Name:::: "));
        registerAccountRequest.setEmailAddress(input("Choose a valid email address::::"));
        registerAccountRequest.setPassword(input("Choose a valid password:::: "));
        registerAccountRequest.getTimeCreatedStamp(); //(input("Enter your country:::: "));
        registerAccountRequest.setPhoneNumber(input("Enter a valid phone number:::: "));
        registerAccountRequest.setDateOfBirth(input("Enter Date Of Birth:::: "));
        //registerAccountRequest.setDateOfBirth(input("Enter date of birth:::: "));
        var result = accountController.register(registerAccountRequest);
        display(result.toString());
        display("Now login....");
        loginForExistingUser();

    }



    private static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}