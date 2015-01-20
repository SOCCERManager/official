/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;
import soccer.bouwXML;

/**
 *
 * @author floris
 */
public class CompetitieTest {
    
    Competitie c1;
    
    @Before
    public void setUp() {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp1, "Team", pp, null, 50000);
        Team t3 = new Team(sp1, "Team", pp, null, 50000);
        Team t4 = new Team(sp1, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        ta.add(t3);
        ta.add(t4);
        
        Wedstrijd w1 = new Wedstrijd(t1,t2);
        w1.setPlayed(true);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(w1);
        
        c1 = new Competitie(w,ta); 
    }
    
    @After
    public void tearDown() {
        c1 = null;
    }
    
    @Test
    public void getEnSetUserIndexCompareTest() { 
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        c1.setUserindex(5);
        assertEquals(5, c1.getUserindex());
    }
    
    
    @Test
    public void getWedstrijdenTest(){
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        
        assertTrue(c1.getWedstrijden().equals(w));
    }
    
    @Test
    public void setWedstrijdenTest(){
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(null,ta); 
        c1.setWedstrijden(w);
        
        assertTrue(c1.getWedstrijden().equals(w));
    }
    
    @Test
    public void getTeamsTest(){
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        
        assertTrue(c1.getTeams().equals(ta));
    }
    
    @Test
    public void setTeamsTest(){
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,null); 
        c1.setTeams(ta);
        
        assertTrue(c1.getTeams().equals(ta));
    }
    
    @Test
    public void getScoreOfTeamTest(){
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        Wedstrijd we2 = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        w.add(we2);
        w.get(0).setPoints_a(5);
        w.get(1).setPoints_a(6);
        
        Competitie c1 = new Competitie(w,ta); 
        
        assertTrue(c1.getScoreOfTeam(t1) == 11);
    }
    
    @Test
    public void equalsWaarTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        Competitie c2 = new Competitie(w,ta);
        assertTrue(c1.equals(c2));
    }
    
    @Test
    public void equalsNietWaarTest() {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Speler s2 = new Speler("B", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p2 = new PosPlayer(s1, SpelerType.Middenvelder);
        ArrayList<Speler> sp2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp2 = new ArrayList<PosPlayer>();
        pp2.add(p2);
        sp2.add(s1);
        
        ArrayList<Speler> sp3 = new ArrayList<Speler>();
        Speler s3 = new Speler ("D", 45, SpelerType.Verdediger, 50, 50,61,20);
        sp3.add(s3);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        Team t3 = new Team(sp3, "Hallo", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        Wedstrijd wed = new Wedstrijd(t2, t3);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        ArrayList<Wedstrijd> aw = new ArrayList<Wedstrijd>();
        w.add(we);
        aw.add(wed);
        
        
        Competitie c1 = new Competitie(w,ta); 
        Competitie c2 = new Competitie(aw,ta);
        assertFalse(c1.equals(c2));
    }
    
    @Test
    public void equalsNullTest() {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Speler s2 = new Speler("B", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p2 = new PosPlayer(s1, SpelerType.Middenvelder);
        ArrayList<Speler> sp2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp2 = new ArrayList<PosPlayer>();
        pp2.add(p2);
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        Competitie cNull = null;
        
        assertEquals(false, c1.equals(cNull));
    }
    
    @Test
    public void equalsOngelijkeClassesTest() {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Speler s2 = new Speler("B", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p2 = new PosPlayer(s1, SpelerType.Middenvelder);
        ArrayList<Speler> sp2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp2 = new ArrayList<PosPlayer>();
        pp2.add(p2);
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        assertEquals(false, c1.equals(t2));
    }
    
    @Test
    public void toStringTest() {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Speler s2 = new Speler("B", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p2 = new PosPlayer(s1, SpelerType.Middenvelder);
        ArrayList<Speler> sp2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp2 = new ArrayList<PosPlayer>();
        pp2.add(p2);
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp2, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd we = new Wedstrijd(t1,t2);
        we.setPlayed(true);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(we);
        
        Competitie c1 = new Competitie(w,ta); 
        c1.setUserindex(5);
        assertEquals("Competitie{wedstrijden=[Wedstrijd{team_a=Team, team_b=Team, score_a=0, score_b=0, points_a=0, points_b=0, played=true}], teams=[Team{spelers=[Speler{naam=A, nummer=14, type=Aanvaller, status=null, prijs=10, gamesTilStatusDisapears=0, aanvallend=10, verdedigend=10, uithoudingsvermogen=10}], name=Team, opstelling=[PosPlayer{speler=Speler{naam=A, nummer=14, type=Aanvaller, status=null, prijs=10, gamesTilStatusDisapears=0, aanvallend=10, verdedigend=10, uithoudingsvermogen=10}, posspelertype=Aanvaller, reduceFactor=0.8}], budget=50000}, Team{spelers=[Speler{naam=A, nummer=14, type=Aanvaller, status=null, prijs=10, gamesTilStatusDisapears=0, aanvallend=10, verdedigend=10, uithoudingsvermogen=10}], name=Team, opstelling=[PosPlayer{speler=Speler{naam=A, nummer=14, type=Aanvaller, status=null, prijs=10, gamesTilStatusDisapears=0, aanvallend=10, verdedigend=10, uithoudingsvermogen=10}, posspelertype=Aanvaller, reduceFactor=0.8}], budget=50000}], userindex=5}", c1.toString());
    }
    
    @Test
    public void bouwWedstrijdenTest() {
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp1 = new ArrayList<PosPlayer>();
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        pp1.add(p1);
        sp1.add(s1);
        
        
        ArrayList<Speler> sp2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp2 = new ArrayList<PosPlayer>();
        Speler s2 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        pp2.add(p2);
        sp2.add(s2);
        
        ArrayList<Speler> sp3 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp3 = new ArrayList<PosPlayer>();
        Speler s3 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Aanvaller);
        pp3.add(p3);
        sp3.add(s3);
        
        ArrayList<Speler> sp4 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp4 = new ArrayList<PosPlayer>();
        Speler s4 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Aanvaller);
        pp4.add(p4);
        sp4.add(s4);
        
        ArrayList<Speler> sp5 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp5 = new ArrayList<PosPlayer>();
        Speler s5 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Aanvaller);
        pp5.add(p5);
        sp5.add(s5);
        
        ArrayList<Speler> sp6 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp6 = new ArrayList<PosPlayer>();
        Speler s6 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Aanvaller);
        pp6.add(p6);
        sp6.add(s6);
        
        Team t1 = new Team(sp1, "TeamA", pp1, null, 50000);
        Team t2 = new Team(sp2, "TeamB", pp2, null, 50000);
        Team t3 = new Team(sp3, "TeamC", pp3, null, 56666);
        Team t4 = new Team(sp4, "TeamD", pp4, null, 55555);
        Team t5 = new Team(sp5, "TeamE", pp5, null, 99999);
        Team t6 = new Team(sp6, "TeamF", pp6, null, 584612);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        ta.add(t3);
        ta.add(t4);
        ta.add(t5);
        ta.add(t6);
        
        ArrayList<Wedstrijd> wedlijst = new ArrayList<Wedstrijd>();
        
        
        Competitie c1 = new Competitie(wedlijst, ta);
        c1.bouwWedstrijden();
        assertNotNull(c1.getWedstrijden());
    }
    
    
    
    @Test
    public void getWinsOfTeamAantalTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team1", pp, null, 50000);
        Team t2 = new Team(sp2, "Team2", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        Wedstrijd w2 = new Wedstrijd(t1, t2);
        Wedstrijd w3 = new Wedstrijd(t1, t2);
        Wedstrijd w4 = new Wedstrijd(t1, t2);
        w1.setPlayed(true);
        w2.setPlayed(true);
        w3.setPlayed(true);
        w4.setPlayed(true);
        
        w1.setPoints_a(1);
        w1.setPoints_b(1);
        
        w2.setPoints_a(3);
        w2.setPoints_b(0);
        
        w3.setPoints_a(0);
        w3.setPoints_b(3);
        
        w4.setPoints_a(1);
        w4.setPoints_b(1);
        
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        
        Competitie c1 = new Competitie(wlijst, ta);
        assertEquals(1, c1.getWinsOfTeam(t1));
    }
    
    @Test
    public void getDrawsOfTeamTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team1", pp, null, 50000);
        Team t2 = new Team(sp2, "Team2", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        Wedstrijd w2 = new Wedstrijd(t1, t2);
        Wedstrijd w3 = new Wedstrijd(t1, t2);
        Wedstrijd w4 = new Wedstrijd(t1, t2);
        
        w1.setPoints_a(1);
        w1.setPoints_b(1);
        
        w2.setPoints_a(3);
        w2.setPoints_b(0);
        
        w3.setPoints_a(0);
        w3.setPoints_b(3);
        
        w4.setPoints_a(1);
        w4.setPoints_b(1);
        
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        
        Competitie c1 = new Competitie(wlijst, ta);
        assertEquals(2, c1.getDrawsOfTeam(t2));
    }
    
    @Test
    public void getLossesOfTeamTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team1", pp, null, 50000);
        Team t2 = new Team(sp2, "Team2", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        Wedstrijd w2 = new Wedstrijd(t1, t2);
        Wedstrijd w3 = new Wedstrijd(t1, t2);
        Wedstrijd w4 = new Wedstrijd(t1, t2);
        
        w1.setPlayed(true);
        w1.setPoints_a(1);
        w1.setPoints_b(1);
        
        w2.setPlayed(true);
        w2.setPoints_a(3);
        w2.setPoints_b(0);
        
        w3.setPlayed(true);
        w3.setPoints_a(0);
        w3.setPoints_b(3);
        
        w4.setPlayed(true);
        w4.setPoints_a(1);
        w4.setPoints_b(1);
        
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        
        Competitie c1 = new Competitie(wlijst, ta);
        assertEquals(1, c1.getLossesOfTeam(t2));
    }
    
    @Test
    public void getPlayedGamesOfTeamTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team1", pp, null, 50000);
        Team t2 = new Team(sp2, "Team2", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        Wedstrijd w2 = new Wedstrijd(t1, t2);
        Wedstrijd w3 = new Wedstrijd(t1, t2);
        Wedstrijd w4 = new Wedstrijd(t1, t2);
        
        w1.setPlayed(true);
        w2.setPlayed(true);
        w3.setPlayed(true);
        w4.setPlayed(true);
        
        w1.setPoints_a(1);
        w1.setPoints_b(1);
        
        w2.setPoints_a(3);
        w2.setPoints_b(0);
        
        w3.setPoints_a(0);
        w3.setPoints_b(3);
        
        w4.setPoints_a(1);
        w4.setPoints_b(1);
        
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        
        Competitie c1 = new Competitie(wlijst, ta);
        assertEquals(4, c1.getPlayedGamesofTeam(t2));
    }
    
    @Test
    public void getGoalsOfTeamTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team1", pp, null, 50000);
        Team t2 = new Team(sp2, "Team2", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        Wedstrijd w2 = new Wedstrijd(t1, t2);
        Wedstrijd w3 = new Wedstrijd(t1, t2);
        Wedstrijd w4 = new Wedstrijd(t1, t2);
        
        w1.setScore_a(1);
        w1.setScore_b(1);
        w1.setPoints_a(1);
        w1.setPoints_b(1);
        
        w2.setScore_a(2);
        w2.setScore_b(0);
        w2.setPoints_a(3);
        w2.setPoints_b(0);
        
        w3.setScore_a(0);
        w3.setScore_b(1);
        w3.setPoints_a(0);
        w3.setPoints_b(3);
        
        w2.setScore_a(1);
        w2.setScore_b(1);
        w4.setPoints_a(1);
        w4.setPoints_b(1);
        
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        
        Competitie c1 = new Competitie(wlijst, ta);
        assertEquals(3, c1.getGoalsofTeam(t2));
    }
    
    @Test
    public void getCounterGoalsofTeamTest() {
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
        sp2.add(s1);
        
        Team t1 = new Team(sp1, "Team1", pp, null, 50000);
        Team t2 = new Team(sp2, "Team2", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        Wedstrijd w2 = new Wedstrijd(t1, t2);
        Wedstrijd w3 = new Wedstrijd(t1, t2);
        Wedstrijd w4 = new Wedstrijd(t1, t2);
        
        w1.setScore_a(1);
        w1.setScore_b(1);
        w1.setPoints_a(1);
        w1.setPoints_b(1);
        
        w2.setScore_a(2);
        w2.setScore_b(0);
        w2.setPoints_a(3);
        w2.setPoints_b(0);
        
        w3.setScore_a(0);
        w3.setScore_b(1);
        w3.setPoints_a(0);
        w3.setPoints_b(3);
        
        w4.setScore_a(1);
        w4.setScore_b(1);
        w4.setPoints_a(1);
        w4.setPoints_b(1);
        
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        
        Competitie c1 = new Competitie(wlijst, ta);
        assertEquals(4, c1.getCounterGoalsofTeam(t2));
    }
    
    @Test
    public void getEnSetCompetitie() {
        Competitie.setCompetitie(c1);
        assertEquals(c1, Competitie.getCompetitie());
    }
   
    @Test
    public void playGamesTillPlayerGameIsDueTest() {
        ArrayList<Wedstrijd> wedlijst = new ArrayList<Wedstrijd>();
        
        ArrayList<Speler> sp5 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp5 = new ArrayList<PosPlayer>();
        Speler s5 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Aanvaller);
        pp5.add(p5);
        sp5.add(s5);
        
        ArrayList<Speler> sp6 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp6 = new ArrayList<PosPlayer>();
        Speler s6 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Aanvaller);
        pp6.add(p6);
        sp6.add(s6);
        
        Team t5 = new Team(sp5, "TeamE", pp5, null, 99999);
        Team t6 = new Team(sp6, "TeamF", pp6, null, 584612);
        
        c1.getTeams().add(t5);
        c1.getTeams().add(t6);
        
        c1.setWedstrijden(wedlijst);
        c1.playGamesTilPlayerGameIsDue();
        assertNotNull(c1.getWedstrijden());
    }
    
    @Test
    public void playGamesTillPlayerGameIsDue_UI_FalseTest() {
        c1.setUserindex(0);
        c1.playGamesTilPlayerGameIsDue();
        assertNotNull(c1.getWedstrijden());
        assertTrue(c1.getWedstrijden().get(0).isPlayed());
    }
    
    @Test
    public void playGamesTillPlayerGameIsDue_UI_TrueTest() {
        c1.setUserindex(2);
        c1.getWedstrijden().get(0).setPlayed(false);
        c1.playGamesTilPlayerGameIsDue();
        assertFalse(c1.getWedstrijden().get(0).isPlayed());
    }
    
    @Test
    public void gamesLeftToPlayTrueTest() {
        c1.bouwWedstrijden();
        for (int i = 0; i < c1.getWedstrijden().size(); i++) {
            c1.getWedstrijden().get(i).setPlayed(true);
        }
        c1.getWedstrijden().get(1).setPlayed(false);
        c1.getWedstrijden().get(3).setPlayed(false);
        c1.getWedstrijden().get(4).setPlayed(false);
        c1.getWedstrijden().get(0).setPlayed(false);
        
        assertTrue(c1.gamesLeftToPlay());
    }
    
    
    @Test
    public void gamesLeftToPlayFalseTest() {
        c1.bouwWedstrijden();
        for (int i = 0; i < c1.getWedstrijden().size(); i++) {
            c1.getWedstrijden().get(i).setPlayed(true);
        }
        assertFalse(c1.gamesLeftToPlay());
    }
    
    @Test
    public void resetCompetitionTest() {
        c1.resetCompetition();
        assertNotNull(c1.getWedstrijden());
        assertTrue(c1.getWedstrijden().size() == 12);
    }
    
    @Test
    public void playPlayerGameTest() throws Exception {
        ArrayList<Speler> spellijst = new ArrayList<Speler>();
        ArrayList<Speler> slijstB = new ArrayList<>();
        ArrayList<PosPlayer> opstellingB = new ArrayList<PosPlayer>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        ArrayList<Wedstrijd> wlijst = new ArrayList<>();
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
        slijstB.add(s1);
        slijstB.add(s3);
        slijstB.add(s4);
        slijstB.add(s5);
        slijstB.add(s6);
        slijstB.add(s7);
        slijstB.add(s8);
        slijstB.add(s9);
        slijstB.add(s10);
        slijstB.add(s11);
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
        opstellingB.add(p1);
        opstellingB.add(p3);
        opstellingB.add(p4);
        opstellingB.add(p5);
        opstellingB.add(p6);
        opstellingB.add(p7);
        opstellingB.add(p8);
        opstellingB.add(p9);
        opstellingB.add(p10);
        opstellingB.add(p11);
        Team t1 = new Team(spellijst, "T1", posities, null, 500);
        Team t2 = new Team(slijstB, "T2", opstellingB, null, 1000);
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        
        teamlijst.add(t1);
        teamlijst.add(t2);
        Competitie c1 = new Competitie(wlijst, teamlijst);
        c1.setUserindex(1);
        t1.setCompetitie(c1);
        t2.setCompetitie(c1);
        System.out.println("END " + c1.playPlayerGame());
        assertTrue(c1.getWedstrijden().get(0).isPlayed());
        assertTrue(c1.getWedstrijden().size() == 2);
    }
    
    @Test
    public void playGamesTillPlayerGameIsDue_PG_Test() {
        ArrayList<Speler> spellijst = new ArrayList<Speler>();
        ArrayList<Speler> slijstB = new ArrayList<>();
        ArrayList<PosPlayer> opstellingB = new ArrayList<PosPlayer>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        ArrayList<Wedstrijd> wlijst = new ArrayList<>();
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
        slijstB.add(s1);
        slijstB.add(s3);
        slijstB.add(s4);
        slijstB.add(s5);
        slijstB.add(s6);
        slijstB.add(s7);
        slijstB.add(s8);
        slijstB.add(s9);
        slijstB.add(s10);
        slijstB.add(s11);
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
        opstellingB.add(p1);
        opstellingB.add(p3);
        opstellingB.add(p4);
        opstellingB.add(p5);
        opstellingB.add(p6);
        opstellingB.add(p7);
        opstellingB.add(p8);
        opstellingB.add(p9);
        opstellingB.add(p10);
        opstellingB.add(p11);
        Team t1 = new Team(spellijst, "T1", posities, null, 500);
        Team t2 = new Team(slijstB, "T2", opstellingB, null, 1000);
        Team t3 = new Team(spellijst, "T3", opstellingB, null, 5000);
        teamlijst.add(t1);
        teamlijst.add(t2);
        teamlijst.add(t3);
        Competitie c1 = new Competitie(wlijst, teamlijst);
        t1.setCompetitie(c1);
        t2.setCompetitie(c1);
        t3.setCompetitie(c1);
        c1.bouwWedstrijden();
        System.out.println(c1.getWedstrijden().size());
        c1.setUserindex(2);
        c1.playGamesTilPlayerGameIsDue();
    }
}
