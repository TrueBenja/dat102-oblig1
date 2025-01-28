package no.hvl.dat102.filmarkiv.test;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv2;
import no.hvl.dat102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Filmarkiv2Test {
    Filmarkiv2 filmarkiv;
    Filmarkiv2 tomtFilmarkiv;

    Film inception = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");
    Film aGhostStory = new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24");
    Film harryPotter1 = new Film(3, "Christopher Columbus", "Harry Potter and the Philosopher's Stone", 2001, Sjanger.FANTASY, "Warner Bros");

    @BeforeEach
    public void setUp() {
        filmarkiv = new Filmarkiv2();
        tomtFilmarkiv = new Filmarkiv2();
        filmarkiv.leggTilFilm(inception);
        filmarkiv.leggTilFilm(aGhostStory);
        filmarkiv.leggTilFilm(harryPotter1);
    }

    @Test
    public void testAntall() {
        assertEquals(0, tomtFilmarkiv.antall());
        assertEquals(3, filmarkiv.antall());
    }

    @Test
    public void testLeggTilFilm() {
        filmarkiv.leggTilFilm(inception);
        assertEquals(4, filmarkiv.antall());
        assertNotEquals(5, filmarkiv.antall());

        filmarkiv.leggTilFilm(aGhostStory);
        assertEquals(5, filmarkiv.antall());
    }

    @Test
    public void testSlettFilm() {
        assertEquals(3, filmarkiv.antall());

        assertFalse(filmarkiv.slettFilm(4));
        assertTrue(filmarkiv.slettFilm(2));
        assertEquals(2, filmarkiv.antall());
        assertTrue(filmarkiv.slettFilm(3));
        assertNull(filmarkiv.finnFilm(3));
        assertEquals(1, filmarkiv.antall());
    }

    @Test
    public void testFinnFilm() {
        assertEquals(inception, filmarkiv.finnFilm(1));
        assertEquals(aGhostStory, filmarkiv.finnFilm(2));
        assertEquals(harryPotter1, filmarkiv.finnFilm(3));
        assertNull(filmarkiv.finnFilm(4));
    }

    @Test
    public void testSoekTittel() {
        assertEquals(inception, filmarkiv.soekTittel("o")[2]);
        assertEquals(aGhostStory, filmarkiv.soekTittel("o")[1]);

        assertEquals(inception, filmarkiv.soekTittel("Incep")[0]);

        assertNotEquals(harryPotter1, filmarkiv.soekTittel("Incep")[0]);
    }

    @Test
    public void testSoekProdusent() {
        assertEquals(inception, filmarkiv.soekProdusent("Chris")[1]);
        assertEquals(harryPotter1, filmarkiv.soekProdusent("Chris")[0]);
        assertNotEquals(inception, filmarkiv.soekProdusent("David")[0]);
    }

    @Test
    public void testAntallSjanger() {
        assertEquals(2, filmarkiv.antall(Sjanger.FANTASY));
        assertEquals(1, filmarkiv.antall(Sjanger.SCIFI));
        assertNotEquals(1, filmarkiv.antall(Sjanger.ACTION));
    }
}
