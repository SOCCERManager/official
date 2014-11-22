import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;

public class TeamTest {
    public void constuctorTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            assertNotNull(t1);
	}
	
	public void equalsGelijkeTeamsTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            
            Speler s3 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p3 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s4 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p4 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst2 = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities2 = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden2 = new ArrayList<Wedstrijd>();
            ArrayList<Team> t11 = new ArrayList<Team>(); 
            Competitie PremierLeague = new Competitie(wedstrijden, t10);
            spelerlijst.add(s3);
            spelerlijst.add(s4);
            posities.add(p3);
            posities.add(p4);
            Team t2 = new Team(spelerlijst2, "Fc club", posities2, PremierLeague, 500000);
            
            assertEquals(true, t1.equals(t2));
	}
        
        public void equalsOngelijkeTeamsTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            
            Speler s3 = new Speler("KLAAS", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p3 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s4 = new Speler("PIETER", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p4 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst2 = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities2 = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden2 = new ArrayList<Wedstrijd>();
            ArrayList<Team> t11 = new ArrayList<Team>(); 
            Competitie PremierLeague = new Competitie(wedstrijden, t10);
            spelerlijst.add(s3);
            spelerlijst.add(s4);
            posities.add(p3);
            posities.add(p4);
            Team t2 = new Team(spelerlijst2, "SC VOETBAL", posities2, PremierLeague, 500000);
            
            assertEquals(false, t1.equals(t2));
        }
        
        public void getBudgetTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            assertEquals(500000, t1.getBudget());
        }
        
        public void setBudgetTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            t1.setBudget(2);
            assertEquals(2, t1.getBudget());
        }
        
        public void getNameTest(){
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            assertEquals("Fc club", t1.getName());
        }
        
        public void setNameTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            t1.setName("voetbal");
            assertEquals("voetbal", t1.getName());
        }
        
        public void getOpstellingTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            assertEquals(posities, t1.getOpstelling());
        }
        
        public void setOpstellingTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<PosPlayer> opstelling = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            opstelling.add(p2);
            opstelling.add(p1);
            t1.setOpstelling(opstelling);
            assertEquals(opstelling, t1.getOpstelling());
        }
        
        public void getSpelersTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            assertEquals(spelerlijst, t1.getSpelers());
        }
        
        public void setSpelersTest() {
            Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
            PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
            Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
            PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
            ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
            ArrayList<Speler> spelers = new ArrayList<Speler>();
            ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
            ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
            ArrayList<Team> t10 = new ArrayList<Team>(); 
            Competitie eredivisie = new Competitie(wedstrijden, t10);
            spelerlijst.add(s1);
            spelerlijst.add(s2);
            posities.add(p1);
            posities.add(p2);
            spelers.add(s2);
            spelers.add(s1);
            Team t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
            t1.setSpelers(spelers);
            assertEquals(spelers, t1.getSpelers());
        }
        
        
        
        
}

//GetScore nog niet inbegrepen!!!
