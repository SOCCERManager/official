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
import soccer.Speler;
import soccer.SpelerType;

/**
 *
 * @author Nils
 */
public class SpelerTest {
    
    @Test
    public void getNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals("Bert", s1.getNaam());
    }
    
    @Test
    public void setNaamTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setNaam("Alexander");
        assertEquals("Alexander", s1.getNaam());
    }
    
    @Test
    public void getNummerTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(1, s1.getNummer());
    }
    
    @Test
    public void setNummerTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setNummer(98);
        assertEquals(98, s1.getNummer());
    }
    
    @Test
    public void getTypeTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(SpelerType.Aanvaller, s1.getType());
    }
    
    @Test
    public void setTypeTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setType(SpelerType.Middenvelder);
        assertEquals(SpelerType.Middenvelder, s1.getType());
    }
    
    @Test
    public void getAanvallendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(81, s1.getAanvallend());
    }
    
    @Test
    public void setAanvallendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setAanvallend(3);
        assertEquals(3, s1.getAanvallend());
    }
    
    @Test
    public void getVerdedigendTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(98, s1.getVerdedigend());
    }
    
    @Test
    public void setVerdedigendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setVerdedigend(2);
        assertEquals(2, s1.getVerdedigend());
    }
    
    @Test
    public void getUithoudingsvermogenTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(22, s1.getUithoudingsvermogen());
    }
    
    @Test
    public void setUithoudingsvermogenTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setUithoudingsvermogen(98);
        assertEquals(98, s1.getUithoudingsvermogen());
    }
    
    @Test
    public void getPrijsTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(10000, s1.getPrijs());
    }
    
    @Test
    public void setPrijsTest(){
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setPrijs(5);
        assertEquals(5, s1.getPrijs());
    }
}
