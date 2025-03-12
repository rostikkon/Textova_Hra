package Prikaz;

import Svet.Predmet;
import java.util.ArrayList;
import java.util.Scanner;


public class Inventar implements Prikaz {
    private ArrayList<Predmet> inventar = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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
        if (predmet != null) {
            inventar.add(predmet);
            return true;
        }
        return false;
    }

    public boolean odebratZInventare(Predmet predmet) {
        return inventar.remove(predmet);
    }
}