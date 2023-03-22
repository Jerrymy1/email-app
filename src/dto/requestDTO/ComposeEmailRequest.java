package dto.requestDTO;

import java.time.LocalDateTime;

public class ComposeEmailRequest {

    private String fromEmail;
    private String toEmail;
    private String subject;
    private String emailBody;
    private LocalDateTime dateTime = LocalDateTime.now();


    @Override
    public String toString() {
        return "ComposeEmailRequest{" +
                ", sendersEmail='" + fromEmail + '\'' +
                ", receiversEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + emailBody + '\'' +
                ", timeStamp=" + dateTime +
                '}';
    }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
