package FFSSM;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LicenceTest {
    
    Licence l, l2; 
    Plongeur pg;
    Club c;
    Moniteur m;

    @BeforeEach
    public void setUp(){
        m = new Moniteur("73839", "Lopez", "Damien", "29 rue Firmin Oules Castres", "0790498763", LocalDate.of(2001, 10, 8), 3, GroupeSanguin.AMOINS, 460 );
        c = new Club(m, "AquaPlanning", "0728819", "au bord de l'eau");
        pg = new Plongeur("377", "Baptiste", "Lolilo", "ENFER", "06060606", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
    
        l = new Licence(pg, "480048", LocalDate.of(2022, 8, 10), c);
    }

    @Test
    public void testCreation(){
        assertTrue(l instanceof Licence);
    }

    @Test
    public void testEstValide(){
        l2 = new Licence(pg, "9463", LocalDate.of(2010, 8, 10), c);
        assertFalse(l2.estValide(LocalDate.now()));

        assertTrue(l.estValide(LocalDate.now()));
    }
}
