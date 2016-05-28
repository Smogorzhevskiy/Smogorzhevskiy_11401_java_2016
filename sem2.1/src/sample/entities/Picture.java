package sample.entities;

public class Picture {
    private Integer id;
    private String artist;
    private String gallery;
    private String name;

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


//    public Integer getArtist_id() {
//        return artist.getId();
//    }
//    public void setArtist_id(Integer artist_id) {
//        this.artist.setId(artist_id);
//    }

//    public Integer getGallery_id(){return gallery.getId();}
//    public void setGallery_id(Integer gallery_id){this.gallery.setId(gallery_id);}

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



}
