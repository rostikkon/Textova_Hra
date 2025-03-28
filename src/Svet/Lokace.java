package Svet;

import java.util.Arrays;
import Postavy.*;
import Prikaz.*;

public class Lokace {
    private String nazev;
    private int id;
    private int[] sousedi;
    private Postava postava;
    private Predmet predmet;

    public Lokace(String nazev, int id, String[] sousedi) {
        this.nazev = nazev;
        this.id = id;
        this.sousedi = new int[2];
        for (int i = 0; i < sousedi.length; i++) {
            this.sousedi[i] = Integer.parseInt(sousedi[i]);
        }
        this.postava = null;
        this.predmet = null;
    }

    public void nastavPostavu(Postava postava) {
        this.postava = postava;
    }

    public void nastavPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public void provedAkce(Hrac hrac, Inventar inventar) {
        System.out.println("Dorazil jsi na místo: " + nazev);
        switch (nazev) {
            case "Planeta Zephyria":
                if (!inventar.maPredmet("Hyperionový krystal")) {
                    System.out.println("Strážce ruin ti brání v průchodu!");
                    return;
                }
                break;
            case "Měsíční laboratoř":
                if (inventar.maPredmet("Plazmový generátor") &&
                        inventar.maPredmet("Hyperionový krystal") &&
                        inventar.maPredmet("Ionizační palivo")) {
                    System.out.println("Dr. Velkar opravil hyperpohon! Můžeš se vrátit na základnu.");
                    hrac.setHyperpohonOpraven(true);
                }
                break;
        }
        if (postava != null) {
            System.out.println(postava.interakce());
        }

        if (predmet != null) {
            inventar.pridatDoInventare(predmet);
            System.out.println("Našel jsi " + predmet.getNazev());
            predmet = null;
        }
    }

    public String getNazev() {
        return nazev;
    }

    public Postava getPostava() {
        return postava;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public int getId() {
        return id;
    }

    public int[] getSousedi() {
        return sousedi;
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "nazev='" + nazev + '\'' +
                ", id=" + id +
                ", sousedi=" + Arrays.toString(sousedi) +
                ", postava=" + (postava != null ? postava.getJmeno() : "žádná") +
                ", predmet=" + (predmet != null ? predmet.getNazev() : "žádný") +
                '}';
    }
}