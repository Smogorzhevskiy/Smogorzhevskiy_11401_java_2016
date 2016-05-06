package com.smogorzhevskiy.forms;

import com.smogorzhevskiy.entities.Contract;

/**
 * Created by User on 29.04.16.
 */
public class ChangeContractForm {
    private String artist;
    private String date;
    private String gallery;

    public ChangeContractForm(Contract contract) {
        this.artist = contract.getArtist().getName() + " " + contract.getArtist().getSurname();
        this.date = contract.getDateOfConclusion().toString();
        this.gallery = contract.getGallery().getName();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }
}
