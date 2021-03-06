package gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import gui.controller.*;
import java.io.File;
import java.io.FileInputStream;


import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayerBuilder;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import soccer.Competitie;
import soccer.Team;

/**
 *
 * @author codesalad
 */
public class MainApp extends Application {
    
    private ObservableList<Team> teamData = FXCollections.observableArrayList();
    
    private Stage primarystage;
    private BorderPane Layout;
    public BackgroundMusic bgmusicRunnable = new BackgroundMusic("bgmusic");
    public Thread bgmusic = new Thread(bgmusicRunnable);
    
    
    public static EventHandler clickSoundHandler = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                AudioClip clickSound = new AudioClip(new File("src/gui/clicksound.mp3").toURI().toString());
                clickSound.setVolume(1.5);
                clickSound.play();
            }
        };
    
    @Override
    public void start(Stage stage) throws Exception {
        bgmusic.setDaemon(true);
        bgmusic.start();
        
        this.primarystage = stage;
    
        initRootLayout();
        
        showStartScreen();
        Parent root = FXMLLoader.load(getClass().getResource("view/root.fxml"));
        root.setId("AnchorPane");

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("view/main.css").toExternalForm());

    }
    
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/root.fxml"));
            Layout = (BorderPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(Layout);
            primarystage.setFullScreen(true);
            primarystage.setResizable(true);
            primarystage.setScene(scene);
            primarystage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showStartScreen() {
        try {
           // Load person overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/main.fxml"));
           AnchorPane main = (AnchorPane) loader.load();

           // Set person overview into the center of root layout.
           Layout.setCenter(main);

           // Give the controller access to the main app.
           mainController controller = loader.getController();
           controller.setMainApp(this);
           
       } catch (IOException e) {
           e.printStackTrace();
       }
    
    }
  
    public void showLoadScreen(){
        try {
           // Load person overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/loadscreen.fxml"));
           AnchorPane personOverview = (AnchorPane) loader.load();

           // Set person overview into the center of root layout.
           Layout.setCenter(personOverview);

           // Give the controller access to the main app.
           loadscreenController controller = loader.getController();
           controller.setMainApp(this);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    
    public void showNewGameScreen() {
        try {
           // Load person overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/newgamescreen.fxml"));
           AnchorPane personOverview = (AnchorPane) loader.load();

           // Set person overview into the center of root layout.
           Layout.setCenter(personOverview);

           // Give the controller access to the main app.
           newgamescreenController controller = loader.getController();
           controller.setMainApp(this);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    
    public void showNewTeamScreen() {
        try {
           // Load person overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/newteamscreen.fxml"));
           AnchorPane personOverview = (AnchorPane) loader.load();

           // Set person overview into the center of root layout.
           Layout.setCenter(personOverview);

           // Give the controller access to the main app.
           newteamscreenController controller = loader.getController();
           controller.setMainApp(this);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    
    public void showMainHubScreen(){
        try {
           // Load person overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/mainhub.fxml"));
           AnchorPane personOverview = (AnchorPane) loader.load();
           // Set person overview into the center of root layout.
           Layout.setCenter(personOverview);

           // Give the controller access to the main app.
           mainhubController controller = loader.getController();
           controller.setMainApp(this);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
    public void showKoopScreen(){
        
    }
    public void showVerkoopScreen(){
        
    }
    public void showOpstellingScreen(){
        
    }
    
}
