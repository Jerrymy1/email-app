package dto.responseDTO;

public class SignUpResponse {
    private String fullName;
    private String emailAddress;
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "SignUpResponse{" +
                "Hello " + fullName + " " +
                ", Your emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
