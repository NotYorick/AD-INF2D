import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NewDoublyLinkedListTest {


    protected NewDoublyLinkedList collection;
    CSVReader lego;
    ArrayList<String[]> array;

    @Before
    public void setUp() throws Exception {  //laad de lego array in om te gebruiken in alle testen.
        lego = new CSVReader();
        array = lego.getLegoArrayList();
        collection = new NewDoublyLinkedList();

        for(String[] number : array){
            String numb = number[0];
            numb = numb.replace("\"", "");
            collection.add(Integer.parseInt(numb)); //Voegt alle elementen toe aan de newlinkedlist
        }
    }

    @Test
    public void addFirst() { // test of de add first werkt

        collection.addFirst(0000);
        collection.addFirst(0001);
        assertEquals(collection.getFirst(),0001);
    }

    @Test
    public void add() { // test voor het toevoegen

        collection.add("test");
        assertEquals(collection.getLast(),"test");
    }

    @Test
    public void addAtPos() {

        collection.addAtPos("test7",2);   // voegt waarde op pos 2 toe
        assertEquals(collection.get(2),"test7");  // controlleerd of pos 2 waarde test7 heeft
    }

    @Test
    public void addLast() {
        collection.addLast("test3");  // voegt waarde in de tail
        assertEquals(collection.getLast(),"test3");   //controlleerd of waarde tail element test3 heeft
    }

    @Test
    public void removeFirst() {
        collection.addFirst("test");
        collection.addFirst("test2");
        collection.removeFirst(); //verwijderd de head waarde
        assertEquals(collection.getFirst(),"test");
    }

    @Test
    public void removeLast() {
        collection.addLast("test");
        collection.addLast("test1");
        collection.removeLast();
        assertEquals(collection.getLast(),"test");
    }

    @Test
    public void reverse() {
        collection.addLast("test1");
        collection.addFirst("test");        //voegt waarde aan first en last om zo de reverse te controlleren
        collection.reverse();
        assertEquals(collection.getLast(),"test");
        assertEquals(collection.getFirst(),"test1");
    }

    @Test
    public void getFirst() {
        collection.addFirst("test");        // voegt first toe
        assertEquals(collection.getFirst(),"test"); // controlleerd op waarde van first
    }

    @Test
    public void getLast() {
        collection.addLast("test");     //voegt last toe
        assertEquals(collection.getLast(),"test");  //kijkt naar de waarde van last
    }
}