import Prikaz.*;
import Postavy.*;
import Svet.*;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Prikaz> prikazy = new HashMap<>();

    public void inicializace() {
        prikazy.put("jdi", new Pohyb(new SvetovaMapa()));
        prikazy.put("konec", new Konec());
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("vzit", new Vzit());
        prikazy.put("polozit", new Polozit());
        prikazy.put("pouzit", new Pouzit());
        prikazy.put("mluvit", new Mluvit());
        prikazy.put("prozkoumat", new Prozkoumat());
        prikazy.put("stav", new Stav());
        prikazy.put("utok", new Utok());
        prikazy.put("unik", new Unik());
    }

    public void start() {
        inicializace();
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
