package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;
import Svet.Surovina;

public class Vedec extends Postava {
    public Vedec(SvetovaMapa svet, Inventar inventar) {
        super("Vědec Dr. Velkar", svet, inventar, 100);
    }

    @Override
    public String interakce() {
        if (inventar.maPredmet("Plazmový generátor")) {
            inventar.odebratZInventare(new Surovina("Plazmový generátor"));
            return "Dr. Velkar říká: Skvělé! Opravil jsem tvůj hyperpohon.";
        }
        return "Dr. Velkar říká: Potřebuji nějaké technologie, abych ti mohl pomoci.";
    }
}