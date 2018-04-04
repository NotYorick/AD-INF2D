import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewDoublyLinkedListTest {

    @Test
    public void addFirst() {
        NewDoublyLinkedList test = new NewDoublyLinkedList();
        test.addFirst("test");
        test.addFirst("test1");
        test.addFirst("test2");
        test.addFirst("test3");
        test.addFirst("test4");
        test.addFirst("test5");
        assertEquals(test.getFirst(),"test5");
    }

    @Test
    public void add() {
        NewDoublyLinkedList test = new NewDoublyLinkedList();
        test.add("test");
        assertEquals(test.getFirst(),"test");
    }

    @Test
    public void addAtPos() {
        NewDoublyLinkedList test = new NewDoublyLinkedList();
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        test.add("test6");
        test.addAtPos("test7",2);
        assertEquals(test.get(2),"test7");
    }

    @Test
    public void addLast() {
    }

    @Test
    public void iterateForward() {
    }

    @Test
    public void iterateBackward() {
    }

    @Test
    public void removeFirst() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void reverse() {
    }
}