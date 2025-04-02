package Prikaz;

import Postavy.Postava;
import Svet.Lokace;
import Svet.Predmet;
import Svet.SvetovaMapa;

import java.util.ArrayList;

public class Prozkoumat implements Prikaz {
    private SvetovaMapa svet;

    public Prozkoumat(SvetovaMapa svet) {
        this.svet = svet;
    }

    @Override
    public String vykonej() {
        Lokace aktualniLokace = svet.getAktualniPozice();
        if (aktualniLokace == null) {
            return "Nemůžu prozkoumat neznámou oblast.";
        }

        StringBuilder sb = new StringBuilder();

        Postava postava = aktualniLokace.getPostava();
        if (postava != null) {
            sb.append("\n[Postava] ").append(postava.getJmeno());
        }

        ArrayList<Predmet> predmety = aktualniLokace.getPredmety();
        if (!predmety.isEmpty()) {
            if (sb.length() > 0) sb.append("\n");
            sb.append("[Předměty]: ");
            for (Predmet p : predmety) {
                sb.append(p.getNazev()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        if (sb.length() == 0) {
            return "Tato lokační je prázdná.";
        }

        return sb.toString();
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}
