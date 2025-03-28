import Prikaz.*;
import Postavy.*;
import Svet.*;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Prikaz> prikazy = new HashMap<>();
    private SvetovaMapa svet;
    private Inventar inventar;
    private Hrac hrac;
    private Pirat pirat;
    public void inicializace() {
        prikazy.put("jdi", new Pohyb(svet, hrac, inventar));
        prikazy.put("konec", new Konec());
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("vezmi", new Vzit(inventar, svet.getAktualniPozice()));
        prikazy.put("poloz", new Polozit(inventar, svet.getAktualniPozice()));
        prikazy.put("pouzij", new Pouzit(inventar));
        prikazy.put("mluv", new Mluvit(svet.getAktualniPozice()));
        prikazy.put("prozkoumej", new Prozkoumat(svet.getAktualniPozice()));
        prikazy.put("stav", new Stav(hrac, inventar));
        prikazy.put("utok", new Utok(hrac, pirat, inventar));
        prikazy.put("unik", new Unik(hrac));
    }

    private void nastavPostavyAPredmety() {
        svet.getLokace(1).nastavPredmet(new Surovina("Hyperionový krystal"));
        svet.getLokace(2).nastavPredmet(new Surovina("Plazmový generátor"));
        svet.getLokace(8).nastavPredmet(new Surovina("Ionizační palivo"));
        svet.getLokace(3).nastavPredmet(new Zbran("Laserová pistole", 20));
        svet.getLokace(1).nastavPostavu(new Strazce(svet, inventar));
        svet.getLokace(4).nastavPostavu(new Obchodnik(svet, inventar));
        svet.getLokace(5).nastavPostavu(new Pirat(svet, inventar));
        svet.getLokace(6).nastavPostavu(new Vedec(svet, inventar));
    }

    public void start() {

        svet = new SvetovaMapa();
        svet.nactiMapu();
        inventar = new Inventar();
        hrac = new Hrac(svet, inventar);
        pirat = new Pirat(svet, inventar);

        inicializace();
        nastavPostavyAPredmety();

        System.out.println("Vítejte ve hře! Zadejte příkaz.");

        while (!exit) {
            System.out.print(">> ");
            String vstup = scanner.nextLine().trim().toLowerCase();
            vykonejPrikaz(vstup);
        }
    }

    private void vykonejPrikaz(String prikaz) {
        if (prikazy.containsKey(prikaz)) {
            String vysledek = prikazy.get(prikaz).vykonej();
            System.out.println(vysledek);
            exit = prikazy.get(prikaz).ukoncit();
        } else {
            System.out.println("Neznámý příkaz.");
        }
    }
}
