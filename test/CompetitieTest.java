/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.Clock;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import soccer.Competitie;
import static soccer.Competitie.getCompetitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;

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
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(w1);
        
        Competitie c1 = new Competitie(w,ta); 
    }
    
    @After
    public void tearDown() {
        c1 = null;
    }
    /*
    @Test
    public void CompetitieTest() {
        assertTrue(c1.getWedstrijden().equals(w));
        assertTrue(c1.getTeams().equals(ta));
    }
    */
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
    public void bouwWedstrijdenTest() {
        c1.bouwWedstrijden();
        c1.getWedstrijden().get(0).setPlayed(true);
        System.out.println(c1.getWedstrijden());
        assertEquals("Naam", c1.getWedstrijden().get(0).toString());
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
    public void bouwWedstrijdenTeamsTest() {
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
        ArrayList<Wedstrijd> wedstr = c1.getWedstrijden();
        ArrayList<Wedstrijd> wedstrControle = new ArrayList<Wedstrijd>();
        Wedstrijd w1_1 = new Wedstrijd(t1, t4);
        Wedstrijd w1_2 = new Wedstrijd(t2, t5);
        Wedstrijd w1_3 = new Wedstrijd(t3, t6);
        
        Wedstrijd w2_1 = new Wedstrijd(t1, t2);
        Wedstrijd w2_2 = new Wedstrijd(t3, t4);
        Wedstrijd w2_3 = new Wedstrijd(t6, t5);
        
        Wedstrijd w3_1 = new Wedstrijd(t1, t3);
        Wedstrijd w3_2 = new Wedstrijd(t6, t2);
        Wedstrijd w3_3 = new Wedstrijd(t5, t4);
        
        Wedstrijd w4_1 = new Wedstrijd(t1, t6);
        Wedstrijd w4_2 = new Wedstrijd(t5, t3);
        Wedstrijd w4_3 = new Wedstrijd(t4, t2);
        
        Wedstrijd w5_1 = new Wedstrijd(t1, t5);
        Wedstrijd w5_2 = new Wedstrijd(t4, t6);
        Wedstrijd w5_3 = new Wedstrijd(t2, t3);
        
        wedstrControle.add(w1_1);
        wedstrControle.add(w1_2);
        wedstrControle.add(w1_3);
        
        wedstrControle.add(w2_1);
        wedstrControle.add(w2_2);
        wedstrControle.add(w2_3);
        
        wedstrControle.add(w3_1);
        wedstrControle.add(w3_2);
        wedstrControle.add(w3_3);
        
        wedstrControle.add(w4_1);
        wedstrControle.add(w4_2);
        wedstrControle.add(w4_3);
        
        wedstrControle.add(w5_1);
        wedstrControle.add(w5_2);
        wedstrControle.add(w5_3);
        
        assertEquals(wedstr, wedstrControle);
    }
    
    @Test
    public void Test() {
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
        assertEquals(c1, Competitie.getCompetitie());
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
}
