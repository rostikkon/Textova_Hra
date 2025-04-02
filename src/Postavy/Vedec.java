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
        Hrac hrac = svet.getHrac();
        if (inventar.maPredmet("Hyperionový krystal") &&
                inventar.maPredmet("Plazmový generátor") &&
                inventar.maPredmet("Ionizační palivo")) {
            hrac.setHyperpohonOpraven(true);
            return "Dr. Velkar: 'Všechny součástky jsou tu! Hyperpohon je opraven! Teď můžeš odletět domů.'";
        }
        return "Dr. Velkar: 'Potřebuji všechny tři suroviny pro opravu hyperpohonu.'";
    }
}