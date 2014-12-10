/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *Klasse ReadFolder leest alle bestanden in ./saves af en zet de namen ervan in de ArrayList
 * @author codesalad
 */
public class ReadFolder {
    private static int aantalGames;
    private static ArrayList<String> saveFilesName = new ArrayList<String>();
    
    public static ArrayList<String> readNames(){
        try{
            String path = new java.io.File(".").getCanonicalPath();
            File folder = new File(path + "/src/saves");
            File[] listOfFiles = folder.listFiles();
            aantalGames = listOfFiles.length;
            SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
            for (int i = 0; i < aantalGames; i++) {
               if (getFileExtension(listOfFiles[i]).equals("xml")) {
                   String naam = format.format(listOfFiles[i].lastModified()) + "\t|\t";
                   saveFilesName.add(naam + listOfFiles[i].getName().replace(".xml", ""));
               }
            }
            return saveFilesName;
        }
        catch(IOException e){
            System.err.println("Het opgegeven pad bestaat niet!");
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
