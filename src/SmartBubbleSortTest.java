import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SmartBubbleSortTest {

    private int[] testArray;
    private SmartBubbleSort sorter;

    /**

     * @throws java.lang.Exception

     */

    @Before

    public void setUp() throws Exception {


    }


    /**

     * Test method for {@link SmartBubbleSort}.

     */

    @Test

    public void testSmartBubbleSortSortedInput() {
        //This array doesn't need any swap
        int[] testArray = new int[] {1,2,4,4,6,10,12,22,25,43,45,66,67,90,99,100,201,320,345,789};

        //Create an instance of the SmartBubbleSort class and sort the collection
        sorter = new SmartBubbleSort(testArray);
        //Because the array is already sorted the should be left unchanged remain false.
        assertFalse(sorter.getFlag());
    }

    /**

     * Test method for {@link SmartBubbleSort}.

     */

    @Test

    public void testSmartBubbleSortUnSortedInput() {
        //Creation of an unsorted array
        int[] testArray = new int[]{4,25,45,12,66,320,10,99,4,201,345,22,43,2,6,67,789,90,100,1};

        //Create an instance of the SmartBubbleSort class and sort the collection
        sorter = new SmartBubbleSort(testArray);

        //Should return true because this is set every time it swaps
        assertTrue(sorter.getFlag());
    }


    /**

     * Test method for {@link BubbleSort}.

     */

    @Test

    public void testLegoDatasetUnordered() {

        // create an array of int from the itemnumbers and sort the array
        CSVReader csvReader = new CSVReader();
        int[] dataArray = csvReader.getItemNrArray();

        sorter = new SmartBubbleSort(dataArray);
        int[] correct = dataArray;
        Arrays.sort(correct);


        //Compare the correct array with the sorted array
        Assert.assertArrayEquals( correct, dataArray );

    }


    /**

     * Test method for {@link BubbleSort}.

     */

    @Test

    public void testLegoDatasetOrdered() {

        // create an array of int from the itemnumbers and sort the array
        CSVReader csvReader = new CSVReader();
        int[] dataArray = csvReader.getItemNrArray();

        int[] correct2 = dataArray;
        Arrays.sort(correct2);

        int[] correct = dataArray;
        Arrays.sort(correct);

        //Because the dataset is already sorted it will exit after one iterations
        sorter = new SmartBubbleSort(correct);


        //Compare the correct array with the sorted array
        //Because the array is already sorted it will go a lot faster
        Assert.assertArrayEquals( correct2, correct );

    }


}