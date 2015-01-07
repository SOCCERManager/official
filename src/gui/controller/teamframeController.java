/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
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
import soccer.Speler;
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class teamframeController implements Initializable {
    
    private Team userteam = Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex());
    private ObservableList<Speler> teamData = FXCollections.observableArrayList();
    @FXML
    private TableView<Speler> teamTable;
    @FXML
    private TableColumn<Speler, String> zijteamColumn;
    @FXML
    private TableColumn<Speler, Integer> zijrugColumn;
    @FXML
    private TableColumn<Speler, String> zijnaamColumn;
    
    private ObservableList<PosPlayer> opstelData = FXCollections.observableArrayList();
    @FXML
    private TableView<PosPlayer> opstelTable;
    @FXML
    private TableColumn<PosPlayer, Integer> opstelrugColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstelnaamColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstelposColumn;

    @FXML
    private Label gameLabel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gameLabel.setText(userteam.getName());
        
        teamData.addAll(userteam.getSpelers());
        if(!userteam.OpstellingIsValide())
            userteam.generateOpstelling();
        opstelData.addAll(userteam.getOpstelling());
        zijnaamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        zijrugColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        
        opstelnaamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        opstelrugColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        opstelposColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(""+cellData.getValue().getPosSpelertype()));
        
        
        
        // TODO
        
        opstelTable.setItems(opstelData);
        teamTable.setItems(teamData);
        
        zijnaamColumn.setSortType(TableColumn.SortType.ASCENDING);
        teamTable.getSortOrder().add(zijnaamColumn);
    }    
    
    
    
}
