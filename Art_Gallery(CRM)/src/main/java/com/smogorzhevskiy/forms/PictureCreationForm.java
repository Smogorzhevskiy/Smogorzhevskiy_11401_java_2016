package com.smogorzhevskiy.forms;

import javax.validation.constraints.Size;

/**
 * Created by User on 29.04.16.
 */
public class PictureCreationForm {
    @Size(min = 1, max = 20, message = "incorrect name")
    private String name;
    @Size(min = 1, max = 20, message = "incorrect name")
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
