package Prikaz;

import Svet.Lokace;

public class Prozkoumat implements Prikaz {
    private Lokace lokace;

    public Prozkoumat(Lokace lokace) {
        this.lokace = lokace;
    }

    @Override
    public String vykonej() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nacházíš se v: ").append(lokace.getNazev()).append("\n");

        if (lokace.getPostava() != null) {
            sb.append("Vidíš: ").append(lokace.getPostava().getJmeno()).append("\n");
        }

        if (lokace.getPredmet() != null) {
            sb.append("Vidíš předmět: ").append(lokace.getPredmet().getNazev());
        } else {
            sb.append("Nevidíš žádné předměty.");
        }

        return sb.toString();
    }

    @Override
    public boolean ukoncit() {
        return false;
    }
}
