package sample;

//public class Main extends Application {
//
//    private Stage someStage;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        someStage = primaryStage;
//        someStage.setTitle("Store Of Comics:'Progressus'");
//        change("login");
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    public void change(String sceneName) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/scenes/" + sceneName + ".fxml"));
//        Parent root = null;
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        AbstractController controller = loader.getController();
//        controller.setApp(this);
//
//        someStage.setScene(new Scene(root));
//        someStage.show();
//    }
//}


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controllers.LoginController;
import sample.entities.Artist;
import sample.entities.Picture;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private Artist artist;
    private ObservableList<Picture> pictureData = FXCollections.observableArrayList();

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Art gallery CRM");
        getLoginScreen();
    }

    public void getLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/sample/login.fxml"));
        Pane page = loader.load();
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.show();
        LoginController controller = loader.getController();
        controller.setMain(this);
    }

    public void getArtistScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/sample/artist.fxml"));
        Pane page = loader.load();
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.show();
        ArtistController controller = loader.getController();
        controller.setMain(this);
        controller.setCredential();
    }


    public static void main(String[] args) {
        launch(args);
    }
}