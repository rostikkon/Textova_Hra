package Svet;

public abstract class Predmet {
    protected String nazev;

    public Predmet(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    public abstract String pouzit();
}
