package com.smogorzhevskiy.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by User on 18.04.16.
 */
@Entity
@Table(name = "picture")
@SequenceGenerator(sequenceName = "picture_id_seq", name = "picture_gen", allocationSize = 1)
public class Picture {
    private Integer id;
    private Artist artist;
    private Gallery gallery;
    private String name;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getArtist_id() {
        return artist.getId();
    }
    public void setArtist_id(Integer artist_id) {
        this.artist.setId(artist_id);
    }

    public Integer getGallery_id(){return gallery.getId();}
    public void setGallery_id(Integer gallery_id){this.gallery.setId(gallery_id);}

    @ManyToOne
    @JoinColumn(name = "gallery_id", insertable = false, updatable = false)
    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id", insertable = false, updatable = false)

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture that = (Picture) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}
