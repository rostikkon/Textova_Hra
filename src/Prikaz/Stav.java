package Prikaz;

public class Stav implements Prikaz {
    public String vykonej() {
        return "Zdraví: 100%\nInventář obsahuje několik předmětů.";
    }

    public boolean ukoncit() {
        return false;
    }
}