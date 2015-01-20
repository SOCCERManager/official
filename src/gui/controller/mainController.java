/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.BackgroundMusic;
import gui.MainApp;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;

/**
 *
 * @author codesalad
 */
public class mainController implements Initializable {
    
    @FXML
    private HBox loadingBox;
    
    @FXML
    private Label label;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Button playPauseButton;
    @FXML
    private ImageView muteButton;
    @FXML
    private ImageView playPauseImage;
    
    private MainApp mainApp;
    static double oldVolume;
    
    @FXML
    private void handleLoadButton(ActionEvent event) {
        loadingBox.setVisible(true);
        handleClickSound();
        mainApp.showLoadScreen();
    }
    
    @FXML
    private void handleNewGameButton(ActionEvent event) {
        loadingBox.setVisible(true);
        handleClickSound();
        mainApp.showNewGameScreen();
    }
    
    @FXML
    private void handleExitButton() {
        handleClickSound();
        System.exit(0);
    }
    
    @FXML
    private void handleClickSound() {
        AudioClip clickSound = new AudioClip(new File("./src/gui/clicksound.mp3").toURI().toString());
        clickSound.setVolume(1.5);
        clickSound.play();
    }
    
    @FXML
    private void handlePrevious() {
        mainApp.bgmusicRunnable.playPrevious();
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
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        volumeSlider.setValue(BackgroundMusic.volume);        
    }    
    
    
}
