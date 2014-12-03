/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author codesalad
 */
public class ReadFolder {
    private static ArrayList<String> saveFiles = new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException, IOException{
//        Competitie gelezenCompetitie = bouwXML.leesXML(new File("./src/competitie.xml"));
//        System.out.println(gelezenCompetitie.getTeams().get(0));
       
        String path = new java.io.File(".").getCanonicalPath();
        File folder = new File(path + "/src");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
           if (listOfFiles[i].isFile()) {
               saveFiles.add(listOfFiles[i].getName());
           }
        }
    }
    
    public static Competitie readXML(String file) throws FileNotFoundException {
        File saveGame = new File(file);
        return bouwXML.leesXML(saveGame);
    }
}
