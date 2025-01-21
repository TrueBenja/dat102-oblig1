package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        // TODO
        filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24"));
        filmarkiv.leggTilFilm(new Film(3, "Christopher Columbus", "Harry Potter and the Philosopher's Stone", 2001, Sjanger.FANTASY, "Warner Bros"));

        boolean kjorer = true;
        while (kjorer) {

        }
    }
}
