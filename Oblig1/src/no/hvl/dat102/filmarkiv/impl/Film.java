package no.hvl.dat102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    private int filmnr;
    private String filmprodusent;
    private String tittel;
    private int lanseringsAar;
    private Sjanger sjanger;
    private String filmselskap;

    public Film(int filmnr, String filmprodusent, String tittel, int lanseringsAar, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.filmprodusent = filmprodusent;
        this.tittel = tittel;
        this.lanseringsAar = lanseringsAar;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public Film() {
        this.filmnr = 0;
        this.filmprodusent = "Uvisst";
        this.tittel = "Uvisst";
        this.lanseringsAar = 0;
        this.sjanger = null;
        this.filmselskap = "Uvisst";
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getFilmprodusent() {
        return filmprodusent;
    }

    public void setFilmprodusent(String filmprodusent) {
        this.filmprodusent = filmprodusent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLanseringsAar() {
        return lanseringsAar;
    }

    public void setLanseringsAar(int lanseringsAar) {
        this.lanseringsAar = lanseringsAar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public String toString() {
        return "Filmnr: " + filmnr + ", " + tittel + " (" + lanseringsAar + ", " + sjanger + "), regi av " + filmprodusent + ", filmselskap: " + filmselskap;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmnr);
    }
}
