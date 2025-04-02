package Prikaz;

import Svet.Lokace;
import Svet.Predmet;
import Svet.SvetovaMapa;

import java.util.Scanner;

public class Polozit implements Prikaz {
    private Inventar inventar;
    private SvetovaMapa svet;
    private Scanner scanner = new Scanner(System.in);

    public Polozit(Inventar inventar, SvetovaMapa svet) {
        this.inventar = inventar;
        this.svet = svet;
    }

    @Override
    public String vykonej() {
        if (inventar.getPredmety().isEmpty()) {
            return "Inventář je prázdný.";
        }

        Lokace aktualniLokace = svet.getAktualniPozice();
        System.out.print("Který předmět chceš položit? ");
        String nazev = scanner.nextLine();

        Predmet predmet = inventar.getPredmet(nazev);
        if (predmet != null) {
            inventar.odebratZInventare(predmet);
           aktualniLokace.pridejPredmet(predmet);
            return "Položil jsi " + nazev;
        }
        return "Předmět " + nazev + " není v inventáři.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}