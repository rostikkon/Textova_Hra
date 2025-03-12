package Postavy;

import Prikaz.Inventar;
import Svet.SvetovaMapa;

public abstract class Postava {
    protected String jmeno;
    protected SvetovaMapa svet;
    protected Inventar inventar;
    protected int hp;

    public Postava(String jmeno, SvetovaMapa svet, Inventar inventar, int hp) {
        this.jmeno = jmeno;
        this.svet = svet;
        this.inventar = inventar;
        this.hp = hp;
    }

    public String getJmeno() {
        return jmeno;
    }

    public Postava(String jmeno) {
        this(jmeno, null, null, 100);
    }

    public int getHp() {
        return hp;
    }

    public void utrzitZraneni(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            System.out.println(jmeno + " byl poražen!");
        }
    }

    public abstract String interakce();
}