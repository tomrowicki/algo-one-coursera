import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

//    Corner cases.  Throw the specified exception for the following corner cases:
//
// DONE    Throw a java.lang.IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
// DONE    Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.

    private int size = 0;

    private Node first, last;

    public Deque()  {
    }

    public boolean isEmpty() {
        // DONE is the deck empty?
        return size == 0;
    }

    public int size() {
        // DONE return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) {
        // DONE add the item to the front
        if (null == item) {
            throw new IllegalArgumentException("Item cannot be null!");
        }

        Node newFirstNode = new Node();
        newFirstNode.item = item;
        newFirstNode.next = first;
        if (first != null) {
            first.previous = newFirstNode;
        } else {
            last = newFirstNode;
        }
        first = newFirstNode;
        size++;
    }

    public void addLast(Item item) {
        // DONE add the item to the end
        if (null == item) {
            throw new IllegalArgumentException("Item cannot be null!");
        }

        Node newLastNode = new Node();
        newLastNode.item = item;
        newLastNode.previous = last;
        if (last != null ) {
            last.next = newLastNode;
        } else {
            first = newLastNode;
        }
        last = newLastNode;
        size++;
    }

    public Item removeFirst() {
        // DONE remove and return the item from the front
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty deque!");
        }

        Item retrievedFirst = first.item;
        first = first.next;
        if (first != null) {
            first.previous = null;
        }
        size--;
        if (isEmpty()) {
            last = null;
        }
        return retrievedFirst;
    }

    public Item removeLast() {
        // DONE remove and return the item from the end
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty deque!");
        }

        Item retrievedLast = last.item;
        last = last.previous;
        size--;
        if (isEmpty()) {
            first = null;
        }
        return retrievedLast;
    }

    public Iterator<Item> iterator() {
        // DONE return an iterator over items in order from front to end
        return new DequeIterator();
    }

    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            // DONE   Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return!");
            }
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }

        @Override
        public void remove() {
            // DONE    Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
            throw new UnsupportedOperationException();
        }
    }
    // public static void main(String[] args)   // unit testing (optional)
}