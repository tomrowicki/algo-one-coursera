import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class Week2Tests {

    @Test
    public void frontDequeTest() {
        Deque<String> myDeque = new Deque<>();
        myDeque.addFirst("first");
        assertEquals(1, myDeque.size());
        String removedFirst = myDeque.removeFirst();
        assertEquals("first", removedFirst);
        assertEquals(0, myDeque.size());
    }

    @Test
    public void backDequeTest() {
        Deque<String> myDeque = new Deque<>();
        myDeque.addLast("last");
        assertEquals(1, myDeque.size());
        String removedLast = myDeque.removeLast();
        assertEquals("last", removedLast);
        assertEquals(0, myDeque.size());
    }

    @Test
    public void onlineTest() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        int removed = deque.removeLast();
        assertEquals(1, removed);
        deque.addFirst(3);
        removed = deque.removeLast();
        assertEquals(3, removed);
    }

    @Test
    public void dequeTest() {
        Deque<String> myDeque = new Deque<>();
        myDeque.addFirst("First-first");
        myDeque.addFirst("First-second");
        myDeque.addLast("Last-first");
        myDeque.addLast("Last-second");

        assertEquals("First-second", myDeque.removeFirst());
        assertEquals("Last-second", myDeque.removeLast());
        assertEquals("Last-first", myDeque.removeLast());
        assertEquals("First-first", myDeque.removeLast());
    }

    @Test
    public void randomizedSampleTest() throws IOException, URISyntaxException {
        List<String> contents = FileReader.getFileContents("week2/distinct.txt");
        String[] characters = contents.get(0).split(" ");
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
        System.out.println("Original sequence: ");
        for (String character : characters) {
            System.out.println(character);
            rQueue.enqueue(character);
        }
        Set<String> set = new HashSet<>();
        for(int i=0; i<10; i++) {
            String sample = rQueue.sample();
            System.out.println("Obtained sample: " + sample);
            set.add(sample);
        }
        assertTrue(set.size() > 1);
    }

    @Test
    public void simplifiedRandomizedDequeingTest() {
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
        rQueue.enqueue("A");
        rQueue.enqueue("B");
        rQueue.enqueue("C");
        assertEquals(3, rQueue.size());
        System.out.println(rQueue.dequeue());
        assertEquals(2, rQueue.size());
        System.out.println(rQueue.dequeue());
        assertEquals(1, rQueue.size());
        System.out.println(rQueue.dequeue());
        assertEquals(0, rQueue.size());
    }

    @Test
    public void randomizedQueueTest() throws IOException, URISyntaxException {
        List<String> contents = FileReader.getFileContents("week2/distinct.txt");
        String[] characters = contents.get(0).split(" ");
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
        System.out.println("Original sequence: ");
        for (String character : characters) {
            System.out.println(character);
            rQueue.enqueue(character);
        }
        String[] randomizedArray = convertQueueToArray(rQueue);
        System.out.println("Randomized sequence: ");
        for (String character : randomizedArray) {
            System.out.println(character);
        }
        assertFalse(randomizedArray.equals(characters));
    }

    private String[] convertQueueToArray(RandomizedQueue<String> rQueue) {
        String[] ar = new String[rQueue.size()];
        int counter = 0;
        while (!rQueue.isEmpty()) {
            ar[counter] = rQueue.dequeue();
            counter++;
        }
        return ar;
    }
}

