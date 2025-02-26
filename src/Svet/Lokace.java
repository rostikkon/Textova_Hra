package Svet;

import java.util.Arrays;

public class Lokace {
    private String nazev;
    private int id;
    private int[] sousedi;

    public Lokace(String nazev, int id, String[] sousedi) {
        this.nazev = nazev;
        this.id = id;
        this.sousedi = new int[2];
        for (int i = 0; i < sousedi.length; i++) {
            this.sousedi[i] = Integer.parseInt(sousedi[i]);
        }
    }

    public String getNazev() {
        return nazev;
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
                '}';
    }
}