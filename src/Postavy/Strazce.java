package Postavy;

public class Strazce extends Postava {
    public Strazce() {
        super("Strážce ruin");
    }

    @Override
    public String interakce() {
        return "Strážce ruin tě varuje: Pouze ti hodní smí vstoupit!";
    }
}