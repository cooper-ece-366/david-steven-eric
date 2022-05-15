package edu.cooper.ece366.project.coopercars.server.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


//Steven
public class SignUpRequest {
    @NotBlank
    private String firstName;


    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
}
