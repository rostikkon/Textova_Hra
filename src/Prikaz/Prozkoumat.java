package Prikaz;

public class Prozkoumat implements Prikaz {
    public String vykonej() {
        return "Prozkoumáváš své okolí a hledáš užitečné předměty.";
    }

    public boolean ukoncit() {
        return false;
    }
}
