import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizeQueue<Item> implements Iterable<Item>{
    private Item[] queue;
    private int N = 0;

    public RandomizeQueue() {
        queue = (Item[]) new Object[1];
    }

    private void resize(int capacity){
        Item[] newQueue = (Item[]) new Object[capacity];
        for(int i = 0; i < queue.length; i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        queue[N] = item;
        N++;
        if(N == queue.length) resize(N * 2);
    };

    private void validateQueueIsNotEmpty(){
        if(N == 0){
            throw new NoSuchElementException();
        }
    }


    //Todo: optimize size array
    public Item dequeue(){
        this.validateQueueIsNotEmpty();
        Integer randomIndex = StdRandom.uniform(N);
        Item aux = queue[randomIndex];
        N--;
        queue[randomIndex] = queue[N];
        return aux;
    }

    public Item sample(){
        this.validateQueueIsNotEmpty();
        Integer randomIndex = StdRandom.uniform(N);
        Item aux = queue[randomIndex];
        return aux;
    }

    private class ListIterator implements Iterator<Item>{
        Integer currentIndex;
        Item[] queueCopy;

        ListIterator(){
            this.currentIndex = N;
            queueCopy = (Item[]) new Object[N+1];
            for(int i = 0; i < N; i++){
                queueCopy[i] = queue[i];
            }
        }

        @Override
        public boolean hasNext() {
            return currentIndex != 0;
        }

        //TODO: resize arrray
        @Override
        public Item next() {
            if(hasNext() == false){
                throw new NoSuchElementException();
            }
            Integer randomIndex = StdRandom.uniform(currentIndex);
            Item value = queueCopy[randomIndex];
            currentIndex--;
            queueCopy[randomIndex] = queueCopy[currentIndex];
            return value;
        }
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    public static void main(String[] args){
        RandomizeQueue<Integer> r = new RandomizeQueue<Integer>();
        r.enqueue(4);
        r.enqueue(8);
        r.enqueue(3);
        for(Integer i:r){
            System.out.println(i);
        }
        r.dequeue();
        r.dequeue();
        System.out.println(r.sample());
        r.dequeue();
        for(Integer i:r){
            System.out.println(i);
        }
    }



}
