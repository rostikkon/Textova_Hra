package Prikaz;

import Svet.Lokace;
import Postavy.Postava;

public class Mluvit implements Prikaz {
    private Lokace lokace;

    public Mluvit(Lokace lokace) {
        this.lokace = lokace;
    }

    @Override
    public String vykonej() {
        Postava postava = lokace.getPostava();
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
