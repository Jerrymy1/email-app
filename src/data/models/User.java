package data.models;

import java.time.LocalDateTime;

public class User {

    private int accountId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String dateOfBirth;
    private String password;
    private String emailAddress;

    private LocalDateTime timeCreatedStamp = LocalDateTime.now();

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDateTime getTimeCreatedStamp() {
        return timeCreatedStamp;
    }

    public void setTimeCreatedStamp(LocalDateTime timeCreatedStamp) {
        this.timeCreatedStamp = timeCreatedStamp;
    }

    @Override
    public String toString() {
        return "AccountDetail{" +
                " accountId=" + accountId +
                ", fullName='" + firstName + " " + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", emailAddress='" + emailAddress + '\'' +
                ",timeCreated='" + timeCreatedStamp + '\'' +
                '}';
    }

}
