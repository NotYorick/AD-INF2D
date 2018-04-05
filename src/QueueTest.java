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

    @Before
    public void setUp() throws Exception {
        testqueue = new Queue<>();
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
}
