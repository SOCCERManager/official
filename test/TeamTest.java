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
    public void ConstuctorTest() {
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
	
	public void EqualsGelijkeTeamsTest() {
		
	}
    
}
