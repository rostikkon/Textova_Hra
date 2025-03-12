package Prikaz;

public class Napoveda implements Prikaz {
    public String vykonej() {
        return "Tip: Sbírej suroviny a dávej pozor na piráty!";
    }

    public boolean ukoncit() {
        return false;
    }
}
