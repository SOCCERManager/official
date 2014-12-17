/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Wedstrijd;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class currentgameframeController implements Initializable {
    
    @FXML
    private Label team1Label;
    @FXML
    private Label goal1Label;
    @FXML
    private Label punten1Label;
    @FXML
    private Label team2Label;
    @FXML
    private Label goal2Label;
    @FXML
    private Label punten2Label;
    
    public static Wedstrijd currentgame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        team1Label.setText(currentgame.getTeam_a().getName());
        team2Label.setText(currentgame.getTeam_b().getName());
        goal1Label.setText(Integer.toString(currentgame.getScore_a()));
        goal2Label.setText(Integer.toString(currentgame.getScore_b()));
        punten1Label.setText(Integer.toString(currentgame.getPoints_a()));
        punten2Label.setText(Integer.toString(currentgame.getPoints_b()));
        
        
        
    }    
    
}
