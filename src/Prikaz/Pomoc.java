package Prikaz;

public class Pomoc implements Prikaz {
    public String vykonej() {
        return "Dostupné příkazy: pohyb, konec, pomoc, napoveda, vezmi, poloz, pouzij, mluv, prozkoumej, stav, utok, unik.";
    }

    public boolean ukoncit() {
        return false;
    }
}