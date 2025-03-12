package Postavy;

public class Hrac extends Postava {
    public Hrac() {
        super("Kapitán lodi Aurora");
    }

    @Override
    public String interakce() {
        return "Jsi kapitánem této mise. Musíš najít suroviny a opravit hyperpohon.";
    }
}

