package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;

public class Pirat extends Postava {
    private int hp = 50;

    public Pirat(SvetovaMapa svet, Inventar inventar) {
        super("Pirátský velitel", svet, inventar, 50);
    }

    public int getHp() {
        return hp;
    }

    public void utrzitZraneni(int dmg) {
        hp -= dmg;
    }

    @Override
    public String interakce() {
        if (inventar.maPredmet("Zbraň")) {
            return "Piráti vidí, že máš zbraň, a jsou opatrní.";
        } else {
            return "Piráti tě obklopili! Můžeš bojovat nebo se pokusit uniknout.";
        }
    }
}