/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author codesalad
 */
public class testXMLWriter {
    public static void main(String[] args) throws FileNotFoundException{
        Competitie gelezenCompetitie = bouwXML.leesXML(new File("./src/competitie.xml"));
        System.out.println(gelezenCompetitie.getTeams().get(0));
    }
}
