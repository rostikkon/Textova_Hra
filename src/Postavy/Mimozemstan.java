package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;

public class Mimozemstan extends Postava {
    public Mimozemstan(SvetovaMapa svet, Inventar inventar) {
        super("Mimozemšťan", svet, inventar, 100);
    }

    @Override
    public String interakce() {
        return "Mimozemšťan tě pozorně sleduje a čeká na tvou reakci.";
    }
}