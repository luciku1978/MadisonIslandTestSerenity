package projectMadisonIslandTS.factory;

import org.apache.commons.lang3.RandomStringUtils;

public class UserFactory {
    private String firstname = RandomStringUtils.randomAlphabetic(5).toLowerCase();
    private String middlename = RandomStringUtils.randomAlphabetic(3).toLowerCase();
    private String lastname = RandomStringUtils.randomAlphabetic(5).toLowerCase();
    private String email = RandomStringUtils.randomAlphabetic(6).toLowerCase() + "@gmail.com";
    private String password = RandomStringUtils.randomNumeric(6).toLowerCase();

    public UserFactory() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserFactory{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
