import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

//    Corner cases.  Throw the specified exception for the following corner cases:
//
// DONE    Throw a java.lang.IllegalArgumentException if the client calls enqueue() with a null argument.
// DONE    Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
// TODO    Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
// TODO    Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.

// TODO gotta use StdRandom

    public RandomizedQueue() {
        // construct an empty randomized queue
    }

    public boolean isEmpty() {
        // TODO is the randomized queue empty?

        return false;
    }

    public int size() {
        // TODO return the number of items on the randomized queue

        return 0;
    }

    public void enqueue(Item item) {
        if (null == item) {
            throw new IllegalArgumentException("Item cannot be null!");
        }

        // TODO add the item
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve from an empty queue!");
        }

        // TODO remove and return a random item

        return null;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve from an empty queue!");
        }

        // TODO return a random item (but do not remove it)

        return null;
    }

    public Iterator<Item> iterator() {
        // TODO return an independent iterator over items in random order

        return null;
    }

    // public static void main(String[] args)   // unit testing (optional)
}
