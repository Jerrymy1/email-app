package data.repositories;

import data.models.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailRepositoryImplTest {

    private EmailRepository emailRepository;
    private Email email;
    private Email email1;
    private Email email2;

    @BeforeEach
    public void setUp() {
        emailRepository = new EmailRepositoryImpl();
        email = new Email();
        email.setFromEmail("me@emailking.com");
        email.setToEmail("tayo@emailking.com");
        email.setSubject("the email title");
        email.setEmailBody("the email body");
        email1 = new Email();
        email2 = new Email();

    }

    @Test
    public void testCreateOneEmail_CountIsOne() {
        emailRepository.create(email);
        assertEquals(1, emailRepository.count());
    }

    @Test
    public void testCreateTwoEmail_CountIsTwo() {
        emailRepository.create(email);
        emailRepository.create(email1);
        assertEquals(2, emailRepository.count());
    }

    @Test
    public void testCreateThreeEmail_CountIsThree() {
        emailRepository.create(email);
        emailRepository.create(email1);
        emailRepository.create(email2);
        assertEquals(3, emailRepository.count());
    }

    @Test
    public void testCreateTwoEmailDeleteAllEmail_CountIsZero() {
        emailRepository.create(email);
        emailRepository.create(email1);
        emailRepository.deleteAllEmail();
        assertEquals(0, emailRepository.count());
    }

    @Test public void testCreateTwoEmailsDeleteOneBySubject_CountIsOne() {
        emailRepository.create(email);
        emailRepository.create(email1);
        email1.setSubject("this is the body boss");
        emailRepository.deleteEmailBySubject(email1.getSubject());
        assertEquals(1, emailRepository.count());
    }

    @Test
    public void testFindAllEmail() {
        emailRepository.create(email);
       // List<Email> expectedList = Collections.singletonList(email);
        //
        List<Email> actualList = emailRepository.findAllEmails();
        assertEquals(expectedList, actualList);
    }



}