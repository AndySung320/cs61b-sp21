package deque;
import java.lang.Math;
import java.util.Iterator;

public class ArrayDeque<AnyType> implements Deque<AnyType>, Iterable<AnyType>{
    private int nextFirst;
    private int nextLast;
    private AnyType items[];
    private int size;

    private int capacity = 8;

    public ArrayDeque(){
        items = (AnyType[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /** Calculate the nextLast index. */
    public int plusOne(int index){
        return Math.floorMod(index + 1, items.length);
    }

    /** Calculate the nextFirst index. */
    public int minusOne(int index){
        return Math.floorMod(index - 1, items.length);
    }

    public AnyType get(int index){
        if (index < 0 || index > size - 1 || isEmpty()){
            return null;
        }
        int pos = Math.floorMod(plusOne(nextFirst) + index, items.length);
        return items[pos];
    }

    /** Adds item to the front of the list. */
    public void addFirst(AnyType item){
        resize();
        items[nextFirst] = item;
        size = size + 1;
        nextFirst = minusOne(nextFirst);
    }

    /** Adds item to the end of the list. */
    public void addLast(AnyType item){
        resize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);;
        size = size + 1;
    }
    /** Remove the first element of the array. */
    public AnyType removeFirst(){
        if (this.isEmpty()){
            return null;
        }

        int tmp = plusOne(nextFirst);
        AnyType x = items[tmp];
        items[tmp] = null;
        nextFirst = tmp;
        size = size - 1;
        resize();
        return x;
    }

    /** Remove the last element of the array. */
    public AnyType removeLast(){
        if (this.isEmpty()){
            return null;
        }

        int tmp = minusOne(nextLast);//Math.floorMod(nextLast - 1 , items.length);
        AnyType x = items[tmp];
        items[tmp] = null;
        nextLast = tmp;
        size = size - 1;
        resize();
        return x;
    }

    public int size(){ return size; }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void resize(){
        if (size == items.length){
            expand();
        }
        if (size < (items.length * 0.25) && items.length > 8 ){
            shrink();
        }
    }

    public void expand(){
        capacity = items.length * 2;
        AnyType tmp [] = (AnyType[]) new Object[capacity];
        int start = plusOne(nextFirst);
        int end = minusOne(nextLast);
        for (int i = 0; i < items.length; i++){
            tmp[i] = items[start];
            start = plusOne(start);
        }
        nextFirst = capacity - 1;
        nextLast = items.length;
        items = tmp;

    }

    public void shrink(){
        capacity = items.length / 2;
        AnyType tmp [] = (AnyType[]) new Object[capacity];
        int start = plusOne(nextFirst);
        int end = minusOne(nextLast);
        for (int i = 0; i < items.length; i++){
            tmp[i] = items[start];
            start = plusOne(start);
        }
        nextFirst = capacity - 1;
        nextLast = items.length;
        items = tmp;

    }

    public void printDeque(){
        int start = plusOne(nextFirst);
        int end = nextLast;
        for (int i = 0; i < size; i++) {
            AnyType x = get(i);
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof ArrayDeque)){
            return false;
        }
        ArrayDeque<?> oa = (ArrayDeque<?>) o;
        if (oa.size != size){
            return false;
        }
        int start = plusOne(nextFirst);
        int end = nextLast;
        for (int i = start; i != end; i = plusOne(i)){
            if(oa.get(i) != get(i)){
                return false;
            }
        }
        return true;
    }

    public Iterator<AnyType> iterator() {
        return new ArrayDequeIterator();
    }
    public class ArrayDequeIterator implements Iterator<AnyType>{
        private int wizPos;

        private ArrayDequeIterator(){
            wizPos = 0;
        }

        public boolean hasNext(){
            return wizPos < size;
        }

        public AnyType next(){
            AnyType item = get(wizPos);
            wizPos = wizPos + 1;
            return item;
        }


    }
    public static void main(String[] args){
        ArrayDeque<Integer> A = new ArrayDeque();
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.addLast(8);
        //A.removeFirst();
        A.addLast(9);
        A.removeFirst();
        A.printDeque();
        System.out.printf("done\n");
        Iterator<Integer> seer = A.iterator();
        while(seer.hasNext()){
            int i = seer.next();
            System.out.println(i);
        }

    }

}


