package no.hvl.dat102.filmarkiv.test;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {
    @Test
    public void testAntall() {
        Filmarkiv filmarkiv = new Filmarkiv(2);

        assertEquals(0, filmarkiv.antall());
        filmarkiv.leggTilFilm(new Film(1, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24"));
        assertEquals(1, filmarkiv.antall());
    }

    @Test
    public void testLeggTilFilm() {
        Filmarkiv filmarkiv = new Filmarkiv(3);
        assertEquals(0, filmarkiv.antall());
        filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros"));
        assertEquals(1, filmarkiv.antall());

        filmarkiv.leggTilFilm(new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24"));
        assertEquals(2, filmarkiv.antall());
    }

    @Test
    public void testSlettFilm() {
        Filmarkiv filmarkiv = new Filmarkiv(2);
        filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24"));
        filmarkiv.leggTilFilm(new Film(3, "Christopher Columbus", "Harry Potter and the Philosopher's Stone", 2001, Sjanger.FANTASY, "Warner Bros"));
        assertEquals(3, filmarkiv.antall());

        assertFalse(filmarkiv.slettFilm(4));
        assertTrue(filmarkiv.slettFilm(3));
        assertEquals(2, filmarkiv.antall());
        assertTrue(filmarkiv.slettFilm(2));
        assertEquals(1, filmarkiv.antall());
    }

    @Test
    public void testFinnFilm() {
        Filmarkiv filmarkiv = new Filmarkiv(2);
        Film inception = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");

        filmarkiv.leggTilFilm(inception);
        filmarkiv.leggTilFilm(new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24"));
        assertEquals(inception, filmarkiv.finnFilm(1));
        assertNull(filmarkiv.finnFilm(3));
    }

    @Test
    public void testSoekTittel() {
        Filmarkiv filmarkiv = new Filmarkiv(2);
        Film inception = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");
        Film aGhostStory = new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24");
        filmarkiv.leggTilFilm(inception);
        filmarkiv.leggTilFilm(aGhostStory);

        assertEquals(inception, filmarkiv.soekTittel("o")[0]);
        assertEquals(aGhostStory, filmarkiv.soekTittel("o")[1]);

        assertEquals(inception, filmarkiv.soekTittel("Incep")[0]);
    }

    @Test
    public void testSoekProdusent() {
        Filmarkiv filmarkiv = new Filmarkiv(2);
        Film inception = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");
        Film aGhostStory = new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24");
        Film harryPotter1 = new Film(3, "Christopher Columbus", "Harry Potter and the Philosopher's Stone", 2001, Sjanger.FANTASY, "Warner Bros");

        filmarkiv.leggTilFilm(inception);
        filmarkiv.leggTilFilm(aGhostStory);
        filmarkiv.leggTilFilm(harryPotter1);

        assertEquals(inception, filmarkiv.soekProdusent("Chris")[0]);
        assertNotEquals(inception, filmarkiv.soekProdusent("David")[0]);
    }

    @Test
    public void testAntallSjanger() {
        Filmarkiv filmarkiv = new Filmarkiv(2);
        Film inception = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros");
        Film aGhostStory = new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24");
        Film harryPotter1 = new Film(3, "Christopher Columbus", "Harry Potter and the Philosopher's Stone", 2001, Sjanger.FANTASY, "Warner Bros");

        filmarkiv.leggTilFilm(inception);
        filmarkiv.leggTilFilm(aGhostStory);
        filmarkiv.leggTilFilm(harryPotter1);

        assertEquals(2, filmarkiv.antall(Sjanger.FANTASY));
        assertEquals(1, filmarkiv.antall(Sjanger.SCIFI));
        assertNotEquals(1, filmarkiv.antall(Sjanger.ACTION));
    }
}
