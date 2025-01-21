package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    // Leser inn opplysninger om en film og returnerer Film-objekt
    public Film lesFilm() {
        // TODO
        return new Film();
    }

    // Skriver ut all info om Film-objekt (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        // TODO
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstreingITittel(FilmarkivADT arkiv, String delstreng) {
        // TODO
    }

    // Skriver ut alle filmer av en spesiell produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        // TODO
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Statistikk: ");
        System.out.println("Antall filmer: " + arkiv.antall());

        for (Sjanger s : Sjanger.values()) {
            System.out.println("Antall " + s.toString() + " filmer: " + arkiv.antall(s));
        }
    }
}
