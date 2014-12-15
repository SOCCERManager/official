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
    
    @Test
    public void constructorTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 92, 58);
        assertNotNull(s1);
    }
    
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
    
    @Test
    public void getEnSetStatus() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setStatus(SpelerStatus.Normaal);
        assertNotNull(s1.getStatus());
        assertEquals(SpelerStatus.Normaal, s1.getStatus());
    }
    
    @Test
    public void equalsGelijkTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(true, s1.equals(s2));
    }
    
    @Test
    public void equalsNullTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = null;
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsNummerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 4, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsSpelerTypeTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Verdediger, 10000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsPrijsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 50000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsAttackStatTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 89, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test 
    public void equalsDefenceStatTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 59, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsUithoudingStatTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 59);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Antoine", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        assertEquals(false, s1.equals(s2));
    }
    
    @Test
    public void equalsNotSpelerTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        String naam = "Henk";
        assertEquals(false, s1.equals(naam));
    }
    
    @Test
    public void isAvailableToPlayTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.isAvaliableToPlay();
        assertEquals(true, s1.isAvaliableToPlay());
    }
    
    @Test
    public void isUnavailableToPlayTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.isAvaliableToPlay();
        assertEquals(false, s1.isUnavaliableToPlay());
    }
    
    @Test
    public void getGamesTillStatusDissappearsTest() {
       Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
       s1.setGamesTilStatusDisapears(2);
       assertEquals(2, s1.getGamesTilStatusDisapears());
    }
    
    @Test
    public void getEnSetRndTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Random rnd = new Random();
        s1.setRnd(rnd);
        assertEquals(rnd, s1.getRnd());
    }
    
    @Test
    public void equalsOngelijkeStatusTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setStatus(SpelerStatus.Normaal);
        s2.setStatus(SpelerStatus.Gele_kaart);
        assertFalse(s1.equals(s2));
    }
    
    @Test
    public void equalsOngelijkeGamesTillStatusDissappearsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setGamesTilStatusDisapears(2);
        s2.setGamesTilStatusDisapears(9);
        assertFalse(s1.equals(s2));
    }
    
    @Test
    public void playGame2GamesTillStatusDissappearsTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setGamesTilStatusDisapears(2);
        s1.playGame();
        assertEquals(1, s1.getGamesTilStatusDisapears());
    }
    
    @Test
    public void magicalyFixTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        s1.setGamesTilStatusDisapears(2);
        s1.setStatus(SpelerStatus.Gebleseerd);
        s1.magicalyFix();
        assertEquals(0, s1.getGamesTilStatusDisapears());
        assertEquals(SpelerStatus.Normaal, s1.getStatus());
    }
}