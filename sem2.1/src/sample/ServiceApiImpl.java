package sample;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sample.entities.Artist;
import sample.entities.Picture;

public class ServiceApiImpl implements ServiceApi {

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<Boolean> signIn(String login, String password) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("login", login);
        params.add("password", password);
        return restTemplate.postForEntity(Links.SIGN_IN, params, Boolean.class);
    }

    public ResponseEntity<Artist> getArtistByLogin(String login) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("login", login);
        return restTemplate.postForEntity(Links.GET_ARTIST_BY_LOGIN, params, Artist.class);
    }

    @Override
    public void addPicture(String name, String artist_id) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("name", name);
        params.add("artist_id", artist_id);
        restTemplate.postForEntity(Links.ADD_PICTURE, params, null);
    }

    @Override
    public ResponseEntity<Picture[]> getPicturesByArtistLogin(String login) {
        return null;
    }

}