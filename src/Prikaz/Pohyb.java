package Prikaz;

import Postavy.Hrac;
import Svet.SvetovaMapa;
import Svet.Lokace;
import Prikaz.Inventar;

import java.util.Scanner;

public class Pohyb implements Prikaz {
    private SvetovaMapa svet;
    private Hrac hrac;
    private Inventar inventar;

    public Pohyb(SvetovaMapa svet, Hrac hrac, Inventar inventar) {
        this.svet = svet;
        this.hrac = hrac;
        this.inventar = inventar;
    }

    @Override
    public String vykonej() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kam chceš jít? (Zadej název lokace)");
        String cil = scanner.nextLine().trim();

        Lokace aktualni = svet.getAktualniPozice();
        int[] sousedi = aktualni.getSousedi();

        for (int idSouseda : sousedi) {
            if (idSouseda != -1 && svet.getSvet().containsKey(idSouseda)) {
                Lokace sousedniLokace = svet.getSvet().get(idSouseda);
                if (sousedniLokace.getNazev().equalsIgnoreCase(cil)) {
                    svet.setAktualniPozice(idSouseda);
                    Lokace novaPozice = svet.getAktualniPozice();
                    novaPozice.provedAkce(hrac, inventar);
                    if (novaPozice.getNazev().equals("Základna") && hrac.isHyperpohonOpraven()) {
                        System.out.println("Gratuluji! Opravil jsi hyperpohon a úspěšně ses vrátil na základnu.");
                        System.exit(0);
                    }
                    return "Nyní se nacházíš v: " + novaPozice.getNazev();
                }
            }
        }
        return "Tam se nemůžeš dostat.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}