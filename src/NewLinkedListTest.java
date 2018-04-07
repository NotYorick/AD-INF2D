import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NewLinkedListTest {

    protected NewLinkedList collection;
    CSVReader lego;
    ArrayList<String[]> array;

    @Before
    public void setUp() throws Exception {
        lego = new CSVReader();
        array = lego.getLegoArrayList();
        collection = new NewLinkedList();

        for(String[] number : array){
            String numb = number[0];
            numb = numb.replace("\"", "");
            collection.add(Integer.parseInt(numb));
        }
    }

    @Test
    public void add() {
        assertEquals(collection.get(0),10246);
        assertEquals(collection.get(1),10247);
        assertEquals(collection.get(2),10248);
        assertEquals(collection.get(18),10596);
    }

    @Test
    public void contains() {
        assertEquals(collection.contains(3170),true);
        assertEquals(collection.contains(10246),true);
        assertEquals(collection.contains(99999999),false);
    }

    @Test
    public void indexOf() {
        int count = 0;
        for(Object o : collection){

            assertEquals(collection.indexOf(o),count);
            count++;
            if(count > 100){
                break;
            }
        }
    }

    @Test
    public void remove() {
        collection.remove(0);
        assertEquals(collection.contains(10246),false);

    }
}