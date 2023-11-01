package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void testFlik(){
        int a = -129;
        int b = -129;
        assertTrue("Same", Flik.isSameNumber(a,b));
    }
}
