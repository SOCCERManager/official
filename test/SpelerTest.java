/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
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
public class SpelerTest {
    Speler s1;
    
    @Before
    public void setUp() {
        s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 71);
    }
    
    
    @After
    public void tearDown() {
        s1 = null;
    }
    
    @Test
    public void constructorTest() {
        assertNotNull(s1);
    }
    
    @Test
    public void getNaamTest() {
        assertEquals("Bert", s1.getNaam());
    }
    
    @Test
    public void setNaamTest() {
        s1.setNaam("Alexander");
        assertEquals("Alexander", s1.getNaam());
    }
    
    @Test
    public void getNummerTest(){
        assertEquals(1, s1.getNummer());
    }
    
    @Test
    public void setNummerTest(){
        s1.setNummer(98);
        assertEquals(98, s1.getNummer());
    }
    
    @Test
    public void getTypeTest(){
        assertEquals(SpelerType.Aanvaller, s1.getType());
    }
    
    @Test
    public void setTypeTest(){
        s1.setType(SpelerType.Middenvelder);
        assertEquals(SpelerType.Middenvelder, s1.getType());
    }
    
    @Test
    public void getAanvallendTest() {
        assertEquals(100, s1.getAanvallend());
    }
    
    @Test
    public void setAanvallendTest() {
        s1.setAanvallend(3);
        assertEquals(23, s1.getAanvallend());
    }
    
    @Test
    public void getVerdedigendTest(){
        assertEquals(78, s1.getVerdedigend());
    }
    
    @Test
    public void setVerdedigendTest() {
        s1.setVerdedigend(2);
        assertEquals(0, s1.getVerdedigend());
    }
    
    @Test
    public void getUithoudingsvermogenTest(){
        assertEquals(51, s1.getUithoudingsvermogen());
    }
    
    @Test
    public void setUithoudingsvermogenTest(){
        s1.setUithoudingsvermogen(98);
        assertEquals(78, s1.getUithoudingsvermogen());
    }
    
    @Test
    public void getPrijsTest(){
        assertEquals(10000, s1.getPrijs());
    }
    
    @Test
    public void setPrijsTest(){
        s1.setPrijs(5);
        assertEquals(5, s1.getPrijs());
    }
    
    @Test
    public void getEnSetStatus() {
        s1.setStatus(SpelerStatus.Normaal);
        assertNotNull(s1.getStatus());
        assertEquals(SpelerStatus.Normaal, s1.getStatus());
    }
    
    @Test
    public void defineMarketValueAanvTest(){
        assertTrue(s1.defineMarketValue()== 934000);
    }
    
    @Test
    public void equalsGelijkTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 71);
        assertEquals(true, s1.equals(s2));
    }
    
    @Test
    public void equalsNullTest() {
        Speler s2 = null;
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsNummerTest() {
        Speler s2 = new Speler("Bert", 4, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsSpelerTypeTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Verdediger, 10000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsPrijsTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 50000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsAttackStatTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 89, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test 
    public void equalsDefenceStatTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 59, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsUithoudingStatTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 59);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsNaamTest() {
        Speler s2 = new Speler("Antoine", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsNotSpelerTest() {
        String naam = "Henk";
        assertEquals(false, s1.equals(naam));
    }
    
    @Test
    public void isAvailableToPlayTest() {
        s1.isAvaliableToPlay();
        assertEquals(true, s1.isAvaliableToPlay());
    }
    
    @Test
    public void isUnavailableToPlayTest() {
        s1.isAvaliableToPlay();
        assertEquals(false, s1.isUnavaliableToPlay());
    }
    
    @Test
    public void getGamesTillStatusDissappearsTest() {
       s1.setGamesTilStatusDisapears(2);
       assertEquals(2, s1.getGamesTilStatusDisapears());
    }
    
    @Test
    public void equalsOngelijkeStatusTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setStatus(SpelerStatus.Normaal);
        s2.setStatus(SpelerStatus.Gele_kaart);
        assertFalse(s1.equals(s2));
    }
    
    @Test
    public void equalsOngelijkeGamesTillStatusDissappearsTest() {
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setGamesTilStatusDisapears(2);
        s2.setGamesTilStatusDisapears(9);
        assertFalse(s1.equals(s2));
    }
    
    @Test
    public void magicalyFixTest() {
        s1.setGamesTilStatusDisapears(2);
        s1.setStatus(SpelerStatus.Geblesseerd);
        s1.magicalyFix();
        assertEquals(0, s1.getGamesTilStatusDisapears());
        assertEquals(SpelerStatus.Normaal, s1.getStatus());
    }
    
    @Test
    public void playGameGamesTillStatusDissappears2Test() {
        s1.setGamesTilStatusDisapears(2);
        s1.playGame();
        assertEquals(1, s1.getGamesTilStatusDisapears());
    }
    
    @Test
    public void playGameGamesTillStatusDissappears0Test() {
        s1.setGamesTilStatusDisapears(0);
        soccer.Random.get().setSeed(0);
        s1.playGame();
        assertEquals(SpelerStatus.Normaal, s1.getStatus());

    }
    
    @Test
    public void playGameGamesTillStatusDissappears1Test() {
        s1.setStatus(SpelerStatus.Geblesseerd);
        s1.setGamesTilStatusDisapears(1);
        s1.playGame();
        assertEquals(SpelerStatus.Normaal, s1.getStatus());

    }
    
    
    @Test
    public void playGameTestGeblesserd() {
        soccer.Random.get().setSeed(8419);
        s1.playGame();
        assertEquals(SpelerStatus.Geblesseerd, s1.getStatus());
    }
    
    @Test
    public void playGameTestGelekaart() {
        soccer.Random.get().setSeed(8781);
        s1.playGame();
        System.out.println("STATUS GELE KAART: " + s1.getStatus());
        assertEquals(SpelerStatus.Gele_kaart, s1.getStatus());
    }
    
    @Test
    public void playGameTestRodekaart() {
        soccer.Random.get().setSeed(8690);
        s1.playGame();
        System.out.println("STATUS RODE KAART: " + s1.getStatus());
        assertEquals(SpelerStatus.Rode_kaart, s1.getStatus());
    }
    
    @Test
    public void defineMarketValueVerdTest() {
        s1.setType(SpelerType.Verdediger);
        assertTrue(s1.defineMarketValue()==816000);
    }
    
    @Test
    public void defineMarketValueMidTest() {
        s1.setType(SpelerType.Middenvelder);
        assertTrue(s1.defineMarketValue()==904000);
    }
    
    @Test
    public void randomWithRangeNotNullTest() {
        Random r1 = new Random((long) 5);
        s1.playGame();
    }
    
    @Test
    public void randomWithRangeNullTest() {
        s1.playGame();
    }
    
    @Test
    public void defineMarketValueBadAanvTest() {
        s1.setAanvallend(9);
        s1.setType(SpelerType.Aanvaller);
        assertTrue(95000==s1.defineMarketValue());
    }
    
    @Test
    public void defineMarketValueBadMidTest() {
        s1.setUithoudingsvermogen(7);
        s1.setType(SpelerType.Middenvelder);
        assertTrue(105000==s1.defineMarketValue());
    }
    
    @Test
    public void defineMarketValueBadVerdTest() {
        s1.setVerdedigend(6);
        s1.setType(SpelerType.Verdediger);
        assertTrue(69000==s1.defineMarketValue());
    }
}