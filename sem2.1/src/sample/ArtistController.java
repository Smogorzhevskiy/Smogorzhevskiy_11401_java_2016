package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ArtistController {

    @FXML
    private TextField login;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
    private Main main;
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public void logout() throws IOException {
        main.setArtist(null);
        main.getLoginScreen();
    }

    public void setCredential(){
        this.login.setText(main.getArtist().getCredential().getLogin());
        this.email.setText(main.getArtist().getCredential().getEmail());
        this.name.setText(main.getArtist().getName());
    }






}