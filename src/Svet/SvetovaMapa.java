package Svet;

import Postavy.*;
import Prikaz.Inventar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Třída představující světovou mapu s lokacemi a jejich spojeními.
 */
public class SvetovaMapa {
    private HashMap<Integer, Lokace> svet = new HashMap<>(); // Mapa lokací
    private int aktualniPozice = 0; // ID aktuální lokace
    private Hrac hrac; // Objekt hráče

    /**
     * Nastavuje objekt hráče do mapy.
     *
     * @param hrac Aktuální hráč.
     */
    public void setHrac(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Vrátí objekt hráče.
     *
     * @return Aktuální hráč.
     */
    public Hrac getHrac() {
        return hrac;
    }

    /**
     * Načte mapu ze souboru.
     *
     * @return {@code true}, pokud se mapa úspěšně načetla, jinak {@code false}.
     */
    public boolean nactiMapu() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Svet/mistnost.csv"));
            String radek;

            while ((radek = br.readLine()) != null) {
                String[] hodnoty = radek.split(";");

                Lokace lokace = new Lokace(
                        hodnoty[1],
                        Integer.parseInt(hodnoty[0]),
                        new String[]{hodnoty[2], hodnoty[3]},
                        hodnoty[4]
                );

                svet.put(Integer.parseInt(hodnoty[0]), lokace);
            }
            br.close();
            return true;
        } catch (Exception e) {
            System.out.println("Chyba: " + e.getMessage());
            return false;
        }
    }

    /**
     * Vrátí aktuální lokaci hráče.
     *
     * @return Aktuální lokace.
     */
    public Lokace getAktualniPozice() {
        return svet.get(aktualniPozice);
    }

    /**
     * Vrátí lokaci podle jejího ID.
     *
     * @param id ID lokace.
     * @return Lokace s daným ID nebo {@code null}, pokud neexistuje.
     */
    public Lokace getLokace(int id) {
        return svet.get(id);
    }

    /**
     * Nastaví novou aktuální lokaci.
     *
     * @param id ID lokace, kam se má přesunout hráč.
     */
    public void setAktualniPozice(int id) {
        aktualniPozice = id;
    }

    /**
     * Vrátí celou mapu lokací.
     *
     * @return Mapa lokací.
     */
    public HashMap<Integer, Lokace> getSvet() {
        return svet;
    }
}
