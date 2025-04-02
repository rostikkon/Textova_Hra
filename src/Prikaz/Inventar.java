package Prikaz;

import Svet.Predmet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Třída představující inventář hráče.
 */
public class Inventar implements Prikaz {
    private ArrayList<Predmet> inventar = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private static final int MAX_KAPACITA = 6;

    /**
     * Zjistí, zda inventář obsahuje daný předmět.
     *
     * @param nazev Název předmětu.
     * @return {@code true}, pokud předmět existuje, jinak {@code false}.
     */
    public boolean maPredmet(String nazev) {
        for (Predmet predmet : inventar) {
            if (predmet.getNazev().equalsIgnoreCase(nazev)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vrátí předmět z inventáře.
     *
     * @param nazev Název předmětu.
     * @return Předmět nebo {@code null}, pokud není v inventáři.
     */
    public Predmet getPredmet(String nazev) {
        for (Predmet predmet : inventar) {
            if (predmet.getNazev().equalsIgnoreCase(nazev)) {
                return predmet;
            }
        }
        return null;
    }

    public ArrayList<Predmet> getPredmety() {
        return inventar;
    }

    /**
     * Vykonává akci s inventářem (nevyužívá se přímo).
     *
     * @return Popis stavu inventáře.
     */
    @Override
    public String vykonej() {
        if (inventar.isEmpty()) {
            return "Tvůj inventář je prázdný.";
        }
        System.out.println("Co chceš udělat s inventářem?");
        String akce = scanner.next();

        return "Uzavřel jsi inventář.";
    }

    /**
     * Vrátí, zda má být ukončena hra po vykonání příkazu.
     *
     * @return Vždy vrátí {@code false}.
     */
    @Override
    public boolean ukoncit() {
        return false;
    }

    /**
     * Přidá předmět do inventáře.
     *
     * @param predmet Předmět, který se má přidat.
     * @return {@code true}, pokud se předmět úspěšně přidal, jinak {@code false}.
     */
    public boolean pridatDoInventare(Predmet predmet) {
        if (inventar.size() >= MAX_KAPACITA) {
            System.out.println("Inventář je plný! Odstraňte nějaké předměty.");
            return false;
        }
        inventar.add(predmet);
        return true;
    }

    /**
     * Odebere předmět z inventáře.
     *
     * @param predmet Předmět, který se má odebrat.
     * @return {@code true}, pokud se předmět úspěšně odebrel, jinak {@code false}.
     */
    public boolean odebratZInventare(Predmet predmet) {
        return inventar.remove(predmet);
    }
}