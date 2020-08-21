import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(current == null){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }


    private class Node{
        Item item;
        Node next;
        Node prev;

        public Node(Item item){
            this.item = item;
        }
    }

    public Deque(){

    }

    public boolean isEmpty(){
        return first == null && last == null;
    }

    public int size(){
        return 0;
    }

    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        if(last == null) {
            last = first;
        };
    }

    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node(item);
        last.prev = oldLast;
        oldLast.next = last;
        if(first == null) first = last;
    }

    public Item removeFirst(){
        Node oldFirst = first;
        if(oldFirst == null){
            throw new NoSuchElementException();
        }
        first = oldFirst.next;
        if(first == null) last = first;
        return oldFirst.item;
    }

    public Item removeLast(){
        Node oldLast = last;
        if(oldLast == null){
            throw new NoSuchElementException();
        }
        last = oldLast.prev;
        if(last != null){
            last.next = null;
        } else {
            first = last;
        }
        return oldLast.item;
    }

    @Override
    public String toString(){
        String stackString = "";
        Node aux = first;
        while(aux != null){
            stackString = stackString.concat("|");
            stackString = stackString.concat(String.valueOf(aux.item));
            aux = aux.next;
        }
        return stackString;
    }

    public static void main(String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(0);
        d.addFirst(1);
        d.addLast(2);
        d.addLast(3);
        d.addFirst(8);
        d.removeFirst();
        d.removeFirst();
        d.removeLast();
        d.removeLast();
        d.removeFirst();
    }

}
