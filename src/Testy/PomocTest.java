package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Prikaz.Konec;
import Prikaz.Pomoc;
import org.junit.jupiter.api.Test;

public class PomocTest {

    @Test

    public void testPomoc(){
        Pomoc pomoc = new Pomoc();
        assertEquals("Dostupné příkazy: jdi, konec, pomoc, napoveda, vezmi, poloz, pouzij, mluv, prozkoumej, stav, utok, unik.",pomoc.vykonej());
    }

}
