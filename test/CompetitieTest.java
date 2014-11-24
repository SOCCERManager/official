/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class CompetitieTest {
    
    @Test
    public void CompetitieTest() {
        
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
        assertTrue(c1.getTeams().equals(ta));
    }
    /* NOG MAKEN */
    @Test
    public void getUserindexTest(){
    }
    
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
    
    
}
