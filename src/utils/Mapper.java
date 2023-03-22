package utils;

import data.models.User;
import data.models.Email;
import dto.requestDTO.ComposeEmailRequest;
import dto.requestDTO.RegisterAccountRequest;
import dto.responseDTO.SignUpResponse;

public class Mapper {


    public static User map(RegisterAccountRequest registerAccountRequest) {
        User user = new User();
        user.setFirstName(registerAccountRequest.getFirstName());
        user.setLastName(registerAccountRequest.getLastName());
    user.setPhoneNumber(registerAccountRequest.getPhoneNumber());
        user.setDateOfBirth(registerAccountRequest.getDateOfBirth());
        user.setPassword(registerAccountRequest.getPassword());
        user.setEmailAddress(registerAccountRequest.getEmailAddress());
        user.setTimeCreatedStamp(registerAccountRequest.getTimeCreatedStamp());
        return user;
    }

    public static void map(User foundUser, SignUpResponse signUpResponse) {
        signUpResponse.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
        signUpResponse.setEmailAddress(foundUser.getEmailAddress());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyy, hh:mm a");
        //signUpResponse.setDatePosted(formatter.format(foundUser.getTimeCreated()));
    }

    public static Email map(SignUpResponse signUpRequest) {
        Email email = new Email();
        //email.setPassword(signUpRequest.getPassword());
        //email.setEmailAddress(signUpRequest.getEmailAddress());
        return email;
    }

    public static Email map(ComposeEmailRequest composeEmailRequest) {
        Email email = new Email();
        email.setFromEmail(composeEmailRequest.getFromEmail());
        email.setToEmail(composeEmailRequest.getToEmail());
        email.setSubject(composeEmailRequest.getSubject());
        email.setEmailBody(composeEmailRequest.getEmailBody());
        //SimpleDateFormat formatter = new SimpleDateFormat("EEE dd-MM-yyyy hh:mm:ss a");
        //email.setDateAndTimeSent(formatter.format(composeMailRequest.getDateTime()));
        return email;
    }

}
