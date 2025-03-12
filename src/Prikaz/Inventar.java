package Prikaz;

import Svet.Predmet;
import java.util.ArrayList;
import java.util.Scanner;


class Inventar implements Prikaz {
    private ArrayList<Predmet> inventar = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String vykonej() {
        if (inventar.isEmpty()) {
            return "Tvůj inventář je prázdný.";
        }
        System.out.println("Co chceš udělat s inventářem?");
        String akce = scanner.next();

        return "Uzavřel jsi inventář.";
    }

    @Override
    public boolean ukoncit() {
        return false;
    }

    public boolean pridatDoInventare(Predmet predmet) {
        if (predmet != null) {
            inventar.add(predmet);
            return true;
        }
        return false;
    }

    public boolean odebratZInventare(Predmet predmet) {
        return inventar.remove(predmet);
    }
}