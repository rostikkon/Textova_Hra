import Postavy.*;
import Svet.*;

public class Hra {
    private SvetovaMapa svet;
    private Hrac hrac;

    public void start() {
        svet = new SvetovaMapa();
        svet.nactiMapu();
        hrac = new Hrac();
    }

    public void zpracujPrikaz(String prikaz) {}
}
