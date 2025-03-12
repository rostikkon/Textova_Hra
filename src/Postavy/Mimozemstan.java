package Postavy;

public class Mimozemstan extends Postava {
    public Mimozemstan() {
        super("Mimozemšťan");
    }

    @Override
    public String interakce() {
        return "Mimozemšťan tě pozorně sleduje a čeká na tvou reakci.";
    }
}