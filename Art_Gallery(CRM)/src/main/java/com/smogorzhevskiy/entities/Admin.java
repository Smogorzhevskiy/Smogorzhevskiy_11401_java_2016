package com.smogorzhevskiy.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by User on 18.04.16.
 */
@Entity
@Table(name = "system_admin")
@SequenceGenerator(sequenceName = "system_admin-id_seq", name = "system_admin_gen", allocationSize = 1)
public class Admin {
    private Integer id;
    private Credential credential;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_admin_gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        Admin that = (Admin) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }



}
