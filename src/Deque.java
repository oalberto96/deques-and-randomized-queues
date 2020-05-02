import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;

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
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        if(last == null) {
            last = first;
        };
    }

    public void addLast(Item item){
        Node oldLast = last;
        last = new Node(item);
        last.prev = oldLast;
        oldLast.next = last;
        if(first == null) first = last;
    }

    public Item removeFirst(){
        Node oldFirst = first;
        first = oldFirst.next;
        if(first == null) last = first;
        return oldFirst.item;
    }

    public Item removeLast(){
        Node oldLast = last;
        last = oldLast.prev;
        last.next = null;
        if(last == null) first = last;
        return oldLast.item;
    }

    public Iterator<Item> iterator(){
        return null;
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
        Deque d = new Deque();
        d.addFirst(0);
        System.out.println(d);
//        [0]
        d.addFirst(1);
        System.out.println(d);
//        [1,0]
        d.addLast(2);
        System.out.println(d);
//        [1,0,2]
        d.addLast(3);
        System.out.println(d);

        d.addFirst(8);
        System.out.println(d);

        d.removeFirst();
        System.out.println(d);

        d.removeFirst();
        System.out.println(d);

        d.removeLast();
        System.out.println(d);

        d.removeLast();
        System.out.println(d);

        System.out.println(d.isEmpty());
    }

}
