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
            hrac.setPiratiVUtoku(false);
            return "Podařilo se ti uniknout!";
        } else {
            int dmg = rand.nextInt(10) + 5;
            hrac.utrzitZraneni(dmg);
            return "Nezvládl jsi uniknout! Piráti tě zasáhli za " + dmg + " HP. Tvoje HP: " + hrac.getHp();
        }
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}