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
import soccer.Competitie;
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
    private Wedstrijd w8;
    
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
        this.w8 = new Wedstrijd(t1,t2);
        we.setPlayed(true);
    }
    
    @After
    public void tearDown() {
        t1 = null;
        t2 = null;
        we = null;
        w8 = null;
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
        assertTrue(we.isPlayed());
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
        assertTrue(we.equals(wf));
    }
    
    @Test
    public void equalsWeTrue() {
        Wedstrijd wf = new Wedstrijd(t1, t2);
        wf.setPlayed(true);
        assertTrue(we.equals(wf));
    }
    
    @Test
    public void teamWonATrueTest() {
        we.setPoints_a(3);
        we.setPoints_b(0);
        assertTrue(we.teamWon(t1));
    }
    
    @Test
    public void teamWonBTrueTest() {
        we.setPoints_a(0);
        we.setPoints_b(3);
        assertTrue(we.teamWon(t2));
    }
    
    @Test
    public void teamWonAFalseTest() {
        we.setPoints_a(0);
        we.setPoints_b(3);
        
    }
    @Test
    public void teamWonBFalseTest() {
        we.setPoints_a(3);
        we.setPoints_b(0);
        assertFalse(we.teamWon(t2));
    }
    
    @Test
    public void teamWonGeenTeamTest() {
        Team t3 = new Team(null, null, null, null, 1);
        we.setPoints_a(3);
        we.setPoints_b(0);
        assertFalse(we.teamWon(t3));
    }
    
    @Test
    public void teamLostTrueTest() {
        we.setPoints_a(0);
        we.setPoints_b(3);
        assertTrue(we.teamLost(t1));
    }
    
    @Test
    public void teamLostFalseTest() {
        we.setPoints_a(0);
        we.setPoints_b(3);
        assertFalse(we.teamLost(t2));
    }
    
    @Test
    public void teamLostGeenTeamTest() {
        Team t3 = new Team(null, null, null, null, 0);
        we.setPoints_a(3);
        we.setPoints_b(0);
        assertFalse(we.teamLost(t3));
    }
    
    @Test
    public void teamDrawedATrueTest() {
        we.setPoints_a(1);
        we.setPoints_b(0);
        assertTrue(we.teamDrawed(t1));
    }
    
    @Test
    public void teamDrawedBTrueTest() {
        we.setPoints_a(0);
        we.setPoints_b(1);
        assertTrue(we.teamDrawed(t2));
    }
    
    @Test
    public void teamDrawedAFalseTest() {
        we.setPoints_a(0);
        we.setPoints_b(1);
        assertFalse(we.teamDrawed(t1));
    }
    
    @Test
    public void teamDrawedBFalseTest() {
        we.setPoints_a(1);
        we.setPoints_b(0);
        assertFalse(we.teamDrawed(t2));
    }
    
    @Test
    public void teamDrawedGeenTeamTest() {
        Team t3 = new Team(null, null, null, null, 0);
        we.setPoints_a(3);
        we.setPoints_b(0);
        assertFalse(we.teamDrawed(t3));
    }
    
    @Test
    public void teamPlayedTrueTest() {
        assertTrue(we.teamPlayed(t1));
    }
    
    @Test
    public void teamPlayedFalseTest() {
        Team t3 = new Team(null, null, null, null, 50);
        assertFalse(we.teamPlayed(t3));
    }
    
    @Test
    public void teamGoalTeamATest() {
        we.setScore_a(3);
        we.setScore_b(1);
        assertEquals(3, we.teamGoal(t1));
    }
    
    @Test
    public void teamGoalTeamBTest() {
        we.setScore_a(3);
        we.setScore_b(1);
        assertEquals(1, we.teamGoal(t2));
    }
    
    @Test
    public void teamGoalTeamBuitenWedstrijdTest() {
        Team t3 = new Team(null, null, null, null, 50);
        we.setScore_a(3);
        we.setScore_b(1);
        assertEquals(0, we.teamGoal(t3));
    }
    
    @Test
    public void teamCounterGoalTeamATest() {
        we.setScore_a(3);
        we.setScore_b(1);
        assertEquals(1, we.teamCounterGoal(t1));
    }
    
    @Test
    public void teamCounterGoalTeamBTest() {
        we.setScore_a(3);
        we.setScore_b(1);
        assertEquals(3, we.teamCounterGoal(t2));
    }
    
    @Test
    public void teamCounterGoalTeamBuitenWedstrijdTest() {
        Team t3 = new Team(null, null, null, null, 50);
        we.setScore_a(3);
        we.setScore_b(1);
        assertEquals(0, we.teamCounterGoal(t3));
    }
    
    @Test
    public void equalsNotPlayedTest() {
        assertFalse(w8.equals(we));
    }   
    
    @Test
    public void playGameDraw() {
        ArrayList<Speler> spellijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        Speler s1 = new Speler("Albert", 1, SpelerType.Aanvaller, 500, 70, 70, 70);
        Speler s3 = new Speler("Chris", 3, SpelerType.Doelman, 500, 70, 70, 70);
        Speler s4 = new Speler("Dirk", 4, SpelerType.Verdediger, 500, 70, 70, 70);
        Speler s5 = new Speler("Erik", 5, SpelerType.Verdediger, 500, 70, 70, 70);
        Speler s6 = new Speler("Frits", 6, SpelerType.Verdediger, 500, 70, 70, 70);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Verdediger, 500, 70, 70, 70);
        Speler s8 = new Speler("Henk", 8, SpelerType.Middenvelder, 500, 70, 70, 70);
        Speler s9 = new Speler("Adriaan", 9, SpelerType.Middenvelder, 500, 70, 70, 70);
        Speler s10 = new Speler("Adriaan", 10, SpelerType.Middenvelder, 500, 70, 70, 70);
        Speler s11 = new Speler("Adriaan", 11, SpelerType.Aanvaller, 500, 70, 70, 70);
        Speler s12 = new Speler("Adriaan", 12, SpelerType.Aanvaller, 500, 70, 70, 70);
        spellijst.add(s1);
        spellijst.add(s3);
        spellijst.add(s4);
        spellijst.add(s5);
        spellijst.add(s6);
        spellijst.add(s7);
        spellijst.add(s8);
        spellijst.add(s9);
        spellijst.add(s10);
        spellijst.add(s11);
        spellijst.add(s12);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Doelman);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Verdediger);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Verdediger);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Middenvelder);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Middenvelder);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Middenvelder);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Aanvaller);
        PosPlayer p12 = new PosPlayer(s12, SpelerType.Aanvaller);
        posities.add(p1);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        posities.add(p12); 
        Team t56 = new Team(spellijst, "Team1", posities, null, 500000);
        Team t57 = new Team(spellijst, "Team2", posities, null, 500000);
        teamlijst.add(t56);
        teamlijst.add(t57);
        Competitie c = new Competitie(null, teamlijst);
        c.setUserindex(0);
        t56.setCompetitie(c);
        t57.setCompetitie(c);
        Wedstrijd w87 = new Wedstrijd(t56, t57);
        soccer.Random.get().setSeed(45);
        w87.playGame();
        assertTrue(1==w87.getScore_a());
        assertTrue(1==w87.getScore_b());
        assertTrue(1==w87.getPoints_a());
        assertTrue(1==w87.getPoints_b());
        soccer.Random.get().setSeed(0);
    }
    
    @Test
    public void playGameA0PuntenTest(){
        ArrayList<Speler> spellijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        Speler s1 = new Speler("Albert", 1, SpelerType.Aanvaller, 500, 0, 0, 0);
        Speler s3 = new Speler("Chris", 3, SpelerType.Doelman, 500, 0, 0, 0);
        Speler s4 = new Speler("Dirk", 4, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s5 = new Speler("Erik", 5, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s6 = new Speler("Frits", 6, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s8 = new Speler("Henk", 8, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s9 = new Speler("Adriaan", 9, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s10 = new Speler("Adriaan", 10, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s11 = new Speler("Adriaan", 11, SpelerType.Aanvaller, 500, 0, 0, 0);
        Speler s12 = new Speler("Adriaan", 12, SpelerType.Aanvaller, 500, 0, 0, 0);
        spellijst.add(s1);
        spellijst.add(s3);
        spellijst.add(s4);
        spellijst.add(s5);
        spellijst.add(s6);
        spellijst.add(s7);
        spellijst.add(s8);
        spellijst.add(s9);
        spellijst.add(s10);
        spellijst.add(s11);
        spellijst.add(s12);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Doelman);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Verdediger);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Verdediger);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Middenvelder);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Middenvelder);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Middenvelder);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Aanvaller);
        PosPlayer p12 = new PosPlayer(s12, SpelerType.Aanvaller);
        posities.add(p1);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        posities.add(p12); 
        Team t56 = new Team(spellijst, "Team1", posities, null, 500000);
        Team t57 = new Team(spellijst, "Team2", posities, null, 500000);
        for(int i = 0; i<spellijst.size(); i++) {
            t57.getSpelers().get(i).setAanvallend(100);
        }
        teamlijst.add(t56);
        teamlijst.add(t57);
        Competitie c = new Competitie(null, teamlijst);
        c.setUserindex(0);
        t56.setCompetitie(c);
        t57.setCompetitie(c);
        Wedstrijd w87 = new Wedstrijd(t56, t57);
        soccer.Random.get().setSeed(15);
        w87.playGame();
        assertTrue(0==w87.getPoints_a());
        assertTrue(3==w87.getPoints_b());
    }
    @Test
    public void playGameB0PuntenTest() { 
        ArrayList<Speler> spellijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        Speler s1 = new Speler("Albert", 1, SpelerType.Aanvaller, 500, 0, 0, 0);
        Speler s3 = new Speler("Chris", 3, SpelerType.Doelman, 500, 0, 0, 0);
        Speler s4 = new Speler("Dirk", 4, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s5 = new Speler("Erik", 5, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s6 = new Speler("Frits", 6, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s8 = new Speler("Henk", 8, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s9 = new Speler("Adriaan", 9, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s10 = new Speler("Adriaan", 10, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s11 = new Speler("Adriaan", 11, SpelerType.Aanvaller, 500, 0, 0, 0);
        Speler s12 = new Speler("Adriaan", 12, SpelerType.Aanvaller, 500, 0, 0, 0);
        spellijst.add(s1);
        spellijst.add(s3);
        spellijst.add(s4);
        spellijst.add(s5);
        spellijst.add(s6);
        spellijst.add(s7);
        spellijst.add(s8);
        spellijst.add(s9);
        spellijst.add(s10);
        spellijst.add(s11);
        spellijst.add(s12);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Doelman);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Verdediger);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Verdediger);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Middenvelder);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Middenvelder);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Middenvelder);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Aanvaller);
        PosPlayer p12 = new PosPlayer(s12, SpelerType.Aanvaller);
        posities.add(p1);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        posities.add(p12); 
        Team A = new Team(spellijst, "Team1", posities, null, 500000);
        Team B = new Team(spellijst, "Team2", posities, null, 500000);
        for(int i = 0; i<spellijst.size(); i++) {
            A.getSpelers().get(i).setUithoudingsvermogen(50);
            A.getSpelers().get(i).setVerdedigend(100);
            A.getSpelers().get(i).setAanvallend(100);
        }
        teamlijst.add(A);
        teamlijst.add(B);
        Competitie c = new Competitie(null, teamlijst);
        c.setUserindex(0);
        A.setCompetitie(c);
        B.setCompetitie(c);
        Wedstrijd w87 = new Wedstrijd(A, B);
        soccer.Random.get().setSeed(59);
        w87.playGame();
        assertTrue(3==w87.getPoints_a());
        assertTrue(0==w87.getPoints_b());
    }
    
    @Test
    public void playGame0GoalsTest() { 
        ArrayList<Speler> spellijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        Speler s1 = new Speler("Albert", 1, SpelerType.Aanvaller, 500, 0, 0, 0);
        Speler s3 = new Speler("Chris", 3, SpelerType.Doelman, 500, 0, 0, 0);
        Speler s4 = new Speler("Dirk", 4, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s5 = new Speler("Erik", 5, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s6 = new Speler("Frits", 6, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Verdediger, 500, 0, 0, 0);
        Speler s8 = new Speler("Henk", 8, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s9 = new Speler("Adriaan", 9, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s10 = new Speler("Adriaan", 10, SpelerType.Middenvelder, 500, 0, 0, 0);
        Speler s11 = new Speler("Adriaan", 11, SpelerType.Aanvaller, 500, 0, 0, 0);
        Speler s12 = new Speler("Adriaan", 12, SpelerType.Aanvaller, 500, 0, 0, 0);
        spellijst.add(s1);
        spellijst.add(s3);
        spellijst.add(s4);
        spellijst.add(s5);
        spellijst.add(s6);
        spellijst.add(s7);
        spellijst.add(s8);
        spellijst.add(s9);
        spellijst.add(s10);
        spellijst.add(s11);
        spellijst.add(s12);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Doelman);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Verdediger);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Verdediger);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Middenvelder);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Middenvelder);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Middenvelder);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Aanvaller);
        PosPlayer p12 = new PosPlayer(s12, SpelerType.Aanvaller);
        posities.add(p1);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        posities.add(p12); 
        Team t56 = new Team(spellijst, "Team1", posities, null, 500000);
        Team t57 = new Team(spellijst, "Team2", posities, null, 500000);
        for(int i = 0; i<spellijst.size(); i++) {
            t56.getSpelers().get(i).setVerdedigend(100);
        }
        teamlijst.add(t56);
        teamlijst.add(t57);
        Competitie c = new Competitie(null, teamlijst);
        c.setUserindex(0);
        t56.setCompetitie(c);
        t57.setCompetitie(c);
        Wedstrijd w87 = new Wedstrijd(t56, t57);
        soccer.Random.get().setSeed(15);
        w87.playGame();
        assertTrue(1==w87.getPoints_a());
        assertTrue(1==w87.getPoints_b());
    }
    
    @Test
    public void getEnSetSpeeldagTest() {
        we.setSpeeldag(1);
        assertTrue(we.getSpeeldag()==1);
    }
}
