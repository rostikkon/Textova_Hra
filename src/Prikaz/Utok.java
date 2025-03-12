package Prikaz;

public class Utok implements Prikaz {
    public String vykonej() {
        return "Bojuješ s piráty a bráníš svou loď!";
    }

    public boolean ukoncit() {
        return false;
    }
}