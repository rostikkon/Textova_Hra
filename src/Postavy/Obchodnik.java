package Postavy;

import Prikaz.Inventar;
import Svet.*;

public class Obchodnik extends Postava {

    public Obchodnik(SvetovaMapa svet, Inventar inventar) {
        super("Obchodník Zorx", svet, inventar, 100);
    }

    @Override
    public String interakce() {
        if (inventar.maPredmet("Hyperionový krystal")) {
            inventar.odebratZInventare(new Surovina("Hyperionový krystal"));
            inventar.pridatDoInventare(new NavigacniCip());
            return "Obchodník Zorx: 'Dobrá výměna! Teď máš navigační čip.'";
        } else if (inventar.maPredmet("Palivo")) {
            inventar.odebratZInventare(new Palivo());
            inventar.pridatDoInventare(new Zbran("Laserová zbraň", 10));
            return "Obchodník Zorx: 'Palivo za laserovou zbraň? To se dá udělat.'";
        }
        return "Obchodník Zorx: 'Co chceš koupit nebo prodat? Mám Hyperionový krystal a Laserovou zbraň.'";
    }
}
