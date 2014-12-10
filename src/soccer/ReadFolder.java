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
    private static int aantalGames;
    private static ArrayList<String> saveFiles = new ArrayList<String>();
    
    public static ArrayList<String> Read(){
        try{
            String path = new java.io.File(".").getCanonicalPath();
            File folder = new File(path + "/src/saves");
            File[] listOfFiles = folder.listFiles();
            aantalGames = listOfFiles.length;
            
            for (int i = 0; i < aantalGames; i++) {
               if (getFileExtension(listOfFiles[i]).equals("xml")) {
                   saveFiles.add(listOfFiles[i].getName().replace(".xml", ""));
               }
            }
            return saveFiles;
        }
        catch(IOException e){
            System.err.println("Path does not exist!");
            return null;
        }
    }
    
    public static int getAantalSaveGames(){
        return aantalGames;
    }
    
    public static Competitie readXML(String file) throws FileNotFoundException {
        File saveGame = new File(file);
        return bouwXML.leesXML(saveGame);
    }
    
    public static String getFileExtension(File file){
        return
            (file.getName().lastIndexOf(".") > 0)? 
                file.getName().substring( file.getName().lastIndexOf(".")+1)
                :""
            ;
    }
}
