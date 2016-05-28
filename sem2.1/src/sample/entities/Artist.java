package sample.entities;

public class Artist {
    private Integer id;
    private Credential credential;
    private String name;
    private String surname;
    private Direction direction;
    private Gallery gallery;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public Integer getGallery_id(){return gallery.getId();}
    public void setGallery_id(Integer gallery_id){this.gallery.setId(gallery_id);}

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public Integer getDirection_id(){return direction.getId();}
    public void setDirection_id(Integer direction_id){this.direction.setId(direction_id);}





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
