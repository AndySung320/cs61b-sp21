package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesComplex(){
        IntList lst = IntList.of(1, 2, 3, 4, 10, 100);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 9 -> 4 -> 10 -> 100", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testSquarePrimesComplex2(){
        IntList lst = IntList.of(2,2,3,4,4,5);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 9 -> 4 -> 4 -> 25", lst.toString());
        assertTrue(changed);
    }
}
