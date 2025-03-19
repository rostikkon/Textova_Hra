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
        prikazy.put("vzit", new Vzit());
        prikazy.put("polozit", new Polozit());
        prikazy.put("pouzit", new Pouzit());
        prikazy.put("mluvit", new Mluvit());
        prikazy.put("prozkoumat", new Prozkoumat());
        prikazy.put("stav", new Stav());
        prikazy.put("utok", new Utok(hrac, pirat, inventar));
        prikazy.put("unik", new Unik(hrac));
    }

    private void nastavPostavyAPredmety() {
        svet.getSvet().get(0).nastavPostavu(new Strazce(svet, inventar));
        svet.getSvet().get(1).nastavPredmet(new Surovina("Plazmový generátor"));
        svet.getSvet().get(3).nastavPostavu(new Obchodnik(svet, inventar));
        svet.getSvet().get(4).nastavPostavu(new Pirat(svet, inventar));
        svet.getSvet().get(5).nastavPostavu(new Vedec(svet, inventar));
        svet.getSvet().get(7).nastavPredmet(new Surovina("Hyperionový krystal"));
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
