import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

//    Corner cases.  Throw the specified exception for the following corner cases:
//
// DONE    Throw a java.lang.IllegalArgumentException if the client calls enqueue() with a null argument.
// DONE    Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.

    private int size = 0;

    private Node first, last;

    public RandomizedQueue() {
        // construct an empty randomized queue
    }

    public boolean isEmpty() {
        // DONE is the randomized queue empty?

        return size == 0;
    }

    public int size() {
        // DONE return the number of items on the randomized queue

        return size;
    }

    public void enqueue(Item item) {
        if (null == item) {
            throw new IllegalArgumentException("Item cannot be null!");
        }

        // DONE add the item
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve from an empty queue!");
        }

        // DONE remove and return a random item
        int randomInt = StdRandom.uniform(size);
        Node previousItemNode = null;
        Node itemNode = first;
        int counter = 0;
        while (counter < randomInt) {
            if (counter +1 == randomInt) {
                previousItemNode = itemNode;
            }
            itemNode = itemNode.next;
            counter++;
        }
        if (previousItemNode != null) {
            mergePenultimateAndNext(previousItemNode, itemNode);
        } else {
            // first item is selected at random
            if (itemNode.next != null) {
                first = itemNode.next;
            }
        }
        if (isEmpty()) {
            last = null;
        }
        size --;
        return itemNode.item;
    }

    private void mergePenultimateAndNext(Node previousItemNode, Node itemNode) {
        if (itemNode.next == null) {
            // last item is selected at random
            last = previousItemNode;
            last.next = null;
        } else {
            // middle item is selected at random
            previousItemNode.next = itemNode.next;
        }
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot retrieve from an empty queue!");
        }

        int randomInt = StdRandom.uniform(size);
        // DONE return a random item (but do not remove it)
        Iterator<Item> iterator = iterator();
        Item sampleItem = first.item;
        int counter = 0;
        while (counter <= randomInt) {
            sampleItem = iterator.next();
            counter++;
        }
        return sampleItem;
    }

    public Iterator<Item> iterator() {
        // DONE return an independent iterator over items in random order

        return new MyQueueIterator();
    }

    // public static void main(String[] args)   // unit testing (optional)

    private class Node
    {
        Item item;
        Node next;
    }

    private class MyQueueIterator implements Iterator<Item> {

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
}
