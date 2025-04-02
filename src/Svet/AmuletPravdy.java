package Svet;

public class AmuletPravdy extends Predmet {
    public AmuletPravdy(String nazev) {
        super(nazev);
    }

    @Override
    public String pouzit() {
        return "Září magickou energií!";
    }
}