/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Nils
 */
public class SoccerApplication {

    public static void main(String[] args) throws IOException {

       
  
        Speler speler1 = new Speler("Albert", 1, SpelerType.Verdediger, 100000, 32, 74, 64);
        Speler speler2 = new Speler("Bert", 2, SpelerType.Verdediger, 200000, 24, 82, 82);
        Speler speler3 = new Speler("Chris", 3, SpelerType.Verdediger, 300000, 14, 68, 87);
        Speler speler4 = new Speler("Daan", 4, SpelerType.Verdediger, 400000, 40, 65, 70);
        Speler speler5 = new Speler("Erik", 5, SpelerType.Middenvelder, 500000, 60, 67, 80);
        Speler speler6 = new Speler("Frank", 6, SpelerType.Middenvelder, 600000, 70, 30, 89);
        Speler speler7 = new Speler("Gerard", 7, SpelerType.Middenvelder, 700000, 65, 65, 50);
        Speler speler8 = new Speler("Harry", 8, SpelerType.Aanvaller, 800000, 78, 23, 64);
        Speler speler9 = new Speler("Irlan", 9, SpelerType.Aanvaller, 900000, 89, 25, 58);
        Speler speler10 = new Speler("Jan", 10, SpelerType.Aanvaller, 10000, 82, 19, 84);
        Speler speler11 = new Speler("Klaas", 11, SpelerType.Doelman, 20000, 20, 20, 95);
        
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        spelerlijst.add(speler1);
        spelerlijst.add(speler2);
        spelerlijst.add(speler3);
        spelerlijst.add(speler4);
        spelerlijst.add(speler5);
        spelerlijst.add(speler6);
        spelerlijst.add(speler7);
        spelerlijst.add(speler8);
        spelerlijst.add(speler9);
        spelerlijst.add(speler10);
        spelerlijst.add(speler11);
        
        PosPlayer pos1 = new PosPlayer(speler11, SpelerType.Doelman);
        PosPlayer pos2 = new PosPlayer(speler1, SpelerType.Verdediger);
        PosPlayer pos3 = new PosPlayer(speler2, SpelerType.Verdediger);
        PosPlayer pos4 = new PosPlayer(speler3, SpelerType.Verdediger);
        PosPlayer pos5 = new PosPlayer(speler4, SpelerType.Verdediger);
        PosPlayer pos6 = new PosPlayer(speler5, SpelerType.Middenvelder);
        PosPlayer pos7 = new PosPlayer(speler6, SpelerType.Middenvelder);
        PosPlayer pos8 = new PosPlayer(speler7, SpelerType.Middenvelder);
        PosPlayer pos9 = new PosPlayer(speler8, SpelerType.Aanvaller);
        PosPlayer pos10 = new PosPlayer(speler9, SpelerType.Aanvaller);
        PosPlayer pos11 = new PosPlayer(speler10, SpelerType.Aanvaller);
        
        ArrayList<PosPlayer> Posities = new ArrayList<PosPlayer>();
        Posities.add(pos1);
        Posities.add(pos2);
        Posities.add(pos3);
        Posities.add(pos4);
        Posities.add(pos5);
        Posities.add(pos6);
        Posities.add(pos7);
        Posities.add(pos8);
        Posities.add(pos9);
        Posities.add(pos10);
        Posities.add(pos11);
        
        Team testElftal = new Team(spelerlijst, "testElftal", Posities);
        soccer.bouwXML.bouwXML(testElftal);
        
        System.out.println(testElftal.getName());
        Team test = soccer.bouwXML.leesXML();
        System.out.println(test.getName());
    }
}
