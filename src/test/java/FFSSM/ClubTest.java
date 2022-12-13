package FFSSM;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClubTest {
    Moniteur m, pre;
    Club c;
    Plongeur p;
    Plongee pe;

    @BeforeEach
    public void setUp(){
        m = new Moniteur("73839", "Lopez", "Damien", "29 rue Firmin Oules Castres", "0790498763", LocalDate.of(2001, 10, 8), 3, GroupeSanguin.AMOINS, 460 );
        c = new Club(m, "AquaPlanning", "0728819", "au bord de l'eau");
        
        pe = new Plongee(new Site("Marseille", "Calanque"), m, LocalDate.of(2022, 12, 13), 50, 1, c);
        p = new Plongeur("377", "Baptiste", "Lolilo", "ENFER", "06060606", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
    
        pre = new Moniteur("1830218", "Pellegrin", "Leo", "14 rue de Castres", "0781794004", LocalDate.of(2002, 12, 4), 3, GroupeSanguin.APLUS, 40 );

    }

    @Test
    public void testCreation(){
        assertTrue(c instanceof Club);
    }


    //organisePlongee et plongeesNonConformes
    @Test
    public void testplongeesNonConformes(){
        p.ajouterLicence("34994", LocalDate.of(2017, 8, 2), c);
        pe.ajouteParticipant(p);
        c.organisePlongee(pe);

        int i = c.plongeesNonConformes().size();
        assertEquals(1, i);
    }

    @Test
    public void testDirecteur(){
        c.setPresident(pre);
        assertEquals(pre, c.getPresident());
    }


}


