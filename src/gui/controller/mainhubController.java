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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.Team;
import soccer.Wedstrijd;
import soccer.bouwXML;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class mainhubController implements Initializable {
    
    public static ArrayList<Team> originalteamlist;
    
    private static mainhubController mch;
    
    @FXML
    private ImageView teamLogo;
    
    @FXML
    private Label nameLabel;
    @FXML
    private Label budgetLabel;
    @FXML
    private Label comppuntenLabel;
    @FXML
    private Label gespeeldLabel;
    @FXML
    private Label winsLabel;
    @FXML
    private Label kaartenLabel;
    
    
    @FXML
    private AnchorPane hubBanner;
    @FXML
    private AnchorPane viewPane;
    
    @FXML
    private Button Menu;
    @FXML
    private Button compButton;
    @FXML
    private Button mhistoryButton;
    @FXML
    private Button playButton;
    @FXML
    private Button opstellingButton;
    @FXML
    private Button marktButton;
    @FXML
    private Button verkoopButton;
    
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
    
    
    private Wedstrijd currentgame;
    
    private MainApp mainApp;
    /**
     * Initializes the controller class.
     */
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
        
        //Button click sounds
        Menu.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        Menu.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        compButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        compButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);  
        
        mhistoryButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        mhistoryButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);  
        
        playButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        playButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        opstellingButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        opstellingButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        marktButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        marktButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        verkoopButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        verkoopButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
        teamLogo.setImage(new Image("/gui/view/logo/"+Competitie.getCompetitie().getUserindex()+".png"));
        originalteamlist = Competitie.getCompetitie().getTeams();
        System.out.println(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).getName() +" DIT IS DE TEAMNAAM");
        Competitie.getCompetitie().playGamesTilPlayerGameIsDue();
        mainhubController.mch = this;
    }    
    
    @FXML
    private void paneAdd(FXMLLoader loader) throws IOException{
        AnchorPane frame = (AnchorPane) loader.load();
           AnchorPane.setTopAnchor(frame, 0.0);
           AnchorPane.setBottomAnchor(frame, 0.0);
           AnchorPane.setLeftAnchor(frame, 0.0);
           AnchorPane.setRightAnchor(frame, 0.0);
           // Set person overview into the center of root layout.
        viewPane.getChildren().clear();
        viewPane.getChildren().setAll(frame);
    }
    @FXML
    private void handleKoop() throws IOException{
        FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/koopframe.fxml"));
           paneAdd(loader);
           
    }
    
    @FXML
    private void handleVeranderOpstelling() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/veranderopstelling.fxml"));
        paneAdd(loader);
                
    }
    @FXML
    private void handleVerkoop() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/verkoopframe.fxml"));
        paneAdd(loader);
    }
    @FXML
    private void handleOpstelling(){
        mainApp.showOpstellingScreen();
    }
    @FXML
    private void handleCompetitie() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/competitieframe.fxml"));
        paneAdd(loader); 
    }
    @FXML
    private void handleHistory() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/historyframe.fxml"));
        paneAdd(loader);
    }
    @FXML
    private void handlePlay() throws IOException{
        Competitie.getCompetitie().playGamesTilPlayerGameIsDue();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/preGame.fxml"));
        paneAdd(loader);
    }
    
    @FXML
    private void handlePlayGame() throws IOException {
        try{
            this.currentgame = Competitie.getCompetitie().playPlayerGame();
            currentgameframeController.currentgame = currentgame;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/currentgameframe.fxml"));
            paneAdd(loader); 
        }catch(Exception e){e.printStackTrace();}
        try {bouwXML.SaveGame();} catch(Exception e){ System.out.println(e.getStackTrace()); }       
    }
    
    @FXML
    private void handleBackButton(){
        try {bouwXML.SaveGame();} catch(Exception e){ System.out.println(e.getStackTrace()); }
        mainApp.showStartScreen();
        
    }
    
    @FXML
    private void handleTeam() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/teamframe.fxml"));
        paneAdd(loader);
    }
    
    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
//        NAAR BOVEN GEPLAATST IN INITILIZE VOOR SORTEREN.        
//        opstelTable.setItems(opstelData);
//        teamTable.setItems(teamData);
    }
    private void showSpelerDetails(Speler speler){
        
    }
    private void showOpstellingDetails(PosPlayer speler){
        
    }
    public Wedstrijd getCurrentGame(){
        return this.currentgame;
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
