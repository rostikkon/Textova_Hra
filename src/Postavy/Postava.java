package Postavy;

public abstract class Postava {
    protected String jmeno;

    public Postava(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getJmeno() {
        return jmeno;
    }

    public abstract String interakce();
}