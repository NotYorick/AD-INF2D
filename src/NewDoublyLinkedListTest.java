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
        assertEquals(test.getFirst(),"test3");
    }

    @Test
    public void addAtPos() {
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
}