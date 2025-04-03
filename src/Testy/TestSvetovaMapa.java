package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Svet.SvetovaMapa;
import org.junit.jupiter.api.Test;

public class TestSvetovaMapa {

    @Test

    public void testSvetovaMapa(){
        SvetovaMapa svet = new SvetovaMapa();
        assertTrue(svet.nactiMapu());
    }

}
