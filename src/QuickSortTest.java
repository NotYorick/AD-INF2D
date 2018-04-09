import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gert Jan
 * 
 * Test class for QuickSort
 */
public class QuickSortTest
{
    private int[] testArray;
    private QuickSort sorter;
    
    public QuickSortTest()
    {
        //Set up an array filled with random unsorted values
        testArray = new int[]{4,25,45,12,66,320,10,99,4,201,345,22,43,2,6,67,789,90,100,1};

        //Create an instance of the InsertionSort class
        sorter = new QuickSort(testArray);
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of partition method, of class QuickSort.
     */
    @Test
    public void testPartition()
    {
        System.out.println("partition");
        int lastIndex = testArray.length - 1;
        int testResult = sorter.partition(testArray, 0, lastIndex);
        assertEquals(testResult, 19);
    }


    /**
     * Test of getSortedArray method, of class QuickSort.
     */
    @Test
    public void testGetSortedArray()
    {
        System.out.println("getSortedArray");
        int[] expResult = new int[] {1,2,4,4,6,10,12,22,25,43,45,66,67,90,99,100,201,320,345,789 };
        int[] result = sorter.getSortedArray();
        assertArrayEquals(expResult, result);
    }
	
	/*
     * Test if the t works on the legodataset
     */
    @Test
    public void testLegoDataset() {

        // create an array of int from the itemnumbers and sort the array
        CSVReader csvReader = new CSVReader();
        int[] dataArray = csvReader.getItemNrArray();
        
        sorter = new QuickSort(dataArray);
        int[] correct = dataArray;
        Arrays.sort(correct);

        //Compare the correct array with the sorted array
        assertArrayEquals( correct, dataArray );

    }
    
}
