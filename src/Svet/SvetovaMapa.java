package Svet;

import Postavy.*;
import Prikaz.Inventar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SvetovaMapa {
    private HashMap<Integer, Lokace> svet = new HashMap<>();
    private int aktualniPozice = 0;

    public boolean nactiMapu() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Svet/mistnost.csv"))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                String[] hodnoty = radek.split(";");
                Lokace lokace = new Lokace(
                        hodnoty[1],
                        Integer.parseInt(hodnoty[0]),
                        Arrays.copyOfRange(hodnoty, 2, 4)
                );
                svet.put(Integer.valueOf(hodnoty[0]), lokace);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Lokace getAktualniPozice() {
        return svet.get(aktualniPozice);
    }

    public Lokace getLokace(int id) {
        return svet.get(id);
    }

    public void setAktualniPozice(int id) {
        aktualniPozice = id;
    }

    public HashMap<Integer, Lokace> getSvet() {
        return svet;
    }
}
