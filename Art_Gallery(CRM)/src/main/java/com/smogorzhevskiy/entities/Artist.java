package com.smogorzhevskiy.entities;

import javax.persistence.*;

/**
 * Created by User on 18.04.16.
 */
@Entity
@Table(name = "artist")
@SequenceGenerator(sequenceName = "artist-id_seq", name = "artist-id_seq", allocationSize = 1)
public class Artist {
    private Integer id;
    private Credential credential;
    private String name;
    private String surname;
    private Direction direction;
    private Gallery gallery;

    @Id
    @GeneratedValue(generator = "artist-id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
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

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    @ManyToOne(targetEntity = Gallery.class)
    @JoinColumn(name = "gallery_id", referencedColumnName = "id")
    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToOne
    @JoinColumn(name = "role_id")
    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist that = (Artist) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @ManyToOne
    @JoinColumn(name = "direction")
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
