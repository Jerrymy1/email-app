package data.repositories;

import data.models.Email;

import java.util.List;

public interface EmailRepository {
    Email create(Email email);

    Email saveEmail(Email email);

    void deleteByEmailById(int emailId);

    void deleteEmailBySubject(String emailSubject);

    long count();

    void deleteAllEmail();

    List<Email> findAllEmails();

    Email findBySenderEmail(String sendersEmail);

    Email findByEmailById(int emailId);

}
