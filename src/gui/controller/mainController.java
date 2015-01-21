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
import javafx.scene.input.MouseEvent;
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
    private Button mainButton;
    @FXML
    private Button mainButton2;
    @FXML 
    private Button mainButton3;
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
    @FXML
    private Button m_refresh;
    @FXML
    private Button m_folder;
    @FXML
    private Button m_back;
    @FXML
    private Button m_next;
    
    
    private MainApp mainApp;
    static double oldVolume;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        volumeSlider.setValue(BackgroundMusic.volume);
        
        //main buttons
        mainButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        mainButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        mainButton2.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        mainButton2.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        mainButton3.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        mainButton3.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        //MEDIA PLAYER
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
        
    }
    
    @FXML
    private void handleLoadButton(ActionEvent event) {
        loadingBox.setVisible(true);
        mainApp.showLoadScreen();
    }
    
    @FXML
    private void handleNewGameButton(ActionEvent event) {
        loadingBox.setVisible(true);
        mainApp.showNewGameScreen();
    }
    
    @FXML
    private void handleExitButton() {
        System.exit(0);
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
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }     
}
