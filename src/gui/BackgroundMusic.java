/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author codesalad
 */
public class BackgroundMusic extends Thread{
private ArrayList<String> listOfSongs = new ArrayList();
    public BackgroundMusic(String name){
        super(name);
    }
    public void run() {
        File folder = new File("./src/media");
        File[] list = folder.listFiles();
        for(int i=0; i<list.length; i++) {
            if(list[i].isFile()){
                listOfSongs.add(list[i].getPath());
            }
            Collections.shuffle(listOfSongs);
        }
        
        final ArrayList<MediaPlayer> players = new ArrayList();
        for(int i=0; i<listOfSongs.size(); i++){
            players.add(createPlayer(listOfSongs.get(i)));
        }
        
        final MediaView mediaView = new MediaView(players.get(0));
        final Button skip = new Button("Skip");
        final Button play = new Button("Pause");
        
        for (int i = 0; i<players.size(); i++){
            final MediaPlayer player = players.get(i);
            final MediaPlayer nextPlayer = players.get((i + 1) % players.size());
            player.setStopTime(Duration.UNKNOWN);
           
            player.setOnEndOfMedia(new Runnable() {
                @Override public void run() { 
                    player.stop();
                    nextPlayer.setStopTime(Duration.UNKNOWN);
                    mediaView.setMediaPlayer(nextPlayer);
                    nextPlayer.play();
                    System.out.println("Playing next: " + nextPlayer.getMedia().getSource());
                    
                }
            });
        }
        
        mediaView.setMediaPlayer(players.get(0));
        mediaView.getMediaPlayer().play();

        System.out.println("Playing: " + players.get(0).getMedia().getSource());
       
        while(true){}
        
                

    }
        
    private MediaPlayer createPlayer(String source) {
        System.out.println("Creating player for: " + source);
        final MediaPlayer player = new MediaPlayer(new Media(new File(source).toURI().toString()));
        player.setOnError(new Runnable() {
          @Override public void run() {
            System.out.println("Media error occurred: " + player.getError());
          }
        });
        return player;
  }
}
