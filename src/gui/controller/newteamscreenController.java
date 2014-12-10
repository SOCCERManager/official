/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class newteamscreenController implements Initializable {
    
    @FXML
    private TitledPane team1;
    @FXML
    private TitledPane team2;
    
    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        team1.setText("test1");
        team2.setText("test2");
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}
