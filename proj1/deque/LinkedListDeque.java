package deque;
import java.util.Iterator;


public class LinkedListDeque<AnyType> implements Deque<AnyType>, Iterable<AnyType>{

    public class ItemNode{
        public ItemNode prev;
        public AnyType item;
        public ItemNode next;
        public ItemNode(AnyType x, ItemNode p, ItemNode n){
            prev = p;
            item = x;
            next = n;
        }
    }
    private ItemNode sentinel;
    private int size;

    public LinkedListDeque(){
        size = 0;
        sentinel = new ItemNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }
    public LinkedListDeque(AnyType item) {
        size = 1;
        sentinel = new ItemNode(null, null, null);
        sentinel.next = new ItemNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
    }


    /** Adds item to the front of the list. */
    public void addFirst(AnyType item){
        ItemNode tmp = new ItemNode(item, null,null);
        tmp.next = sentinel.next;
        tmp.prev = sentinel;
        sentinel.next.prev = tmp;
        sentinel.next = tmp;
        size = size + 1;
    }
    /** Adds item to the end of the list. */
    public void addLast(AnyType item){
        ItemNode tmp = new ItemNode(item, null,null);
        tmp.next = sentinel;
        tmp.prev = sentinel.prev;
        sentinel.prev.next = tmp;
        sentinel.prev = tmp;
        size = size + 1;
    }
    /** Returns if the list is empty. */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    /** Returns the size of the list. */
    public int size(){ return size; }

    /** Print All the elements of the list. */
    public void printDeque(){
        ItemNode s = sentinel;
        for (int i = 0; i < size; i++){
            System.out.print(s.next.item + " ");
            s = s.next;
        }
        System.out.println();
    }

    /** Remove the first element of the list. */
    public AnyType removeFirst(){
        if (size == 0){
            return null;
        }
        AnyType x = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return x;
    }

    /** Remove the last element of the list. */
    public AnyType removeLast(){
        if (size == 0){
            return null;
        }
        AnyType x = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return x;
    }
    /** Get the element with index. */
    public AnyType get(int index){
        if (size == 0){
            return null;
        }
        if (index >= 0 && index < size) {
            ItemNode s = sentinel;
            AnyType x = s.next.item;
            for (int i = 0; i < index + 1; i++){
                if (i == index){
                    x = s.next.item;
                }
                s = s.next;
            }
            return x;
        }
        else {
            return null;
        }
    }
    /** HELPER - Get the element with index (Recursive). */
    public AnyType helper(int index, ItemNode s){
        if (index == 0){
            return s.item;
        }
        else{
            return helper(index - 1, s.next);
        }
    }
    /** Get the element with index (Recursive). */
    public AnyType getRecursive(int index){
        if (size == 0 || index < 0 || index >= size){
            return null;
        }
        if (index == 0){
            return sentinel.next.item;
        }
        else{
            return helper(index, sentinel.next);
        }
    }


    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof LinkedListDeque)){
            return false;
        }
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (lld.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (lld.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }
    public class LinkedListIterator implements Iterator<AnyType>{
        private int wizPos;
        private LinkedListIterator(){
            wizPos = 0;
        }

        public boolean hasNext(){
            return wizPos < size;
        }

        public AnyType next(){
            AnyType item = get(wizPos);
            wizPos += 1;
            return  item;
        }


    }






    public static void main(String[] args){
        LinkedListDeque L = new LinkedListDeque();
        L.addFirst(4);
        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        L.printDeque();

        Iterator<Integer> seer = L.iterator();
        while(seer.hasNext()){
            int i = seer.next();
            System.out.println(i);
        }

        //System.out.println(L.getRecursive(2));

    }




}
