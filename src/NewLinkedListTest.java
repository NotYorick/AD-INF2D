import org.junit.Test;

import static org.junit.Assert.*;

public class NewLinkedListTest {

    @Test
    public void add() {
        NewLinkedList test = new NewLinkedList();
        test.add("test");
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        assertEquals(test.get(3),"test3");
        assertEquals(test.get(2),"test2");
        assertEquals(test.get(1),"test1");
    }

    @Test
    public void contains() {
        NewLinkedList test = new NewLinkedList();
        test.add("test");
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        assertEquals(test.contains("test5"),true);
        assertEquals(test.contains("test7"),false);
    }

    @Test
    public void indexOf() {
        NewLinkedList test = new NewLinkedList();
        test.add("test");
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        assertEquals(test.indexOf("test4"),4);
        assertEquals(test.indexOf("test5"),5);
    }

    @Test
    public void remove() {
        NewLinkedList test = new NewLinkedList();
        test.add("test");
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        test.remove(3);
        assertEquals(test.contains("test3"),false);
    }
}