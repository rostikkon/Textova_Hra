package Prikaz;

import Svet.Lokace;
import Svet.Predmet;
import java.util.Scanner;

public class Polozit implements Prikaz {
    private Inventar inventar;
    private Lokace lokace;
    private Scanner scanner = new Scanner(System.in);

    public Polozit(Inventar inventar, Lokace lokace) {
        this.inventar = inventar;
        this.lokace = lokace;
    }

    @Override
    public String vykonej() {
        if (inventar.getPredmety().isEmpty()) {
            return "Inventář je prázdný.";
        }

        System.out.print("Který předmět chceš položit? ");
        String nazev = scanner.nextLine();

        Predmet predmet = inventar.getPredmet(nazev);
        if (predmet != null) {
            inventar.odebratZInventare(predmet);
            lokace.nastavPredmet(predmet);
            return "Položil jsi " + nazev;
        }
        return "Předmět " + nazev + " není v inventáři.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}