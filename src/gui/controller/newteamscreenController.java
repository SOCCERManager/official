/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import soccer.Competitie;
import soccer.Team;

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
    
    private MainApp mainApp;
    
    public newteamscreenController(){
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Team> teamList = Competitie.getCompetitie().getTeams();
        System.out.println(teamData);
        for(int i = 0; i < teamList.size(); i++)
            teamData.add(teamList.get(i));
        
        TeamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        teamTable.setItems(teamData);
    }
    
}
