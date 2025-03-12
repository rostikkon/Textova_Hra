package Svet;

public class Palivo extends Predmet {
    public Palivo() {
        super("Palivo");
    }

    @Override
    public String pouzit() {
        return "Palivo bylo použito pro let na další planetu.";
    }
}