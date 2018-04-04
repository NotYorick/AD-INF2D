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
        NewDoublyLinkedList test = Setup();
        test.addAtPos("test7",2);
        assertEquals(test.get(2),"test7");
    }

    @Test
    public void addLast() {
        NewDoublyLinkedList test = Setup();
        test.addLast("test3");
        assertEquals(test.getLast(),"test3");
    }

    @Test
    public void removeFirst() {
        NewDoublyLinkedList test = Setup();
        test.addLast("test3");
        test.removeFirst();
        assertEquals(test.getFirst(),"test2");
    }

    @Test
    public void removeLast() {
        NewDoublyLinkedList test = Setup();
        test.removeLast();
        assertEquals(test.getLast(),"test5");
    }

    @Test
    public void reverse() {
        NewDoublyLinkedList test = Setup();
        test.reverse();
        assertEquals(test.getLast(),"test1");
        assertEquals(test.getFirst(),"test6");
    }

    @Test
    public void getFirst() {
        NewDoublyLinkedList test = Setup();
        assertEquals(test.getFirst(),"test1");
    }

    @Test
    public void getLast() {

        NewDoublyLinkedList test = Setup();
        assertEquals(test.getLast(),"test6");
    }

    public NewDoublyLinkedList Setup(){
        NewDoublyLinkedList test = new NewDoublyLinkedList();
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        test.add("test6");
        return test;
    }
}