package Prikaz;

import Svet.Predmet;
import java.util.Scanner;

public class Pouzit implements Prikaz {
    private Inventar inventar;
    private Scanner scanner = new Scanner(System.in);

    public Pouzit(Inventar inventar) {
        this.inventar = inventar;
    }

    @Override
    public String vykonej() {
        if (inventar.getPredmety().isEmpty()) {
            return "Inventář je prázdný.";
        }

        System.out.print("Který předmět chceš použít? ");
        String nazev = scanner.nextLine();

        Predmet predmet = inventar.getPredmet(nazev);
        if (predmet != null) {
            return predmet.pouzit();
        }
        return "Předmět " + nazev + " není v inventáři.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}
