package Svet;

public class Zbran extends Predmet {
    private int dmg;

    public Zbran(String nazev, int dmg) {
        super(nazev);
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public String pouzit() {
        return "Použil jsi zbraň " + getNazev() + " a způsobil " + dmg + " poškození!";
    }

}

