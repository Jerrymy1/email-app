package service;

import data.models.Email;
import data.repositories.EmailRepository;
import data.repositories.EmailRepositoryImpl;
import dto.requestDTO.ComposeEmailRequest;
import utils.Mapper;

import java.util.List;

public class EmailServiceImpl implements EmailService{
    EmailRepository emailRepository = new EmailRepositoryImpl();

    @Override
    public Email composeEmail(ComposeEmailRequest composeEmailRequest) {
        return  emailRepository.create(Mapper.map(composeEmailRequest));
    }

    @Override
    public Email searchEmail(String senderName) {
        return emailRepository.findBySenderEmail(senderName);
    }

    @Override
    public String viewInbox() {
        List<Email> mailBoxInbox = emailRepository.findAllEmails();
        return mailBoxInbox.toString();

    }

    @Override
    public void deleteEmailBySubject(String emailSubject) {
        emailRepository.deleteEmailBySubject(emailSubject);
        successfullyDeletedAlert();
    }

    private void successfullyDeletedAlert(){
        System.out.println("Email Successfully Deleted ...");
    }
}
