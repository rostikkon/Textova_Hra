package Prikaz;

public class Pouzit implements Prikaz {
    public String vykonej() {
        return "Použil jsi předmět ze svého inventáře.";
    }

    public boolean ukoncit() {
        return false;
    }
}
