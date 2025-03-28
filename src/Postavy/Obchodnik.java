package Postavy;

import Prikaz.Inventar;
import Svet.NavigacniCip;
import Svet.SvetovaMapa;
import Svet.Surovina;

public class Obchodnik extends Postava {

    public Obchodnik(SvetovaMapa svet, Inventar inventar) {
        super("Obchodník Zorx", svet, inventar, 100);
    }

    @Override
    public String interakce() {
        if (inventar.maPredmet("Hyperionový krystal")) {
            inventar.odebratZInventare(new Surovina("Hyperionový krystal"));
            inventar.pridatDoInventare(new NavigacniCip());
            return "Obchodník Zorx říká: Děkuji za obchod! Předávám ti navigační čip.";
        }
        return "Obchodník Zorx říká: Máš něco na výměnu? Potřebuji Hyperionový krystal.";
    }
}
