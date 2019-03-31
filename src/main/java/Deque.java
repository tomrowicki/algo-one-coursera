import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

//    Corner cases.  Throw the specified exception for the following corner cases:
//
// DONE    Throw a java.lang.IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
// DONE    Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
// TODO   Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
// TODO    Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.

    public Deque()  {
    }

    public boolean isEmpty() {
        // TODO is the deck empty?
        return false;
    }

    public int size() {
        // TODO return the number of items on the deque
        return 0;
    }

    public void addFirst(Item item) {
        // TODO add the item to the front
        if (null == item) {
            throw new IllegalArgumentException("Item cannot be null!");
        }
    }

    public void addLast(Item item) {
        // TODO add the item to the end
        if (null == item) {
            throw new IllegalArgumentException("Item cannot be null!");
        }
    }

    public Item removeFirst() {
        // TODO remove and return the item from the front
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty deque!");
        }

        return null;
    }

    public Item removeLast() {
        // TODO remove and return the item from the end
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty deque!");
        }

        return null;
    }
    public Iterator<Item> iterator() {
        // TODO return an iterator over items in order from front to end
        return null;
    }

    // public static void main(String[] args)   // unit testing (optional)
}