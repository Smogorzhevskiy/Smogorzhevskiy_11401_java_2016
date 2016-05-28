package sample;

public interface Links {
    String DOMAIN = "http://localhost:8080/api";
    String SIGN_IN = DOMAIN + "/login";
    String GET_ARTIST_BY_LOGIN = DOMAIN + "/artist/get";
    String ADD_PICTURE = DOMAIN + "/picture/add";
    String GET_PICTURES = DOMAIN + "/get_pictures";
}