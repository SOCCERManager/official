/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author floris
 */
public class bouwXML {

    /**
     * This function takes params Competitie t and File f to transfer Competitie t to XML and write it into File f.
     * @param t
     * @param f
     * @throws IOException
     */
    public static void bouwXML(Competitie t, File f) throws IOException{
       
        String xml = getStream().toXML(t);
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        out.write(xml);
        out.close();
    }
    
    
    public static XStream getStream() {
         XStream xstream = new XStream(new StaxDriver());
         xstream.alias("Competitie", Competitie.class);
         xstream.alias("OpgesteldeSpeler", PosPlayer.class);
         xstream.alias("Speler", Speler.class);
         xstream.alias("Team", Team.class);
         xstream.alias("Wedstreid", Wedstrijd.class);
         return xstream;
    }
    
    /**
     * This function reads the contents of File f and transfers the contents to a Competitie class.
     * @param f
     * @return
     * @throws FileNotFoundException
     */
    public static Competitie leesXML(File f) throws FileNotFoundException{
        Scanner infile = new Scanner(f);
        String te = "";
        while(infile.hasNext())
            te += infile.nextLine();
        Competitie t = (Competitie) getStream().fromXML(te);
        return t;
    }
    
    
}
