package Svet;

/**
 * Třída představující palivo potřebné pro pohyb mezi lokacemi.
 */
public class Palivo extends Predmet {
    /**
     * Konstruktor paliva.
     */
    public Palivo() {
        super("Palivo");
    }

    /**
     * Použije palivo pro let na další planetu.
     *
     * @return Popis použití paliva.
     */
    @Override
    public String pouzit() {
        return "Palivo bylo použito pro let na další planetu.";
    }
}