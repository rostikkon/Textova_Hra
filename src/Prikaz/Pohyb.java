package Prikaz;

import Postavy.Hrac;
import Svet.Palivo;
import Svet.SvetovaMapa;
import Svet.Lokace;
import Prikaz.Inventar;
import java.util.Scanner;

public class Pohyb implements Prikaz {
    private SvetovaMapa svet;
    private Hrac hrac;
    private Inventar inventar;
    private Scanner scanner = new Scanner(System.in);

    public Pohyb(SvetovaMapa svet, Hrac hrac, Inventar inventar) {
        this.svet = svet;
        this.hrac = hrac;
        this.inventar = inventar;
    }

    @Override
    public String vykonej() {
        if (!inventar.maPredmet("Palivo")) {
            return "Nemáte dostatek paliva pro přesun!";
        }

        Lokace aktualni = svet.getAktualniPozice();

        System.out.println("\nDostupné směry:");
        boolean maSousedy = false;
        for (int idSouseda : aktualni.getSousedi()) {
            if (idSouseda != -1) {
                Lokace soused = svet.getLokace(idSouseda);
                System.out.println("- " + soused.getNazev());
                maSousedy = true;
            }
        }

        if (!maSousedy) {
            return "Nemáš kam jít. Jsou to všechny dostupné lokace.";
        }

        while (true) {
            System.out.print("\nKam chceš jít? (nebo 'zpet'): ");
            String cil = scanner.nextLine().trim();

            if (cil.equalsIgnoreCase("zpet")) {
                return "";
            }

            for (int idSouseda : aktualni.getSousedi()) {
                if (idSouseda != -1) {
                    Lokace soused = svet.getLokace(idSouseda);
                    if (soused.getNazev().equalsIgnoreCase(cil)) {
                        svet.setAktualniPozice(idSouseda);
                        System.out.println("Přesun na novou lokaci. Spotřebováno palivo.");
                        inventar.odebratZInventare(new Palivo());

                        System.out.println(svet.getAktualniPozice().getZakladniPopis());

                        return "";
                    }
                }
            }

            System.out.println("Neplatný cíl. Zadej platný název lokace.");
        }
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}