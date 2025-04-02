package Prikaz;

import Svet.Lokace;
import Svet.Predmet;
import Prikaz.Inventar;
import Svet.SvetovaMapa;
import java.util.ArrayList;
import java.util.Scanner;

public class Vzit implements Prikaz {
    private Inventar inventar;
    private SvetovaMapa svet;
    private Scanner scanner = new Scanner(System.in);


    public Vzit(Inventar inventar, SvetovaMapa svet) {
        this.inventar = inventar;
        this.svet = svet;
    }

    @Override
    public String vykonej() {
        Lokace aktualniLokace = svet.getAktualniPozice();
        ArrayList<Predmet> predmety = aktualniLokace.getPredmety();
        if (predmety.isEmpty()) {
            return "Žádný předmět k sebrání.";
        }

        while (true) {
            System.out.print("Který předmět chceš vzít? (nebo 'zpet' pro návrat): ");
            String nazev = scanner.nextLine().trim();

            if (nazev.equalsIgnoreCase("zpet")) {
                return "";
            }

            Predmet predmet = null;
            for (Predmet p : predmety) {
                if (p.getNazev().equalsIgnoreCase(nazev)) {
                    predmet = p;
                    break;
                }
            }

            if (predmet == null) {
                System.out.println("Předmět " + nazev + " není v této lokační.");
                continue;
            }

            if (inventar.pridatDoInventare(predmet)) {
                aktualniLokace.getPredmety().remove(predmet);
                return "Sebral jsi " + predmet.getNazev();
            }

            return "Nelze sebrat předmět.";
        }
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}

