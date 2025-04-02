package Prikaz;

public class Pomoc implements Prikaz {
    @Override
    public String vykonej() {
        return "Dostupné příkazy: jdi, konec, pomoc, napoveda, vezmi, poloz, pouzij, mluv, prozkoumej, stav, utok, unik.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}