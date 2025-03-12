package Prikaz;

import java.util.Random;
import Postavy.Hrac;

public class Unik implements Prikaz {
    private Hrac hrac;
    private Random rand = new Random();

    public Unik(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String vykonej() {
        int sance = rand.nextInt(100);

        if (sance > 70) {
            return "Podařilo se ti uniknout!";
        } else {
            int dmg = rand.nextInt(10) + 5;
            hrac.utrzitZraneni(dmg);
            return "Nezvládl jsi uniknout a piráti tě zasáhli za " + dmg + " HP!";
        }
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}