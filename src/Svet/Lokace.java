package Svet;

import java.util.ArrayList;
import java.util.Arrays;
import Postavy.*;
import Prikaz.*;

/**
 * Třída představující lokaci ve hře.
 */
public class Lokace {
    private String nazev; // Název lokace
    private int id; // ID lokace
    private int[] sousedi; // Pole sousedních lokací
    private Postava postava; // Postava v lokaci
    private ArrayList<Predmet> predmety; // Seznam předmětů v lokaci
    private String popis; // Popis lokace

    /**
     * Konstruktor lokace.
     *
     * @param nazev   Název lokace.
     * @param id      ID lokace.
     * @param sousedi Pole sousedních lokací.
     * @param popis   Popis lokace.
     */
    public Lokace(String nazev, int id, String[] sousedi, String popis) {
        this.nazev = nazev;
        this.id = id;
        this.sousedi = new int[2];
        for (int i = 0; i < sousedi.length; i++) {
            this.sousedi[i] = Integer.parseInt(sousedi[i]);
        }
        this.postava = null;
        this.predmety = new ArrayList<>();
        this.popis = popis;
    }

    /**
     * Vrátí základní popis lokace.
     *
     * @return Základní popis lokace.
     */
    public String getZakladniPopis() {
        return "== " + nazev + " ==\n" + popis;
    }

    /**
     * Vrátí podrobný popis lokace včetně postav a předmětů.
     *
     * @return Podrobný popis lokace.
     */
    public String getPodrobnyPopis() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(nazev).append(" ===\n");
        sb.append(popis).append("\n");
        if (postava != null) {
            sb.append("\n[Postava] ").append(postava.getJmeno());
        }
        if (!predmety.isEmpty()) {
            sb.append("\n[Předměty]: ");
            for (Predmet p : predmety) {
                sb.append(p.getNazev()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    /**
     * Nastaví nový popis lokace.
     *
     * @param popis Nový popis lokace.
     */
    public void setPopis(String popis) {
        this.popis = popis;
    }

    /**
     * Nastaví postavu do lokace.
     *
     * @param postava Postava, která bude v lokaci.
     */
    public void nastavPostavu(Postava postava) {
        this.postava = postava;
    }

    /**
     * Vrátí seznam předmětů v lokaci.
     *
     * @return Seznam předmětů.
     */
    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    /**
     * Přidá předmět do lokace.
     *
     * @param predmet Předmět, který se má přidat.
     */
    public void pridejPredmet(Predmet predmet) {
        this.predmety.add(predmet);
    }

    /**
     * Provede akci lokace (např. boj nebo dialog).
     *
     * @param hrac     Aktuální hráč.
     * @param inventar Inventář hráče.
     */
    public void provedAkce(Hrac hrac, Inventar inventar) {
        System.out.println(getZakladniPopis());
    }

    /**
     * Vrátí název lokace.
     *
     * @return Název lokace.
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrátí postavu v lokaci.
     *
     * @return Postava v lokaci nebo {@code null}, pokud není žádná.
     */
    public Postava getPostava() {
        return postava;
    }

    /**
     * Vrátí ID lokace.
     *
     * @return ID lokace.
     */
    public int getId() {
        return id;
    }

    /**
     * Vrátí pole sousedních lokací.
     *
     * @return Pole sousedních lokací.
     */
    public int[] getSousedi() {
        return sousedi;
    }

}