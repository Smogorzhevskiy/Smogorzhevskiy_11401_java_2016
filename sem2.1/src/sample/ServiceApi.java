package sample;

import org.springframework.http.ResponseEntity;
import sample.entities.Artist;
import sample.entities.Picture;

public interface ServiceApi {
    ResponseEntity<Boolean> signIn(String login, String password);

    ResponseEntity<Artist> getArtistByLogin(String login);

    void addPicture(String name, String artist_id);

    ResponseEntity<Picture[]> getPicturesByArtistLogin(String login);
}