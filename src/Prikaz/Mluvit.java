package Prikaz;

import Svet.Lokace;
import Postavy.Postava;
import Svet.SvetovaMapa;

public class Mluvit implements Prikaz {
    private SvetovaMapa svet;

    public Mluvit(SvetovaMapa svet) {
        this.svet = svet;
    }

    @Override
    public String vykonej() {
        Lokace aktualniLokace = svet.getAktualniPozice();
        Postava postava = aktualniLokace.getPostava();
        if (postava == null) {
            return "Zde není nikdo, s kým bys mohl mluvit.";
        }
        return postava.interakce();
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}
