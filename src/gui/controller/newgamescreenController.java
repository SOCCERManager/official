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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import soccer.Competitie;
import soccer.ReadFolder;

/**
 * FXML Controller class
 *
 * @author floris
 */

public class newgamescreenController implements Initializable{
    
    @FXML
    private TextField nameField;
    @FXML
    private Button newGameButton;
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
    /**
     * Initilaizeerd de nieuwscreencontrolooer
     * @param url Url naar path
     * @param rb de recources die gebruikt worden
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //MEDIA
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
        
        
        newGameButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        newGameButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        backButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        backButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
    }    
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    
    @FXML
    private void handleStartButton(){
        String savegame = "";
        if(isInputValid()){
            if(!nameExists())
                savegame = nameField.getText();
            else
                savegame = nameField.getText() + "1";
        try{
            
        Competitie c = soccer.bouwXML.leesXML(new File("src/competitie.xml"));
        
        soccer.bouwXML.bouwXML(c, new File("src/saves/"+savegame+".xml"));
        Competitie.setCompetitie(c);
        }catch(Exception e){System.out.println(e);}
        loadscreenController.savegame = savegame;
        mainApp.showNewTeamScreen();
        }
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private boolean isInputValid(){
        String errortext = "";
        if(nameField.getText() == null || nameField.getText().length() == 0 || !nameField.getText().matches("[a-zA-Z0-9_]+"))
            errortext = "No valid input";
        if (errortext.length() == 0) {
            return true;
        } else {
            // Show the error message.
            System.out.println(errortext);
            nameField.setText(errortext);
            return false;
        }
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
