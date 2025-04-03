package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Prikaz.Konec;
import org.junit.jupiter.api.Test;

public class KonecTest {

    @Test

    public void testKonec(){
        Konec konec = new Konec();
        assertEquals("Hra ukončena.",konec.vykonej());
        assertTrue(konec.ukoncit());
    }
}
