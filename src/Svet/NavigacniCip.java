package Svet;

public class NavigacniCip extends Predmet {
    public NavigacniCip() {
        super("Navigační čip");
    }

    @Override
    public String pouzit() {
        return "Navigační čip byl aktivován. Trasa je jasná.";
    }
}