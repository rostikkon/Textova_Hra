package Prikaz;

public class Unik implements Prikaz {
    public String vykonej() {
        return "Snažíš se uniknout pirátům a provést únikový manévr.";
    }

    public boolean ukoncit() {
        return false;
    }
}