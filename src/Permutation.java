import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args){
        Integer k = Integer.valueOf(args[0]);
        RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
        while(!StdIn.isEmpty()){
            String input = StdIn.readString();
            rQueue.enqueue(input);
        }
        for(Integer i = 0; i < k; i++){
            String value = rQueue.dequeue();
            System.out.println(value);
        }
    }
}
