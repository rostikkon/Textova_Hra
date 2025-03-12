package Prikaz;

public class Mluvit implements Prikaz {
    public String vykonej() {
        return "Mluvíš s mimozemšťanem nebo obchodníkem.";
    }

    public boolean ukoncit() {
        return false;
    }
}
