package Prikaz;

import Postavy.Hrac;
import Postavy.Pirat;
import Prikaz.Inventar;
import Svet.Zbran;

import java.util.Random;

public class Utok implements Prikaz {
    private Hrac hrac;
    private Pirat pirat;
    private Inventar inventar;
    private Random rand = new Random();

    public Utok(Hrac hrac, Pirat pirat, Inventar inventar) {
        this.hrac = hrac;
        this.pirat = pirat;
        this.inventar = inventar;
    }

    @Override
    public String vykonej() {
        if (!inventar.maPredmet("Zbraň")) {
            return "Nemáš zbraň! Piráti tě snadno přemohli. Konec hry.";
        }

        Zbran zbran = (Zbran) inventar.getPredmet("Zbraň");
        System.out.println("Začíná boj s pirátem!");

        while (hrac.getHp() > 0 && pirat.getHp() > 0) {
            int hracUtok = zbran.getDmg();
            int piratUtok = rand.nextInt(10) + 5;

            pirat.utrzitZraneni(hracUtok);
            System.out.println("Zasáhl jsi piráta za " + hracUtok + " HP. Pirátský HP: " + pirat.getHp());

            if (pirat.getHp() <= 0) {
                return "Piráti byli poraženi! Pokračuj v cestě.";
            }

            hrac.utrzitZraneni(piratUtok);
            System.out.println("Piráti tě zasáhli za " + piratUtok + " HP. Tvoje HP: " + hrac.getHp());
        }
        return "Bitva skončila.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}