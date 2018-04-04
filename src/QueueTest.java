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
        assertNull(testqueue.poll());

        testqueue.offer(1);
        testqueue.offer(2);
        testqueue.offer(3);
        assertThat(testqueue.poll(), is(new Integer(1)));
        assertThat(testqueue.poll(), is(new Integer(2)));
        assertThat(testqueue.poll(), is(new Integer(3)));
    }

    @Test
    public void testPeek() {
        assertNull(testqueue.peek());
        testqueue.offer(1);
        testqueue.offer(2);
        testqueue.offer(3);
        assertThat(testqueue.peek(), is(new Integer(1)));
    }
}
