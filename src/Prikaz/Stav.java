package Prikaz;

import Postavy.Hrac;
import Svet.Predmet;

public class Stav implements Prikaz {

    private Hrac hrac;
    private Inventar inventar;

    public Stav(Hrac hrac, Inventar inventar) {
        this.hrac = hrac;
        this.inventar = inventar;
    }

    @Override
    public String vykonej() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zdraví: ").append(hrac.getHp()).append("%\n");
        sb.append("Inventář:\n");
        if (inventar.getPredmety().isEmpty()) {
            sb.append("Prázdný\n");
        } else {
            for (Predmet p : inventar.getPredmety()) {
                sb.append("- ").append(p.getNazev()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}