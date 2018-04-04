import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

public class BubbleSortTest {
    private int[] testArray;
    private BubbleSort sorter;

    /**

     * @throws java.lang.Exception

     */

    @Before

    public void setUp() throws Exception {

        //Set up an array filled with random unsorted values
        testArray = new int[]{4,25,45,12,66,320,10,99,4,201,345,22,43,2,6,67,789,90,100,1};

        //Create an instance of the BubbleSort class
        sorter = new BubbleSort(testArray);

    }


    /**

     * Test method for {@link BubbleSort}.

     */

    @Test

    public void testBubbleSort() {

        //This should be the result after the array has been sorted
        int[] correctOutcome = new int[] {1,2,4,4,6,10,12,22,25,43,45,66,67,90,99,100,201,320,345,789 };

        //Compare the correct array with the sorted array
        Assert.assertArrayEquals( correctOutcome, testArray );


    }


}