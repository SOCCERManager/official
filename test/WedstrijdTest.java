/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;

/**
 *
 * @author floris
 */
public class WedstrijdTest {
    
    private Team t1;
    private Team t2;
    private Wedstrijd we;
    
    @Before
    public void setUp() {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Speler s2 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p2 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp2 = new ArrayList<PosPlayer>();
        pp2.add(p2);
        sp2.add(s2);
        
        this.t1 = new Team(sp1, "TeamA", pp, null, 50000);
        this.t2 = new Team(sp2, "TeamB", pp, null, 50000);
        this.we = new Wedstrijd(t1,t2);
    }
    
    @After
    public void tearDown() {
        t1 = null;
        t2 = null;
        we = null;
    }
    
    @Test
    public void WedstrijdTest() {
        assertTrue(we.getTeam_a().equals(t1));
        assertTrue(we.getTeam_b().equals(t2));
    }
    
    @Test
    public void getTeam_aTest(){
        assertTrue(we.getTeam_a().equals(t1));
    }
    
    @Test
    public void RndTest(){
        Random rnd = new Random();
        we.setRnd(rnd);
        assertEquals(rnd, we.getRnd());
    }
    
    @Test
    public void setTeam_aTest(){
        we = new Wedstrijd(null,t2);
        we.setTeam_a(t1);
        
        assertTrue(we.getTeam_a().equals(t1));
    }
    
    @Test
    public void getTeam_bTest(){
        assertTrue(we.getTeam_b().equals(t2));
    }
    
    @Test
    public void setTeam_bTest(){
        Wedstrijd we = new Wedstrijd(t1,null);
        we.setTeam_b(t2);
        
        assertTrue(we.getTeam_b().equals(t2));
    }
    
    @Test
    public void getScore_aTest(){
        Wedstrijd we = new Wedstrijd(t1,t2);
        we.setScore_a(5);
        assertTrue(we.getScore_a() == 5);
    }
    
    @Test
    public void setScore_aTest(){
        we.setScore_a(5);
        assertTrue(we.getScore_a() == 5);
    }
    
    @Test
    public void getScore_bTest(){
        we.setScore_b(5);
        assertTrue(we.getScore_b() == 5);
    }
    
    @Test
    public void setScore_bTest(){
        we.setScore_b(5);
        assertTrue(we.getScore_b() == 5);
    }
    
    @Test
    public void getPoints_aTest(){
        we.setPoints_a(5);
        assertTrue(we.getPoints_a() == 5);
    }
    
    @Test
    public void setPoints_aTest(){
        we.setPoints_a(5);
        assertTrue(we.getPoints_a() == 5);
    }
    
    @Test
    public void getPoints_bTest(){
        we.setPoints_b(5);
        assertTrue(we.getPoints_b() == 5);
    }
    
    @Test
    public void setPoints_bTest(){
        we.setPoints_b(5);
        assertTrue(we.getPoints_b() == 5);
    }
    
    @Test
    public void isPlayedTest(){
        assertFalse(we.isPlayed());
    }
    
    @Test
    public void setPlayedTest(){
        we.setPlayed(true);
        assertTrue(we.isPlayed());
    }
    
    @Test
    public void scoreOfTeamATest(){
        we.setPoints_a(5);
        assertTrue(we.scoreOfTeam(t1) == 5);
    }
    
    @Test
    public void scoreOfTeamBTest(){
        we.setPoints_b(3);
        System.out.println(we);
        assertTrue(we.scoreOfTeam(t2) == 3);
    }
    
    @Test
    public void scoreOfTeamNoTeamTest() {
        Speler s3 = new Speler("C", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Aanvaller);
        ArrayList<Speler> sp3 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp3 = new ArrayList<PosPlayer>();
        pp3.add(p3);
        sp3.add(s3);
        Team t3 = new Team(sp3, "NoTeam", pp3, null, 555455);
        assertEquals(0, we.scoreOfTeam(t3));
    }
    
    @Test
    public void equalsNull() {
        assertFalse(we.equals(null));
    }
    
    @Test
    public void equalsString() {
        assertFalse(we.equals("test"));
    }
    
    @Test
    public void equalsWeTeamA() {
        Wedstrijd wf = new Wedstrijd(t2, t2);
        assertFalse(we.equals(wf));
    }
    
    @Test
    public void equalsWeTeamB() {
        Wedstrijd wf = new Wedstrijd(t1, t1);
        assertFalse(we.equals(wf));
    }
    
    @Test
    public void equalsWeScoreA() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        wf.setScore_a(1);
        assertFalse(we.equals(wf));
    }
    
    @Test
    public void equalsWeScoreB() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        wf.setScore_b(1);
        assertFalse(we.equals(wf));
    }
    
    @Test
    public void equalsWePointsA() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        wf.setPoints_a(1);
        assertFalse(we.equals(wf));
    }
     
   @Test
    public void equalsWePointsB() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        wf.setPoints_b(1);
        assertFalse(we.equals(wf));
    }
    
    @Test
    public void equalsWePlayed() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        wf.setPlayed(true);
        assertFalse(we.equals(wf));
    }
    
    @Test
    public void equalsWeTrue() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        assertTrue(we.equals(wf));
    }
    
    @Test
    public void playGameWn() {
        we.setRnd(new Random((long) 1.0));
        we.playGame();
        assertEquals(3, we.getPoints_a());
        assertEquals(0, we.getPoints_b());
    }
    
    @Test
    public void playGameEq() {
        we.setRnd(new Random((long) 109));
        we.playGame();
        assertEquals(1, we.getPoints_a());
        assertEquals(1, we.getPoints_b());
    }
    
    @Test
    public void playGameLs(){
        we.setRnd(new Random((long) 2.0));
        we.playGame();
        assertEquals(0, we.getPoints_a());
        assertEquals(3, we.getPoints_b());
    }
}
