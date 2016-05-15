package com.smogorzhevskiy.forms;

import javax.validation.constraints.Size;

/**
 * Created by User on 15.05.16.
 */
public class ContractCreationForm {
    @Size(min= 1, max= 30)
    private String artist;
    @Size(min= 1, max= 30)
    private String gallery;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }
}
