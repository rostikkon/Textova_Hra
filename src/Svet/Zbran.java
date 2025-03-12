package Svet;

public class Zbran extends Predmet {
    public Zbran() {
        super("Laserová pistole");
    }

    @Override
    public String pouzit() {
        return "Použil jsi laserovou pistoli! Piráti mohou reagovat agresivně.";
    }
}