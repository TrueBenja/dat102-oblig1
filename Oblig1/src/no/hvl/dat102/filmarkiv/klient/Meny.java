package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(2, "David Lowery", "A Ghost Story", 2017, Sjanger.FANTASY, "A24"));
        filmarkiv.leggTilFilm(new Film(3, "Christopher Columbus", "Harry Potter and the Philosopher's Stone", 2001, Sjanger.FANTASY, "Warner Bros"));

        boolean kjorer = true;
        while (kjorer) {
            System.out.println("(0) Avslutt\n(1) Legg til ny film\n(2) Skriv ut info om spesifikk film med tittel\n(3) Skriv ut info om spesifikk film med produsent\n(4) Skriv ut info om arkivet\n(5) Slett en film fra arkivet");
            int svar = scanner.nextInt();
            switch (svar) {
                case 0:
                    kjorer = false;
                    break;
                case 1:
                    filmarkiv.leggTilFilm(tekstgr.lesFilm(filmarkiv));
                    break;
                case 2:
                    System.out.println("Hvilken tittel leter du etter: ");
                    String tittel = scanner.next();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
                    break;
                case 3:
                    System.out.println("Hvilken produsent leter du etter: ");
                    String produsent = scanner.next();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, produsent);
                    break;
                case 4:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case 5:
                    boolean slettet = tekstgr.slettFilm(filmarkiv);
                    if (slettet) {
                        System.out.println("Filmen ble slettet.");
                    } else {
                        System.out.println("Filmen ble ikke slettet.");
                    }
                    break;
                default:
                    System.out.println("Ugyldig input.");
            }
        }
    }
}
