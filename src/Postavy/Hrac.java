package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;

/**
 * Třída představující hráče.
 */
public class Hrac extends Postava {
    private int hp = 100; // Zdraví hráče
    private boolean hyperpohonOpraven = false; // Stav hyperpohonu
    private boolean piratiVUtoku = false; // Indikátor bitvy s piráty

    /**
     * Vrátí, zda je hráč v bitvě s piráty.
     *
     * @return {@code true}, pokud je v bitvě, jinak {@code false}.
     */
    public boolean isPiratiVUtoku() {
        return piratiVUtoku;
    }

    /**
     * Nastaví, zda je hráč v bitvě s piráty.
     *
     * @param piratiVUtoku Nový stav bitvy s piráty.
     */
    public void setPiratiVUtoku(boolean piratiVUtoku) {
        this.piratiVUtoku = piratiVUtoku;
    }

    /**
     * Konstruktor hráče.
     *
     * @param svet     Světová mapa.
     * @param inventar Inventář hráče.
     */
    public Hrac(SvetovaMapa svet, Inventar inventar) {
        super("Kapitán lodi Aurora", svet, inventar, 100);
    }

    /**
     * Vrátí zdraví hráče.
     *
     * @return Aktuální zdraví hráče.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sníží zdraví hráče po zranění.
     *
     * @param dmg Počet bodů zranění.
     */
    public void utrzitZraneni(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            System.out.println("Bohužel jsi zemřel. Konec hry.");
            System.exit(0);
        }
    }

    /**
     * Vrátí, zda je hyperpohon opraven.
     *
     * @return {@code true}, pokud je hyperpohon opraven, jinak {@code false}.
     */
    public boolean isHyperpohonOpraven() {
        return hyperpohonOpraven;
    }

    /**
     * Nastaví, zda je hyperpohon opraven.
     *
     * @param opraven Nový stav hyperpohonu.
     */
    public void setHyperpohonOpraven(boolean opraven) {
        this.hyperpohonOpraven = opraven;
    }

    @Override
    public String interakce() {
        return "Jsi kapitánem této mise. Musíš najít suroviny a opravit hyperpohon.";
    }
}

