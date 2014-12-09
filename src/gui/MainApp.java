package gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import gui.controller.*;
import java.io.File;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import soccer.Competitie;

/**
 *
 * @author codesalad
 */
public class MainApp extends Application {
    
    private Stage primarystage;
    private BorderPane Layout;
    
    @Override
    public void start(Stage stage) throws Exception {
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
    
}
