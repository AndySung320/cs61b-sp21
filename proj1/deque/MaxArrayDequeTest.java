package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;


public class MaxArrayDequeTest {

    public static class IntComparator implements Comparator<Integer> {
        public int compare(Integer n1, Integer n2) {
            return n1 - n2;
        }
    }

    public static class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    @Test
    public void maxWithoutComparatorTest() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new IntComparator());

        for (int i = 0; i < 5; i++) {
            mad.addLast(i);
        }

        assertEquals((Integer) 4, mad.max());
    }
}
