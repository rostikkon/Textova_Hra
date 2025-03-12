package Svet;

public class Surovina extends Predmet {
    public Surovina(String nazev) {
        super(nazev);
    }

    @Override
    public String pouzit() {
        return nazev + " byl přidán k opravě hyperpohonu.";
    }

    public static Surovina hyperionovyKrystal() {
        return new Surovina("Hyperionový krystal");
    }

    public static Surovina plazmovyGenerator() {
        return new Surovina("Plazmový generátor");
    }

    public static Surovina ionizacniPalivo() {
        return new Surovina("Ionizační palivo");
    }
}
