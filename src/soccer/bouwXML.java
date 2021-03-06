package soccer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import gui.controller.loadscreenController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * Class bouwXML
 */
public class bouwXML {

    /**
     * Een Competitie wordt in de opgegeven XMLfie gezet.
     * @param t de opgegeven competitie
     * @param f de file waar de xml in moet komen te staan
     * @throws IOException File is missing
     */
    public static void bouwXML(Competitie t, File f) throws IOException{
        String xml = getStream().toXML(t);
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(xml);
        out.close();
    }
    
    /**
     * Genereert uit een XML file de Competitie klasse
     * @return  de competitie
     */
    private static XStream getStream() {
         XStream xstream = new XStream(new StaxDriver());
         xstream.alias("Competitie", Competitie.class);
         xstream.alias("OpgesteldeSpeler", PosPlayer.class);
         xstream.alias("Speler", Speler.class);
         xstream.alias("Team", Team.class);
         xstream.alias("Wedstrijd", Wedstrijd.class);
         return xstream;
    }
    
    /**
     * Leest uit een bestand en zet dit om naar een Competitie
     * This function reads the contents of File f and transfers the contents to a Competitie class.
     * @param f de file waaruit gelezen moet worden
     * @return de competitie die aan alle eisen voldoet. 
     * @throws FileNotFoundException Bestand bestaat niet
     */
    public static Competitie leesXML(File f) throws FileNotFoundException{
        Scanner infile = new Scanner(f);
        String te = "";
        while(infile.hasNext())
            te += infile.nextLine().replace("Roode_kaart", "Rode_kaart").replace("Gebleseerd", "Geblesseerd")+"\n";
        Competitie c = (Competitie) getStream().fromXML(te);
        Competitie.setCompetitie(c);
        return c;
    }
    
    /**
     * Saves the game
     * @throws IOException Bestand bestaat niet
     */
    public static void SaveGame() throws IOException {
       bouwXML.bouwXML(Competitie.getCompetitie(), new File("src/saves/"+loadscreenController.savegame+".xml"));
    }
    
    
}
