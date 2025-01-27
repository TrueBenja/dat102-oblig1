package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
    Scanner scanner;

    public Tekstgrensesnitt() {
        scanner = new Scanner(System.in);
    }

    // Leser inn opplysninger om en film og returnerer Film-objekt
    public Film lesFilm(FilmarkivADT arkiv) {
        System.out.println("Skriv inn filmnummeret: ");
        int filmnr = lesInnFilmnr(arkiv);
        System.out.println("Skriv inn filmprodusenten: ");
        String filmprodusent = scanner.nextLine();
        System.out.println("Skriv inn tittelen på filmen: ");
        String tittel = scanner.nextLine();
        System.out.println("Skriv inn lanseringsåret til filmen: ");
        int lanseringsAar = Integer.parseInt(scanner.nextLine());
        System.out.println("Skriv inn sjangeren til filmen: ");
        Sjanger sjanger = Sjanger.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Skriv inn filmselskapet til filmen: ");
        String filmselskap = scanner.nextLine();
        return new Film(filmnr, filmprodusent, tittel, lanseringsAar, sjanger, filmselskap);
    }

    // Skriver ut all info om Film-objekt (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println(film);
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmerMedTittel = arkiv.soekTittel(delstreng);
        for (Film f : filmerMedTittel) {
            System.out.println(f);
        }
    }

    // Skriver ut alle filmer av en spesiell produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmerMedProdusent = arkiv.soekProdusent(delstreng);
        for (Film f : filmerMedProdusent) {
            System.out.println(f);
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Statistikk: ");
        System.out.println("Antall filmer: " + arkiv.antall());

        for (Sjanger s : Sjanger.values()) {
            System.out.println("Antall " + s.toString() + " filmer: " + arkiv.antall(s));
        }
    }

    // Sletter en film fra arkivet
    public boolean slettFilm(FilmarkivADT arkiv) {
        System.out.println("Hva er filmnummeret til filmen du ønsker å slette: ");
        int filmnr = Integer.parseInt(scanner.nextLine());
        return arkiv.slettFilm(filmnr);
    }

    // Ser om film med samme filmnr allerede eksisterer
    private int lesInnFilmnr(FilmarkivADT arkiv) {
        boolean finnes = true;
        int filmnr = -1;

        while (finnes) {
            filmnr = Integer.parseInt(scanner.nextLine());
            if (arkiv.finnFilm(filmnr) == null) {
                finnes = false;
            } else {
                System.out.println("Film med dette filmnummeret finnes allerede. Prøv igjen: ");
            }
        }
        return filmnr;
    }
}
