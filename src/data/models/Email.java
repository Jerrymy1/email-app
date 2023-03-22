package data.models;

import java.time.LocalDateTime;

public class Email {
    private int emailId;
    private String fromEmail;

    private String toEmail;
    private String subject;

    private String emailBody;

    private LocalDateTime timeAndDateStamp = LocalDateTime.now();

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public LocalDateTime getTimeAndDateStamp() {
        return timeAndDateStamp;
    }

    public void setTimeAndDateStamp(LocalDateTime timeAndDateStamp) {
        this.timeAndDateStamp = timeAndDateStamp;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Email{" +
                ", emailSender='" + fromEmail + '\'' +
                ", emailRecipient='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + emailBody + '\'' +
                ", dateAndTimeSent=" + timeAndDateStamp +
                '}';
    }
}