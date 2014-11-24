/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.*;
import org.junit.Test;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerStatus;
import soccer.SpelerType;

/**
 * 
 * @author Nils
 */
public class PosPlayerTest {
    @Test
    public void ConstructorTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertNotNull(p1);
    }
    @Test
    public void getSpelerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s2, SpelerType.Aanvaller);
        assertTrue(s1.equals(p1.getSpeler()));
    }
    @Test
    public void setSpelerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Alfred", 68, SpelerType.Middenvelder, 50000, 98, 21, 3);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setSpeler(s2);
        assertTrue(s2.equals(p1.getSpeler()));
    }
    @Test
    public void getPosSpelerTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(SpelerType.Aanvaller, p1.getType());
    }
    @Test
    public void setPosSpelerTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setType(SpelerType.Middenvelder);
        assertEquals(SpelerType.Middenvelder, p1.getType());
    }
    @Test
    public void getNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals("Bert", p1.getNaam());
    }
    @Test
    public void setNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setNaam("Peter-Jan");
        assertEquals("Peter-Jan", p1.getNaam());
    }
    @Test
    public void getNummerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(1, p1.getNummer());
    }
    @Test
    public void setNummerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setNummer(8);
        assertEquals(8, p1.getNummer());
    }
    @Test
    public void getAanvallendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(81, p1.getAanvallend());
    }
    @Test
    public void setAanvallendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setAanvallend(89);
        assertEquals(89, p1.getAanvallend());
    }
    @Test
    public void getVerdedigendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(98, p1.getVerdedigend());
    }
    @Test
    public void setVerdedigendTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setVerdedigend(65);
        assertEquals(65, p1.getVerdedigend());
    }
    @Test
    public void getUithoudingsvermogenTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(22, p1.getUithoudingsvermogen());
    }
    @Test
    public void setUithoudingsvermogenTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setUithoudingsvermogen(74);
        assertEquals(74, p1.getUithoudingsvermogen());
    }
    @Test
    public void getOffenceZelfdeTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 80, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(80.0, p1.getOffence(), 1e15);
    }
    @Test
    public void getOffenceAnderTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Middenvelder, 10000, 80, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(64.0, p1.getOffence(), 1e15);
    }
    @Test
    public void getDefenceZelfdeTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 90, 80, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(80, p1.getDefense(), 1e15);
    }
    @Test
    public void getDefenceAnderTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Middenvelder, 10000, 90, 80, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(64.0, p1.getDefense(), 1e15);
    }
    @Test
    public void getTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        assertEquals(SpelerType.Aanvaller, p1.getType());
    }
    @Test
    public void setTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        p1.setType(SpelerType.Verdediger);
    }
   @Test
    public void getPrijsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        assertEquals(10000, p1.getPrijs());
    }
    @Test
    public void setPrijsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setPrijs(2);
        assertEquals(2, p1.getPrijs());
    }
    @Test
    public void setStatusNotNullTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setStatus(SpelerStatus.Normaal);
        assertNotNull(p1.getStatus());
    }
    @Test
    public void setStatusMetWaardenTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setStatus(SpelerStatus.Gele_kaart);
        assertEquals(SpelerStatus.Gele_kaart, p1.getStatus());
    }
    @Test
    public void getStatusTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        p1.setStatus(SpelerStatus.Gele_kaart);
        assertEquals(SpelerStatus.Gele_kaart, p1.getStatus());
    }
    @Test
    public void equalsGelijkeSpelersTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        assertTrue(p1.equals(p2));
    }
    @Test
    public void equalsVerschillendeSpelersTest() {
        Speler s1 = new Speler("Jan", 1, SpelerType.Middenvelder, 30, 62, 45, 99);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        boolean actual = p1.equals(p2);
        assertEquals(false, actual);
    }
}
