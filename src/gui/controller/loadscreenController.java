/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.BackgroundMusic;
import gui.MainApp;
import static gui.controller.mainController.oldVolume;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import soccer.Competitie;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.REMAINING;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class loadscreenController implements Initializable {
    
    @FXML
    private AnchorPane loadAnchorPane;
    @FXML
    private GridPane gameGrid = new GridPane();
    @FXML
    private ScrollPane loadPane;
    @FXML
    private Button backButton;
    
    //MUSIC
    @FXML
    private Slider volumeSlider;
    @FXML
    private Button playPauseButton;
    @FXML
    private ImageView muteButton;
    @FXML
    private ImageView playPauseImage;
    @FXML
    private Button m_refresh;
    @FXML
    private Button m_folder;
    @FXML
    private Button m_back;
    @FXML
    private Button m_next;
    
    private MainApp mainApp;
    
    public static String savegame;
    private int i = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        volumeSlider.setValue(BackgroundMusic.volume);

        m_refresh.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        m_refresh.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        m_folder.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        m_folder.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        m_back.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        m_back.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        playPauseButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        playPauseButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        m_next.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        m_next.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        muteButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        muteButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        volumeSlider.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        volumeSlider.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        
        loadPane.setStyle("-fx-background:none;");
        loadAnchorPane.setStyle("-fx-background:none;");
        gameGrid.setStyle("-fx-background:none;");
        soccer.ReadFolder.readNames("/src/saves");
        while(i<soccer.ReadFolder.getAantalSaveGames()) {
            //System.out.println("size is:" +soccer.ReadFolder.Read().size());
            addGames(soccer.ReadFolder.readNames("/src/saves").get(i));
        }
        
        
        loadAnchorPane.getChildren().add(gameGrid);
        AnchorPane.setLeftAnchor(gameGrid, 0.0);
        AnchorPane.setRightAnchor(gameGrid, 0.0);
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setVgap(12);
        gameGrid.setAlignment(Pos.CENTER); 
    }
    
    private void addGames(String name) {
        i++;
        VBox v = new VBox();
        Label l = new Label();
        Label l2 = new Label();
        final Button temp = new Button(name);
        final int numButton= i;
        v.setFillWidth(true);
        v.setMinWidth(450.0);
        v.setMaxWidth(Double.MAX_VALUE);
        v.getStyleClass().add("loadfiles");
        System.out.println(name);
        try{
            Competitie c_temp = soccer.bouwXML.leesXML(new File("src/saves/"+name+".xml"));
            Team t_temp = c_temp.getTeams().get(c_temp.getUserindex());
            System.out.println(c_temp.getTeams().get(c_temp.getUserindex()).getName());
            l.setText("  "+t_temp.getName());
            l2.setText("  Gewonnen: "+t_temp.getWins()+"   Verloren: "+t_temp.getLosses()+"   Budget: "+t_temp.getBudget());
        }catch(Exception e){System.out.println("IK BREEK ZO MOEILIJK TERING HARD");}
        temp.setId("" + i);
        temp.setMinWidth(450.0);
        temp.getStyleClass().add("loadButton");
        temp.setMaxHeight(Double.MAX_VALUE);
        temp.setAlignment(Pos.CENTER_LEFT);
        temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
            Competitie c = soccer.bouwXML.leesXML(new File("src/saves/"+name+".xml"));
            }catch(Exception qq){System.out.println(qq);}
            savegame = name;
            mainApp.showMainHubScreen();
                System.out.println("LAAD SPEL: " + name);
            }
        });
        temp.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        temp.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        backButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        backButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        v.getChildren().addAll(temp,l,l2);
        gameGrid.add(v, 1, i);
    }
    
    
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
//--------------------media player----------------------
    
    @FXML
    private void handlePrevious() {
        mainApp.bgmusicRunnable.playPrevious();
        playPauseImage.setImage(new Image("/gui/view/media_pause.png"));
    }
    
    @FXML
    private void handlePlayPause() {
        mainApp.bgmusicRunnable.PlayPause();
        
        if(mainApp.bgmusicRunnable.isPlaying() == 1) {
            playPauseImage.setImage(new Image("/gui/view/media_play.png"));
        }else {
            playPauseImage.setImage(new Image("/gui/view/media_pause.png"));
        }
    }

    @FXML
    private void handleNext() {
        mainApp.bgmusicRunnable.playNext();
        playPauseImage.setImage(new Image("/gui/view/media_pause.png"));
    }
    
    @FXML
    private void handleMute() {
        if(BackgroundMusic.volume == 0.0) {
            BackgroundMusic.volume = oldVolume;
            changeVolume(oldVolume);
            volumeSlider.setValue(oldVolume);  
            muteButton.setImage(new Image("/gui/view/media_volume.png"));
        }else{
            oldVolume = BackgroundMusic.volume;
            changeVolume(0);
            volumeSlider.setValue(BackgroundMusic.volume);   
            muteButton.setImage(new Image("/gui/view/media_mute.png"));
        }
    }
    
    @FXML
    private void handleRefresh(){
        //because it autoplays.
        playPauseImage.setImage(new Image("/gui/view/media_pause.png"));
        mainApp.bgmusicRunnable.refresh();
    }
    
    @FXML
    private void handleOpenFolder() throws IOException{
        File musicPath = new File("./src/media");
        if(Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(musicPath);
        }
    }
    
    @FXML
    private void handleVolumeSlider(){
        changeVolume(volumeSlider.getValue());
    }
    
    private void changeVolume(double v){
        mainApp.bgmusicRunnable.changeVolume(v);
    }
//--------------------media player----------------------
    
}
