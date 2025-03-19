package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;

public class Hrac extends Postava {
    private int hp = 100;

    public Hrac(SvetovaMapa svet, Inventar inventar) {
        super("Kapitán lodi Aurora", svet, inventar, 100);
    }


    public int getHp() {
        return hp;
    }

    public void utrzitZraneni(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            System.out.println("Bohužel jsi zemřel. Konec hry.");
            System.exit(0);
        }
    }


    @Override
    public String interakce() {
        return "Jsi kapitánem této mise. Musíš najít suroviny a opravit hyperpohon.";
    }
}

