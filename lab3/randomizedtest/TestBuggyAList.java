package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        a.addLast(4);
        b.addLast(4);

        a.addLast(5);
        b.addLast(5);

        a.addLast(6);
        b.addLast(6);

        assertEquals(a.size(),b.size());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());

    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // getLast
                if (L.size() > 0 && B.size() > 0){
                int last = L.getLast();
                int last_b = B.getLast();
                //assertEquals(last, last_b);
                System.out.println("getLast(L): " + last);
                System.out.println("getLast(B): " + last_b);

                }
            }

            else if(operationNumber == 2){
                // removeLast
                if(L.size() > 0 && B.size() > 0) {
                    L.removeLast();
                    B.removeLast();
                    //System.out.println("remove");
                }
            }
        }
    }

}
