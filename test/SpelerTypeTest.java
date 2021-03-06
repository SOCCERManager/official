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
public class SpelerTypeTest {
    
    Speler s1;
    Speler s2;
    
    @Before
    public void setUp() {
        s1 = new Speler("Adriaan", 1, SpelerType.Aanvaller, 10, 80, 20, 10);
        s2 = new Speler("Bernard", 2, SpelerType.Verdediger, 20, 20, 80, 10);
    }
    
    @After
    public void tearDown() {
        s1 = null;
        s2 = null;
    }
    
    @Test
    public void valueOfTest() {
        assertEquals(SpelerType.Doelman, SpelerType.valueOf("Doelman"));
        assertEquals(SpelerType.Verdediger, SpelerType.valueOf("Verdediger"));
        assertEquals(SpelerType.Middenvelder, SpelerType.valueOf("Middenvelder"));
        assertEquals(SpelerType.Aanvaller, SpelerType.valueOf("Aanvaller"));
    }
}
