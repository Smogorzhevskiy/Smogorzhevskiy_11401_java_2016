package com.smogorzhevskiy.forms;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

public class AdminRegistrationForm {
    @Size(min = 1, max = 20, message = "incorrect login")
    private String login;
    @Size(min = 1, max = 30, message = "incorrect pass")
    private String password;
    @Size(min = 1, max = 30, message = "incorrect pass")
    private String repassword;
    @Size(min = 1, max = 50, message = "incorrect name")
    private String name;
    @Email(regexp = ".+@.+", message = "incorrect email")
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
