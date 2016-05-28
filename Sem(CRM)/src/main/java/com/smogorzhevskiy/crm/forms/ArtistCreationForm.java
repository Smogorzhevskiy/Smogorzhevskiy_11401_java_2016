package com.smogorzhevskiy.crm.forms;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

/**
 * Created by User on 27.04.16.
 */
public class ArtistCreationForm {
    @Size(min = 1, max = 20, message = "incorrect name")
    private String name;

    @Size(min = 1, max = 50, message = "incorrect surname")
    private String surname;

    @Size(min = 3, max = 12, message = "login should consist of no less than 3, and no more than 12 characters")
    private String login;

    @Size(min = 5, max = 16, message = "password should consist of no less than 5, and no more than 16 characters")
    private String password;

    @Email(regexp = ".+@.+", message = "incorrect email")
    private String email;

    public String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}