package data.repositories;

import data.models.Email;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmailRepositoryImpl implements EmailRepository{

    private long count;

    List<Email> mailBox = new ArrayList<>();


    @Override
    public Email create(Email email) {
        if (email.getEmailId() == 0) {
            email.setEmailId(generateEmailId());
            mailBox.add(email);
            count++;
        }
            return email;
        }

        @Override
        public Email saveEmail (Email email){
            boolean emailHasNotBeenSaved = email.getEmailId() == 0;
            if (emailHasNotBeenSaved) return saveNewEmail(email);
            return email;
        }

    private Email saveNewEmail (Email email){
        email.setEmailId(generateEmailId());
        email.setTimeAndDateStamp(LocalDateTime.now());
        mailBox.add(0, email);
        count++;
        return email;
    }

        private int generateEmailId () {
            return (int)(count + 1);
        }

      @Override
        public void deleteByEmailById ( int emailId){
          for (Email mail : mailBox) if (mail.getEmailId() == emailId){
              count--;
              mailBox.remove(mail);
              return;
          }
        }

        @Override
        public void deleteEmailBySubject (String emailSubject){
            for (Email mail: mailBox) {
                if (mail.getSubject().equalsIgnoreCase(emailSubject))
                    mailBox.remove(mail);
                break;
            }
            count--;
        }

        @Override
        public long count () {
            return count;
        }

        @Override
        public void deleteAllEmail () {
            for (int i = 0; i < mailBox.size(); i++) {
                mailBox.remove(mailBox.get(i));
            }
            count = 0;
        }

        @Override
        public List<Email> findAllEmails () {
            return mailBox;
        }

        @Override
        public Email findBySenderEmail (String senderEmail) {
            if (!senderEmail.endsWith("@emailking.com"))
                senderEmail += "@emailking.com";
            for (Email mail : mailBox) {
                if (mail.getFromEmail().equalsIgnoreCase(senderEmail)) {
                    return mail;
                }
            }

            throw new NoSuchElementException("Email not found..........");

        }

    @Override
    public Email findByEmailById(int emailId) {
        for (Email mail: mailBox) {
            if (mail.getEmailId() == emailId) return mail;
        }
        return null;

    }

    private void appendToVariable(String variableName) {
        if (!variableName.endsWith("@emailking.com"))
            variableName += "@emailking.com";
    }

}
