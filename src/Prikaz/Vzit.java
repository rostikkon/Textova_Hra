package Prikaz;

import Svet.Lokace;
import Svet.Predmet;
import Prikaz.Inventar;

public class Vzit implements Prikaz {
    private Inventar inventar;
    private Lokace lokace;

    public Vzit(Inventar inventar, Lokace lokace) {
        this.inventar = inventar;
        this.lokace = lokace;
    }

    @Override
    public String vykonej() {
        Predmet predmet = lokace.getPredmet();
        if (predmet == null) {
            return "Žádný předmět k sebrání.";
        }

        if (inventar.pridatDoInventare(predmet)) {
            lokace.nastavPredmet(null);
            return "Sebral jsi " + predmet.getNazev();
        }
        return "Nelze sebrat předmět.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}

