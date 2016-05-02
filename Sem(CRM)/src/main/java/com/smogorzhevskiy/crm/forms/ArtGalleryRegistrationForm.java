package com.smogorzhevskiy.crm.forms;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

/**
 * Created by User on 29.04.16.
 */
public class ArtGalleryRegistrationForm {
    @Size(min = 1, max = 50, message = "incorrect name")
    private String name;

    @Size(min = 1, max = 20, message = "incorrect city")
    private String city;

    @Size(min = 1, max = 12, message = "login should consist of no less than 3, and no more than 12 characters")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

