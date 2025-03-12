package Prikaz;

public class Konec implements Prikaz {
    public String vykonej() {
        return "Hra ukončena.";
    }

    public boolean ukoncit() {
        return true;
    }
}
