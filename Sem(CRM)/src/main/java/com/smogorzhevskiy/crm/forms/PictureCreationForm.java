package com.smogorzhevskiy.crm.forms;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

/**
 * Created by User on 29.04.16.
 */
public class PictureCreationForm {
    @Size(min = 1, max = 20, message = "incorrect name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
