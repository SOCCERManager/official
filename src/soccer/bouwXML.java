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
    public static void bouwXML(Team t) throws IOException{
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(t);
        BufferedWriter out = new BufferedWriter(new FileWriter("test.xml"));
        out.write(xml);
        out.close();
    }
    
    public static Team leesXML() throws FileNotFoundException{
        Scanner infile = new Scanner(new File("test.xml"));
        String te = "";
        while(infile.hasNext()){
            te += infile.nextLine();
        }
        XStream xstream = new XStream(new StaxDriver());
        Team t = (Team)xstream.fromXML(te);
        return t;
    }
}