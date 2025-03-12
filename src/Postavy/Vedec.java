package Postavy;

public class Vedec extends Postava {
    public Vedec() {
        super("Vědec Dr. Velkar");
    }

    @Override
    public String interakce() {
        return "Dr. Velkar říká: Mohu ti pomoci s opravou hyperpohonu.";
    }
}