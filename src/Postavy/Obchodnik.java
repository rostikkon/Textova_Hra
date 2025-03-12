package Postavy;

public class Obchodnik extends Postava {
    public Obchodnik() {
        super("Obchodník Zorx");
    }

    @Override
    public String interakce() {
        return "Obchodník Zorx říká: Máš něco na výměnu?";
    }
}
