package com.smogorzhevskiy.crm.entities;

import javax.persistence.*;

/**
 * Created by User on 18.04.16.
 */
@Entity
@Table(name = "system_admin")
@SequenceGenerator(sequenceName = "system_admin-id_seq", name = "system_admin_gen", allocationSize = 1)
public class Admin {
    private Integer id;
    private Credential role;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_admin_gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "role_id")
    public Credential getRole() {
        return role;
    }

    public void setRole(Credential role) {
        this.role = role;
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
