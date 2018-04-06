//import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    protected Queue<Integer> testqueue;
    CSVReader csvReader;

    @Before
    public void setUp() throws Exception {
        testqueue = new Queue<>();
        csvReader = new CSVReader();

    }

    @Test
    public void testPollAndOffer() {
        // test if empty queue returns null
        assertNull(testqueue.poll());
        // test if poll takes the right order of values out
        testqueue.offer(1);
        testqueue.offer(2);
        testqueue.offer(3);
        assertThat(testqueue.poll(), is(1));
        assertThat(testqueue.poll(), is(2));
        assertThat(testqueue.poll(), is(3));
    }

    @Test
    public void testPeek() {
        // test if empty queue returns null
        assertNull(testqueue.peek());
        // test if peek returns the head
        testqueue.offer(1);
        testqueue.offer(2);
        testqueue.offer(3);
        assertThat(testqueue.peek(), is(1));
        assertThat(testqueue.peek(), is(1));
    }

    @Test
    public void testQueueDataset() {
        // create Queue that can take the data from the ArrayList
        Queue<String[]> datasetqueue = new Queue<>();
        ArrayList<String[]> arrayList = new ArrayList<>(csvReader.getLegoArrayList());

        // offer all arrays from the ArrayList to the Queue
        for (String[] array : arrayList) {
            datasetqueue.offer(array);
        }

        // test if the values come out in the right order
        assertThat(datasetqueue.peek(), is(arrayList.get(0)));
        assertThat(datasetqueue.poll(), is(arrayList.get(0)));
        assertThat(datasetqueue.poll(), is(arrayList.get(1)));
        assertThat(datasetqueue.poll(), is(arrayList.get(2)));
        assertThat(datasetqueue.poll(), is(arrayList.get(3)));
        assertThat(datasetqueue.poll(), is(arrayList.get(4)));
    }
}
