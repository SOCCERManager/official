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
import soccer.SpelerStatus;
import soccer.SpelerType;

/**
 *
 * @author Nils
 */
public class SpelerStatusTest {
    
    Speler s1;
    Speler s2;
    @Before
    public void setUp() {
        s1 = new Speler("Adriaan", 1, SpelerType.Aanvaller, 10, 80, 20, 10);
        s2 = new Speler("Bernard", 2, SpelerType.Verdediger, 20, 20, 80, 10);
        s1.setStatus(SpelerStatus.Normaal);
        s1.setStatus(SpelerStatus.Geblesseerd);
    }
    
    @After
    public void tearDown() {
        s1 = null;
        s2 = null;
    }
    
    @Test
    public void valueOfTest() {
        assertEquals(SpelerStatus.Normaal, SpelerStatus.valueOf("Normaal"));
        assertEquals(SpelerStatus.Gele_kaart, SpelerStatus.valueOf("Gele_kaart"));
        assertEquals(SpelerStatus.Rode_kaart, SpelerStatus.valueOf("Rode_kaart"));
        assertEquals(SpelerStatus.Geblesseerd, SpelerStatus.valueOf("Gebleseerd"));
    }
}
