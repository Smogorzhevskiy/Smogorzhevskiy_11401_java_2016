package com.smogorzhevskiy.crm.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by User on 18.04.16.
 */
@Entity
@Table(name = "contract")
@SequenceGenerator(sequenceName = "contract-id_seq", name = "contract_gen", allocationSize = 1)
public class Contract {
    private Integer id;
    private Artist artist;
    private Gallery gallery;
    private Date dateOfConclusion;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_of_conclusion")
    public Date getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(Date dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    @OneToOne
    @JoinColumn(name = "artist_id")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    @OneToOne
    @JoinColumn(name = "gallery_id")
    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract that = (Contract) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dateOfConclusion != null ? !dateOfConclusion.equals(that.dateOfConclusion) : that.dateOfConclusion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateOfConclusion != null ? dateOfConclusion.hashCode() : 0);
        return result;
    }
}
