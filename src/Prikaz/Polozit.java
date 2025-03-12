package Prikaz;

public class Polozit implements Prikaz {
    public String vykonej() {
        return "Položil jsi předmět z inventáře na zem.";
    }

    public boolean ukoncit() {
        return false;
    }
}