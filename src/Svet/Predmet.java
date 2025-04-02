package Svet;

/**
 * Abstraktní třída představující předmět ve hře.
 */
public abstract class Predmet {
    protected String nazev; // Název předmětu

    /**
     * Konstruktor předmětu.
     *
     * @param nazev Název předmětu.
     */
    public Predmet(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrátí název předmětu.
     *
     * @return Název předmětu.
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Definuje akci předmětu, když je použit.
     *
     * @return Popis akce předmětu.
     */
    public abstract String pouzit();
}
