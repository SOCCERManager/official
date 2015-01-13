/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import soccer.Competitie;
import soccer.Team;
import soccer.Wedstrijd;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class historyframeController implements Initializable {
    
    @FXML
    private ObservableList<Wedstrijd> historyList = FXCollections.observableArrayList();
    @FXML
    private TableView<Wedstrijd> historyTable;
    @FXML
    private TableColumn<Wedstrijd, String> tthuis;
    @FXML
    private TableColumn<Wedstrijd, String> tuit;
    @FXML
    private TableColumn<Wedstrijd, Integer> sthuis;
    @FXML    
    private TableColumn<Wedstrijd, Integer> suit;
    @FXML
    private TableColumn<Wedstrijd, Integer> bthuis;
    @FXML
    private TableColumn<Wedstrijd, Integer> buit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Wedstrijd> wedstrijdList = new ArrayList<Wedstrijd>();
        for(Wedstrijd w: Competitie.getCompetitie().getWedstrijden()) {
            if(w.isPlayed())
                wedstrijdList.add(w);
        }
        
        historyList.addAll(wedstrijdList);
        tthuis.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getTeam_a().getName()));
        tuit.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getTeam_b().getName()));
        sthuis.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getScore_a()).asObject());
        suit.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getScore_b()).asObject());
        bthuis.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getPoints_a()).asObject());
        buit.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getPoints_b()).asObject());
        
        
        historyTable.setItems(historyList); 
        tthuis.setSortType(TableColumn.SortType.ASCENDING);
        historyTable.getSortOrder().add(tthuis);
        historyTable.getSelectionModel().clearSelection();
    }   
    
}
