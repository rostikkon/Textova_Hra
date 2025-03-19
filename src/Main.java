import Svet.SvetovaMapa;

public class Main {
    public static void main(String[] args) {
        SvetovaMapa mapa = new SvetovaMapa();
        mapa.nactiMapu();
        System.out.println(mapa.getSvet());
        Konzole konzole = new Konzole();
        konzole.start();
    }
}