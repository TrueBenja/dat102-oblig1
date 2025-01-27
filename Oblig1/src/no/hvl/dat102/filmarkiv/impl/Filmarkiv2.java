package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> denne = start;
        while (denne != null) {
            if (denne.data.getFilmnr() == nr) {
                return denne.data;
            }
            denne = denne.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> temp = start;
        start = new LinearNode<>(nyFilm);
        start.neste = temp;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> denne = start;
        LinearNode<Film> forrige = start;
        while (denne != null) {
            if (denne.data.getFilmnr() == filmnr) {
                forrige.neste = denne.neste;
                antall--;
                return true;
            }
            forrige = denne;
            denne = denne.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> denne = start;
        Film[] filmer = new Film[antall];
        int antallFilmer = 0;
        while (denne != null) {
            if (denne.data.getTittel().contains(delstreng)) {
                filmer[antallFilmer] = denne.data;
                antallFilmer++;
            }
            denne = denne.neste;
        }
        return Arrays.copyOf(filmer, antallFilmer);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> denne = start;
        Film[] filmer = new Film[antall];
        int antallFilmer = 0;
        while (denne != null) {
            if (denne.data.getFilmprodusent().contains(delstreng)) {
                filmer[antallFilmer] = denne.data;
                antallFilmer++;
            }
            denne = denne.neste;
        }
        return Arrays.copyOf(filmer, antallFilmer);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallMedSjanger = 0;
        LinearNode<Film> denne = start;

        while (denne != null) {
            if (denne.data.getSjanger().equals(sjanger)) {
                antallMedSjanger++;
            }
            denne = denne.neste;
        }
        return antallMedSjanger;
    }

    @Override
    public int antall() {
        return this.antall;
    }
}
