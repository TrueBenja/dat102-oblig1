package no.hvl.dat102.filmarkiv.adt;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {
    /**
     * Hente en film med gitt nr fra arkivet
     * @param nr på film som skal hentes
     * @return film med gitt nr. Om nr ikke finnes, returneres null
     */
    Film finnFilm(int nr);

    /**
     * Legger til en ny film
     * @param nyFilm
     */
    void leggTilFilm(Film nyFilm);

    /**
     * Sletter en film med gitt filmnr
     * @param filmnr nummer på filmen som skal slettes
     * @return true dersom filmen ble slettet, false ellers
     */
    boolean slettFilm(int filmnr);

    /**
     * Søker og henter filmer med gitt delstreng i tittelen
     * @param delstreng som må være i tittelen
     * @return tabell med filmer som har delstreng i tittelen
     */
    Film[] soekTittel(String delstreng);

    /**
     * Søker og henter filmer med gitt delstreng i filmprodusent
     * @param delstreng som må være i navnet på produsenten
     * @return tabell med filmer som har delstrengen i navnet på produsenten
     */
    Film[] soekProdusent(String delstreng);

    /**
     * Finner antall filmer med gitt sjanger
     * @param sjanger til filmene
     * @return antall filmer med gitt sjanger
     */
    int antall(Sjanger sjanger);

    /**
     * @return antall filmer i filmarkivet
     */
    int antall();
}
