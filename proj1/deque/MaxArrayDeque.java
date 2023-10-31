package deque;
import java.util.Comparator;

public class MaxArrayDeque<AnyType> extends ArrayDeque<AnyType> {

    private Comparator<AnyType> comparator;

    public MaxArrayDeque(Comparator c) {
        comparator = c;
    }

    public AnyType max(Comparator<AnyType> c) {
        if (isEmpty()) {
            return null;
        }
        AnyType curMax = get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), curMax) > 0) {
                curMax = get(i);
            }
        }
        return  curMax;
    }

    public AnyType max() {
        return  max(comparator);
    }
}


