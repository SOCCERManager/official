/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerStatus;
import static soccer.SpelerType.*;
import soccer.Team;
import soccer.bouwXML;

/**
 * FXML Controller class
 *
 * @author codesalad
 */
public class veranderOpstellingController implements Initializable {
    /** DRAG AND DROP **/
    @FXML
    private Label naam;
    @FXML
    private Label rugnummer;
    @FXML
    private Pane dragpane;
    
    @FXML
    private VBox d1;
    @FXML
    private VBox v1;
    @FXML
    private VBox v2;
    @FXML
    private VBox v3;
    @FXML
    private VBox v4;
    @FXML
    private VBox m1;
    @FXML
    private VBox m2;
    @FXML
    private VBox m3;
    @FXML
    private VBox a1;
    @FXML
    private VBox a2;
    @FXML
    private VBox a3;
    
    @FXML
    private Label d_naam1;
    @FXML
    private Label d_positie1;
    @FXML
    private ProgressBar d_aanval1;
    @FXML
    private ProgressBar d_verdediging1;
    @FXML
    private ProgressBar d_uithouding1;
    
    @FXML
    private Label d_naam11;
    @FXML
    private Label d_positie11;
    @FXML
    private ProgressBar d_aanval11;
    @FXML
    private ProgressBar d_verdediging11;
    @FXML
    private ProgressBar d_uithouding11;
    
    @FXML
    private Label d_naam12;
    @FXML
    private Label d_positie12;
    @FXML
    private ProgressBar d_aanval12;
    @FXML
    private ProgressBar d_verdediging12;
    @FXML
    private ProgressBar d_uithouding12;
    
    @FXML
    private Label d_naam13;
    @FXML
    private Label d_positie13;
    @FXML
    private ProgressBar d_aanval13;
    @FXML
    private ProgressBar d_verdediging13;
    @FXML
    private ProgressBar d_uithouding13;
    
    @FXML
    private Label d_naam21;
    @FXML
    private Label d_positie21;
    @FXML
    private ProgressBar d_aanval21;
    @FXML
    private ProgressBar d_verdediging21;
    @FXML
    private ProgressBar d_uithouding21;
    
    @FXML
    private Label d_naam22;
    @FXML
    private Label d_positie22;
    @FXML
    private ProgressBar d_aanval22;
    @FXML
    private ProgressBar d_verdediging22;
    @FXML
    private ProgressBar d_uithouding22;
    
    @FXML
    private Label d_naam23;
    @FXML
    private Label d_positie23;
    @FXML
    private ProgressBar d_aanval23;
    @FXML
    private ProgressBar d_verdediging23;
    @FXML
    private ProgressBar d_uithouding23;
    
    @FXML
    private Label d_naam31;
    @FXML
    private Label d_positie31;
    @FXML
    private ProgressBar d_aanval31;
    @FXML
    private ProgressBar d_verdediging31;
    @FXML
    private ProgressBar d_uithouding31;
    
    @FXML
    private Label d_naam32;
    @FXML
    private Label d_positie32;
    @FXML
    private ProgressBar d_aanval32;
    @FXML
    private ProgressBar d_verdediging32;
    @FXML
    private ProgressBar d_uithouding32;
    
    @FXML
    private Label d_naam33;
    @FXML
    private Label d_positie33;
    @FXML
    private ProgressBar d_aanval33;
    @FXML
    private ProgressBar d_verdediging33;
    @FXML
    private ProgressBar d_uithouding33;
    
    @FXML
    private Label d_naam;
    @FXML
    private Label d_positie;
    @FXML
    private ProgressBar d_aanval;
    @FXML
    private ProgressBar d_verdediging;
    @FXML
    private ProgressBar d_uithouding;
    
    @FXML
    private Pane status1;
    @FXML
    private Pane status2;
    @FXML
    private Pane status3;
    @FXML
    private Pane status4;
    @FXML
    private Pane status5;
    @FXML
    private Pane status6;
    @FXML
    private Pane status7;
    @FXML
    private Pane status8;
    @FXML
    private Pane status9;
    @FXML
    private Pane status10;
    @FXML
    private Pane status11;
    
    
    
    /** EINDE DRAG AND DROP **/
    
    
    
    @FXML
    private AnchorPane mainOpstellingPane;
    @FXML
    private TableView<Speler> teamTable;
    @FXML
    private TableColumn<Speler, String> filteredTeamColumn;
    @FXML
    private TableColumn<Speler, String> filteredPositieColumn;
    @FXML
    private TableColumn<Speler, Double> filteredAanvalColumn;
    @FXML
    private TableColumn<Speler, Double> filteredStaminaColumn;
    @FXML
    private TableColumn<Speler, Double> filteredVerdedigingColumn;
    @FXML
    private TableColumn<Speler, String> filteredStatusColumn;
    @FXML
    private AnchorPane titlePane;
    @FXML
    private SplitPane splitPane;
    @FXML
    private VBox helpMessage;
    @FXML
    private VBox alert1;
    @FXML
    private TextArea alert1Text;
    @FXML 
    private VBox alert2;
    @FXML
    private TextArea alert2Text;
    @FXML
    private Button opstellingRemoveButton;
    @FXML
    private Button opstellingAddButton;
    @FXML
    private Button saveOpstellingButton;
    
    private Team userteam = mainhubController.originalteamlist.get(Competitie.getCompetitie().getUserindex()); 
    private ArrayList<Speler> teamSpelers = new ArrayList<Speler>(userteam.getSpelers());
    private ArrayList<PosPlayer> opstelling = new ArrayList<PosPlayer>(userteam.getOpstelling());
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Image image = new Image(getClass().getResourceAsStream("/gui/view/shirt.png"));
        
        for(int i = 0; i < opstelling.size(); i++)
            System.out.println(opstelling.get(i).getLoc());
        drawTeam();
        drawOpstelling();
        
        /** DRAG AND DROP **/
        
        teamTable.setOnDragDetected(new EventHandler<MouseEvent>() { //drag
            @Override
            public void handle(MouseEvent event) {
               
                // drag was detected, start drag-and-drop gesture
                String selected = teamTable.getSelectionModel().getSelectedItem().getNaam();
                System.out.println(selected);
                if(selected !=null){

                    Dragboard db = teamTable.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(selected);
                    db.setContent(content);
                    event.consume(); 
                }
            }
        });
        
        d1.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        d1.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Doelman);
                            n.setLoc(0);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        v1.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        v1.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam1.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Verdediger);
                            n.setLoc(1);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        v2.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        v2.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam11.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Verdediger);
                            n.setLoc(2);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        v3.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        v3.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam12.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Verdediger);
                            n.setLoc(3);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        v4.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        v4.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam13.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Verdediger);
                            n.setLoc(4);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        m1.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        m1.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam21.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Middenvelder);
                            n.setLoc(5);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        m2.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        m2.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam22.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Middenvelder);
                            n.setLoc(6);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        m3.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        m3.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam23.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Middenvelder);
                            n.setLoc(7);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        a1.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        a1.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam31.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Aanvaller);
                            n.setLoc(8);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        a2.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        a2.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam32.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Aanvaller);
                            n.setLoc(9);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        a3.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // data is dragged over the target 
                Dragboard db = event.getDragboard();
                if (event.getDragboard().hasString()){
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        a3.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (event.getDragboard().hasString()) {            

                    String text = db.getString();
                    for(Speler s: teamSpelers){
                        if(text.equals(s.getNaam()) && !isInOpstelling(s)){
                           for(int i = 0; i < opstelling.size(); i++){
                                if(d_naam33.getText().equals(opstelling.get(i).getNaam())){
                                    opstelling.remove(i);
                                    break;
                                }
                            }
                            PosPlayer n = new PosPlayer(s, Aanvaller);
                            n.setLoc(10);
                            opstelling.add(n);
                            saveOpstelling();
                            drawTeam();
                            drawOpstelling();
                            break;
                        }
                    }
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            } 
        });
        
    }    
    
    
    
    
    /** EINDE DRAG AND DROP **/
    
    public void drawTeam() {
        ObservableList<Speler>filteredTeamList = FXCollections.observableArrayList();
        ArrayList<Speler> allPosPlayers = new ArrayList<Speler>();
        ArrayList<Speler> filteredTeam = new ArrayList<Speler>();
        filteredTeamList.clear();
        
        for(int i = 0; i < userteam.getOpstelling().size(); i++)
            allPosPlayers.add(userteam.getOpstelling().get(i).getSpeler());
        for(int i = 0; i < userteam.getSpelers().size(); i++){
            if(!allPosPlayers.contains(userteam.getSpelers().get(i)))
                filteredTeam.add(userteam.getSpelers().get(i));
        }
        
        
        filteredTeamList.addAll(filteredTeam);
        filteredTeamColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        filteredPositieColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getType().toString().replace("_", "")));
        
        filteredAanvalColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getAanvallend() * 0.01)).asObject());
        filteredAanvalColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        
        filteredStaminaColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getUithoudingsvermogen()* 0.01)).asObject());
        filteredStaminaColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        
        filteredVerdedigingColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getVerdedigend()* 0.01)).asObject());
        filteredVerdedigingColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        
        filteredStatusColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString().replace("_", " ")));
        
        
        teamTable.setItems(filteredTeamList);
        filteredTeamColumn.setSortType(TableColumn.SortType.ASCENDING);
        teamTable.getSortOrder().add(filteredTeamColumn);
        
        filteredAanvalColumn.getStyleClass().add("red-bar");
        filteredStaminaColumn.getStyleClass().add("yellow-bar");
        filteredVerdedigingColumn.getStyleClass().add("blue-bar");
        
        teamTable.getSelectionModel().clearSelection();
    }
    
    /*
    @FXML
    private void handleRemoveFromOpstelling() {
        opstelling.remove(opstellingTable.getSelectionModel().getSelectedItem());
        if(opstelling.size()==0){
            opstellingRemoveButton.setDisable(true);
        }
        if(opstelling.size()<11){
            opstellingAddButton.setDisable(false);
            //saveOpstellingButton.setDisable(true);
            saveOpstellingButton.setOpacity(.2);
            
            saveOpstellingButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    handleOpstellingMessage();
                }
            });
        }

        drawOpstelling();
        drawTeam();
    }
    
    @FXML
    private void handleAddToOpstelling() {
        if(opstelling.size()<11 && teamTable.getSelectionModel().getSelectedItem() != null){
            if(!teamTable.getSelectionModel().getSelectedItem().isUnavaliableToPlay()) {
                opstelling.add(teamTable.getSelectionModel().getSelectedItem());
            } else {
                alert2Text.setText("Speler is niet beschikbaar: " + teamTable.getSelectionModel().getSelectedItem().getStatus() + "!");
                alert2.setVisible(true);
            }
            if(opstelling.size()==11){
                opstellingAddButton.setDisable(true);
                //saveOpstellingButton.setDisable(false);
                
                saveOpstellingButton.setOpacity(1);

                saveOpstellingButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        handleSaveOpstelling();
                    }
                });
            }
        }
        opstellingRemoveButton.setDisable(false);
        drawOpstelling();
        drawTeam();

    }*/
    
    public void handleOpstellingMessage() {
        alert1Text.setText("De opstelling bevat niet genoeg spelers! (" + Integer.toString(opstelling.size()) + "/11 spelers)");
        alert1.setVisible(true);
    }
    
    private void saveOpstelling() {
            userteam.setOpstelling(opstelling);
            try {bouwXML.SaveGame();} catch(Exception e){ System.out.println(e.getStackTrace()); }
            System.out.println("Saved new opstelling");
    }
    
    @FXML
    private void handleCloseHelpMessage(){
        helpMessage.setVisible(false);
    }
    
    @FXML
    private void handleCloseAlert1() {
        alert1.setVisible(false);
    }
    
    @FXML
    private void handleCloseAlert2() {
        alert2.setVisible(false);
    }
    
    private void drawPlayer(Label naam, String title, Label pos, ProgressBar aanv, ProgressBar verd, ProgressBar uith, PosPlayer j, Pane stat) {
        naam.setText(j.getNaam());
        pos.setText(title);
        aanv.setProgress(new Double(j.getAanvallend()*0.01));
        verd.setProgress(new Double(j.getVerdedigend())*0.01);
        uith.setProgress(new Double(j.getUithoudingsvermogen())*0.01);
        aanv.getStyleClass().add("red-bar");
        uith.getStyleClass().add("yellow-bar");
        verd.getStyleClass().add("blue-bar");
        if(!j.getStatus().equals(SpelerStatus.Normaal))                                
            stat.getStyleClass().add(""+j.getStatus());
        else
            stat.getStyleClass().clear();
    }
    
    private void drawOpstelling(){
        for(PosPlayer j: opstelling){
            System.out.println(j.getLoc());
                
            switch(j.getLoc()) {
                case 0:
                    drawPlayer(d_naam, "Doelman", d_positie, d_aanval, d_verdediging, d_uithouding, j, status1);
                    break;
                case 1:
                    drawPlayer(d_naam1, "Verdediger", d_positie1, d_aanval1, d_verdediging1, d_uithouding1, j, status2);
                    break;
                case 2:
                    drawPlayer(d_naam11, "Verdediger", d_positie11, d_aanval11, d_verdediging11, d_uithouding11, j, status3);
                    break;
                case 3:
                    drawPlayer(d_naam12, "Verdediger", d_positie12, d_aanval12, d_verdediging12, d_uithouding12, j, status4);
                    break;
                case 4:
                    drawPlayer(d_naam13, "Verdediger", d_positie13, d_aanval13, d_verdediging13, d_uithouding13, j, status5);
                    break;
                case 5:
                    drawPlayer(d_naam21, "Middenvelder", d_positie21, d_aanval21, d_verdediging21, d_uithouding21, j, status6);
                    break;
                case 6:
                    drawPlayer(d_naam22, "Middenvelder", d_positie22, d_aanval22, d_verdediging22, d_uithouding22, j, status7);
                    break;
                case 7:
                    drawPlayer(d_naam23, "Middenvelder", d_positie23, d_aanval23, d_verdediging23, d_uithouding23, j, status8);
                    break;
                case 8:
                    drawPlayer(d_naam31, "Aanvelder", d_positie31, d_aanval31, d_verdediging31, d_uithouding31, j, status9);
                    break;
                case 9:
                    drawPlayer(d_naam32, "Aanvelder", d_positie32, d_aanval32, d_verdediging32, d_uithouding32, j, status10);
                    break;
                case 10:
                    drawPlayer(d_naam33, "Aanvelder", d_positie33, d_aanval33, d_verdediging33, d_uithouding33, j, status11);
                    break;
                
                default: System.out.println("IK KAN NIKS"); break;
            }
            
        }
    }  
    
    private boolean isInOpstelling(Speler s){
        for(PosPlayer j: opstelling)
            if(j.getSpeler().equals(s)){
                alert1Text.setText("Deze speler zit al in de huidige opstelling.");
                alert1.setVisible(true);
                return true;
            }
        return false;
    }

}
