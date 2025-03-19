package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;

public class Strazce extends Postava {
    public Strazce(SvetovaMapa svet, Inventar inventar) {
        super("Strážce ruin", svet, inventar, 100);
    }

    @Override
    public String interakce() {
        return "Strážce ruin říká: Pouze ten, kdo má čisté srdce, může projít.";
    }
}