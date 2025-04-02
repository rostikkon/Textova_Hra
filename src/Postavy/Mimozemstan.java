package Postavy;

import Prikaz.Inventar;
import Svet.Predmet;
import Svet.Surovina;
import Svet.SvetovaMapa;

public class Mimozemstan extends Postava {
    public Mimozemstan(SvetovaMapa svet, Inventar inventar) {
        super("Mimozemšťan", svet, inventar, 100);
    }

    @Override
    public String interakce() {
        if (inventar.maPredmet("Jídlo")) {
            inventar.odebratZInventare(new Surovina("Jídlo"));
            svet.getAktualniPozice().pridejPredmet(new Surovina("Plazmový generátor"));
            return "Mimozemšťan: 'Děkuji za jídlo! Předávám ti plazmový generátor.'";
        }
        return "Mimozemšťan: 'My dát plazmový generátor... za jídlo...'";
    }
}