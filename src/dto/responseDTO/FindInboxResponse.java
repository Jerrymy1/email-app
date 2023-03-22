package dto.responseDTO;

import java.time.LocalDateTime;

public class FindInboxResponse {

    private String senderName;
    private String subject;
    private String body;
    LocalDateTime dateSent = LocalDateTime.now();

    @Override
    public String toString() {
        return "senderName = " + senderName + '\'' +
                ", subject = " + subject + '\'' +
                ", body = " + body + '\'' +
                ", dateSent = " + dateSent;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDateTime dateSent) {
        this.dateSent = dateSent;
    }
}
