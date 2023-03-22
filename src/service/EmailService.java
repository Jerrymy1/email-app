package service;

import data.models.Email;
import dto.requestDTO.ComposeEmailRequest;

public interface EmailService {
    Email composeEmail(ComposeEmailRequest composeEmailRequest);
    Email searchEmail(String senderName);
    String viewInbox();
    void deleteEmailBySubject(String emailSubject);
}
