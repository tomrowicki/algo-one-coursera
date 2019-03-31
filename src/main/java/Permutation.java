import edu.princeton.cs.algs4.StdIn;

/**
 * Week 2 homework.
 */
public class Permutation {

    public static void main(String[] args) {
        // DONE Write a client program Permutation.java that takes an integer k as a command-line argument;
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            // DONE reads in a sequence of strings from standard input using StdIn.readString();
            String input = StdIn.readString();
            queue.enqueue(input);
        }
        // DONE and prints exactly k of them, uniformly at random. Print each item from the sequence at most once.
        printRandomItemsKTimes(k, queue);
    }

    private static void printRandomItemsKTimes(int k, RandomizedQueue<String> queue) {
        for (int i=0; i<k; i++) {
            System.out.println(queue.dequeue());
        }
    }
}