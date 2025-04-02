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

    @Override
    public String vykonej() {
        if (inventar.isEmpty()) {
            return "Tvůj inventář je prázdný.";
        }
        System.out.println("Co chceš udělat s inventářem?");
        String akce = scanner.next();

        return "Uzavřel jsi inventář.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }

    public boolean pridatDoInventare(Predmet predmet) {
        if (inventar.size() >= MAX_KAPACITA) {
            System.out.println("Inventář je plný! Odstraňte nějaké předměty.");
            return false;
        }
        inventar.add(predmet);
        return true;
    }

    public boolean odebratZInventare(Predmet predmet) {
        return inventar.remove(predmet);
    }
}