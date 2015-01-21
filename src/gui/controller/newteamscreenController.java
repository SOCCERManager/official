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
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import soccer.Competitie;
import soccer.Speler;
import soccer.Team;
import soccer.bouwXML;
import static soccer.bouwXML.bouwXML;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class newteamscreenController implements Initializable {
    
    private ObservableList<Team> teamData = FXCollections.observableArrayList();
    @FXML
    private TableView<Team> teamTable;
    @FXML
    private TableColumn<Team, String> TeamColumn;
    
    private ObservableList<Speler> spelerData = FXCollections.observableArrayList();
    @FXML
    private TableView<Speler> spelerTable;
    @FXML
    private TableColumn<Speler, String> spelerColumn;
    @FXML
    private TableColumn<Speler, Integer> rugColumn;
    @FXML
    private TableColumn<Speler, String> positieColumn;
    @FXML
    private TableColumn<Speler, Double> aanvalColumn;
    @FXML
    private TableColumn<Speler, Double> verdedigingColumn;
    @FXML
    private TableColumn<Speler, Double> staminaColumn;
    
    @FXML
    private Button chooseButton;
    
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
     * Initializes the controller class.
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
        
        chooseButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        chooseButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        
            for(int i = 0; i < Competitie.getCompetitie().getTeams().size(); i++){
                Competitie.getCompetitie().getTeams().get(i).generateOpstelling();
            }
        ArrayList<Team> teamList = Competitie.getCompetitie().getTeams();
        teamData.addAll(teamList);
        
        TeamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        
        teamTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTeamDetails(newValue));
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        teamTable.setItems(teamData);
    }
    
    public void showTeamDetails(Team team){
        spelerData.clear();
        ArrayList<Speler> spelerList = team.getSpelers();
        
        spelerData.addAll(spelerList);
        
        spelerColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        rugColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        positieColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(""+cellData.getValue().getType()));
        aanvalColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getAanvallend()* 0.01)).asObject());
        aanvalColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        verdedigingColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getVerdedigend()* 0.01)).asObject());
        verdedigingColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        staminaColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getUithoudingsvermogen()* 0.01)).asObject());
        staminaColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        
        spelerTable.setItems(spelerData);
        
        aanvalColumn.getStyleClass().add("red-bar");
        staminaColumn.getStyleClass().add("yellow-bar");
        verdedigingColumn.getStyleClass().add("blue-bar");
    }
    
    @FXML
    private void handleSelect() throws IOException{
        Competitie.getCompetitie().setUserindex(
        Competitie.getCompetitie().getTeams().indexOf(teamTable.getSelectionModel().getSelectedItem()));
        try {bouwXML.SaveGame();} catch(Exception e){ System.out.println(e.getStackTrace()); }
        mainApp.showMainHubScreen();
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
