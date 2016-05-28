package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.http.ResponseEntity;
import sample.Main;
import sample.ServiceApi;
import sample.ServiceApiImpl;
import sample.entities.Artist;

import java.io.IOException;

public class LoginController {

    private ServiceApi apiService = new ServiceApiImpl();

    private Main main;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private Button submit;
    @FXML
    private TextField error;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = this.main;
    }

    @FXML
    public void logInto() throws IOException {
        ResponseEntity<Boolean> responseEntity = apiService.signIn(login.getText(), password.getText());
        if (responseEntity.getBody()) {
            ResponseEntity<Artist> responseEntityPublisher = apiService.getArtistByLogin(login.getText());
            main.setArtist(responseEntityPublisher.getBody());
            main.getArtistScreen();
            System.out.println(login.getText() + " " + password.getText());
            System.out.println(login.getCharacters() + " " + password.getCharacters());
        } else {
            error.setVisible(true);
        }
    }
}

