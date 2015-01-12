/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.media.jfxmediaimpl.platform.Platform;
import java.awt.AWTException;
import java.awt.Robot;
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
public class BackgroundMusic implements Runnable {

    private ArrayList<String> listOfSongs = new ArrayList();
    final ArrayList<MediaPlayer> players = new ArrayList();
    public static double volume = 1.0;
    public String threadName;
    private MediaView mediaView;
    
    public BackgroundMusic(String name){
        this.threadName = name;
    }
    public void run() {

        File folder = new File("./src/media");
        File[] list = folder.listFiles();
        
        for(int i=0; i<list.length; i++) {
            if(list[i].getName().substring(list[i].getName().lastIndexOf(".")).equals(".mp3")){
                listOfSongs.add(list[i].getPath());
            }else{
                System.out.println(list[i].getName() + " is not a song. Not adding to playlist.");
            }
            Collections.shuffle(listOfSongs);
        }
        
        
        for(int i=0; i<listOfSongs.size(); i++){
            players.add(createPlayer(listOfSongs.get(i)));
        }
        
        mediaView = new MediaView(players.get(0));
        
        for (int i = 0; i<players.size(); i++){
            final MediaPlayer player = players.get(i);
            final MediaPlayer nextPlayer = players.get((i + 1) % players.size());
            player.setStopTime(Duration.UNKNOWN);
            player.setVolume(volume);
           
            player.setOnEndOfMedia(new Runnable() {
                @Override public void run() { 
                    player.stop();
                    nextPlayer.setStopTime(Duration.UNKNOWN);
                    mediaView.setMediaPlayer(nextPlayer);
                    nextPlayer.setVolume(volume);
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
    public void changeVolume(double v) {
        volume = v;
        if(volume>1){
            volume = 1;
        } else if(volume < 0) {
            volume = 0;
        }
        MediaPlayer current = mediaView.getMediaPlayer();
        current.setVolume(volume);
        System.out.println("Volume Up! " + volume);
    }
    
    public void playNext() {
        MediaPlayer current = mediaView.getMediaPlayer();
        MediaPlayer nextPlayer;
        if(players.indexOf(current) == players.size()-1) {
            nextPlayer = players.get(0);
        }else{
            nextPlayer = players.get(players.indexOf(current)+1);
        }
        current.stop();
        mediaView.setMediaPlayer(nextPlayer);
        nextPlayer.play();
    }
    
    public void playPrevious() {
        MediaPlayer current = mediaView.getMediaPlayer();
        MediaPlayer nextPlayer;
        if(players.indexOf(current) == 0) {
            nextPlayer = players.get(players.size()-1);
        }else{
            nextPlayer = players.get(players.indexOf(current)-1);
        }
        current.stop();
        mediaView.setMediaPlayer(nextPlayer);
        nextPlayer.play();
    }
    
    public void PlayPause() {
        MediaPlayer current = mediaView.getMediaPlayer();
        if(current.getStatus() == MediaPlayer.Status.PLAYING) {
            current.pause();
        } else {
            current.play();
        }
    }
    
    public int isPlaying() {
        MediaPlayer current = mediaView.getMediaPlayer();
        if(current.getStatus() == MediaPlayer.Status.PLAYING) {
            return 1;
        }
        return 0;
    }
    
}
