/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerStatus;
import soccer.SpelerType;

/**
 *
 * @author floris
 */
public class PosPlayerTest {

    public void ConstructorTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertNotNull(p1);
    }
    
    public void getSpelerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(s1, p1.getSpeler());
    }
    
    public void setSpelerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Alfred", 68, SpelerType.Middenvelder, 50000, 98, 21, 3);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setSpeler(s2);
        assertEquals(s2, p1.getSpeler());
    }
    
    public void getPosSpelerTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(SpelerType.Aanvaller, p1.getType());
    }
    
    public void setPosSpelerTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setType(SpelerType.Middenvelder);
        assertEquals(SpelerType.Middenvelder, p1.getType());
    }
    
    public void getNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals("Bert", p1.getNaam());
    }
    
    public void setNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setNaam("Peter-Jan");
        assertEquals("Peter-Jan", p1.getNaam());
    }
    
    public void getNummerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(1, p1.getNummer());
    }
    
    public void setNummerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setNummer(8);
        assertEquals(8, p1.getNummer());
    }
    
    public void getAanvallendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(81, p1.getAanvallend());
    }
    
    public void setAanvallendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setAanvallend(89);
        assertEquals(89, p1.getAanvallend());
    }
    
    public void getVerdedigendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(98, p1.getVerdedigend());
    }
    
    public void setVerdedigendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setVerdedigend(65);
        assertEquals(65, p1.getVerdedigend());
    }
    
    public void getUithoudingsvermogenTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(22, p1.getUithoudingsvermogen());
    }
    
    public void setUithoudingsvermogenTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setUithoudingsvermogen(74);
        assertEquals(74, p1.getUithoudingsvermogen());
    }
    
    public void getOffenceZelfdeTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 80, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(80.0, p1.getOffence(), 1e15);
    }
    
    public void getOffenceAnderTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Middenvelder, 10000, 80, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(64.0, p1.getOffence(), 1e15);
    }
    
    public void getDefenceZelfdeTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 90, 80, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(80, p1.getDefense(), 1e15);
    }
    
    public void getDefenceAnderTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Middenvelder, 10000, 90, 80, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(64.0, p1.getDefense(), 1e15);
    }
    
    public void getTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        assertEquals(SpelerType.Aanvaller, p1.getType());
    }
    
    public void setTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        p1.setType(SpelerType.Verdediger);
    }
   
    public void getPrijsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(10000, p1.getPrijs());
    }
    
    public void setPrijsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setPrijs(2);
        assertEquals(2, p1.getPrijs());
    }
    
    public void setStatusNotNullTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setStatus(SpelerStatus.Normaal);
        assertNotNull(p1.getStatus());
    }
    
    public void setStatusMetWaardenTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setStatus(SpelerStatus.Gele_kaart);
        assertEquals(SpelerStatus.Gele_kaart, p1.getStatus());
    }
    
    public void getStatusTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setStatus(SpelerStatus.Gele_kaart);
        assertEquals(SpelerStatus.Gele_kaart, p1.getStatus());
    }
    
    public void equalsGelijkeSpelersTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        boolean actual = p1.equals(p2);
        assertEquals(true, actual);
    }
    
    public void equalsVerschillendeSpelersTest() {
        Speler s1 = new Speler("Jan", 1, SpelerType.Middenvelder, 30, 62, 45, 99);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        boolean actual = p1.equals(p2);
        assertEquals(false, actual);
    }
}
