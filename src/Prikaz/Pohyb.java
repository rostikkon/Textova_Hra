package Prikaz;

import Svet.SvetovaMapa;
import Svet.Lokace;

import java.util.Scanner;

public class Pohyb implements Prikaz {
    private SvetovaMapa svet;
    private Scanner scanner;

    public Pohyb(SvetovaMapa svet) {
        this.svet = svet;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String vykonej() {
        System.out.println("Kam chces jit? (sever/jih)");
        String smer = scanner.next().toLowerCase();
        Lokace aktualni = svet.getAktualniPozice();
        int[] sousedi = aktualni.getSousedi();

        if (smer.equals("sever") && sousedi[0] != -1) {
            svet.setAktualniPozice(sousedi[0]);
            return "Nyni se nachazis v: " + svet.getAktualniPozice().getNazev();
        } else if (smer.equals("jih") && sousedi[1] != -1) {
            svet.setAktualniPozice(sousedi[1]);
            return "Nyni se nachazis v: " + svet.getAktualniPozice().getNazev();
        } else {
            return "Tymto smerem nelze jit.";
        }
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}