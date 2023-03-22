package controller;

import dto.requestDTO.ComposeEmailRequest;
import service.EmailService;
import service.EmailServiceImpl;

public class EmailController {
    EmailService emailService = new EmailServiceImpl();

    public Object composeEmail(ComposeEmailRequest composeEmailRequest) {
        try {
            return emailService.composeEmail(composeEmailRequest);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object searchEmail(String senderName) {
        try {
            return emailService.searchEmail(senderName);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object viewAllInbox() {
        try {
            return emailService.viewInbox();
        } catch (NullPointerException e) {
            return e.getMessage();
        }

    }

    public void deleteEmail(String emailSubject) {
        try {
            emailService.deleteEmailBySubject(emailSubject);
            //System.out.println("Successfully deleted...");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
