package no.hvl.dat102.filmarkiv.impl;

public enum Sjanger {
    ACTION, DRAMA, HISTORY, SCIFI, BIOPIC, PSYCHOLOGICAL, TRILLER, HORROR, FANTASY;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equals(navn.toUpperCase())) {
                return s;
            }
        }
        return null;
    }
}
