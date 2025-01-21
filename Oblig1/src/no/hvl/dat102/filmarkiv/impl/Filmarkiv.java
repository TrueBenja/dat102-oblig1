package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmTab;
    int antall;

    public Filmarkiv(int storrelse) {
        filmTab = new Film[storrelse];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (nr == filmTab[i].getFilmnr()) {
                return filmTab[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall >= filmTab.length) {
            utvid();
        }
        filmTab[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        Film film = finnFilm(filmnr);
        if (film == null) {
            return false;
        }

        int indeks = finnIndeks(film);
        filmTab[indeks] = filmTab[antall - 1];
        filmTab[antall - 1] = null;
        antall--;
        return true;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] temp = new Film[antall];
        int antallFilmer = 0;

        for (int i = 0; i < antall; i++) {
            if (filmTab[i].getTittel().contains(delstreng)) {
                temp[antallFilmer] = filmTab[i];
                antallFilmer++;
            }
        }

        return Arrays.copyOf(temp, antallFilmer);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] temp = new Film[antall];
        int antallFilmer = 0;

        for (int i = 0; i < antall; i++) {
            if (filmTab[i].getFilmprodusent().contains(delstreng)) {
                temp[antallFilmer] = filmTab[i];
                antallFilmer++;
            }
        }

        return Arrays.copyOf(temp, antallFilmer);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallMedSjanger = 0;

        for (int i = 0; i < antall; i++) {
            if (filmTab[i].getSjanger().equals(sjanger)) {
                antallMedSjanger++;
            }
        }
        return antallMedSjanger;
    }

    @Override
    public int antall() {
        return antall;
    }

    private void utvid() {
        filmTab = Arrays.copyOf(filmTab, 2 * filmTab.length);
    }

    private int finnIndeks(Film film) {
        for (int i = 0; i < antall; i++) {
            if (film == filmTab[i]) {
                return i;
            }
        }
        return -1;
    }
}
