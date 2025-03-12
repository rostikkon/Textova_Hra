package Postavy;

public class Pirat extends Postava {
    public Pirat() {
        super("Pirátský velitel");
    }

    @Override
    public String interakce() {
        return "Piráti tě obklopili. Můžeš bojovat nebo se pokusit uniknout.";
    }
}