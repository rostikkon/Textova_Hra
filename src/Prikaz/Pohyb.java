package Prikaz;

import Postavy.Hrac;
import Postavy.Pirat;
import Svet.Palivo;
import Svet.SvetovaMapa;
import Svet.Lokace;
import Prikaz.Inventar;

import java.util.Random;
import java.util.Scanner;

public class Pohyb implements Prikaz {
    private SvetovaMapa svet;
    private Hrac hrac;
    private Inventar inventar;
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();


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

                        if (cil.equals("Planeta Zephyria") && !inventar.maPredmet("Amulet pravdy")) {
                            return "Strážce: 'Bez amuletu pravdy tě nepustím dál!'";
                        }

                        if (cil.equals("Černá díra") && !inventar.maPredmet("Speciální štít")) {
                            return "Gravitace černé díry je příliš silná! Potřebujete štít pro ochranu.";
                        }

                        svet.setAktualniPozice(idSouseda);
                        System.out.println("Přesun na novou lokaci. Spotřebováno palivo.");
                        inventar.odebratZInventare(new Palivo());

                        int lokaceId = soused.getId();
                        if ((lokaceId == 4 || lokaceId == 5 || lokaceId == 7) && rand.nextInt(3) == 0) {
                            Pirat pirat = new Pirat(svet, inventar);
                            System.out.println("Upozornění! Piráti tě objevili!");
                            hrac.setPiratiVUtoku(true);
                            return "Musíš bojovat nebo se pokusit uniknout! Použij příkaz 'utok' nebo 'unik'.";
                        }

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