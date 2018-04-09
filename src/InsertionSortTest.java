import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gert Jan
 * 
 * Test class for InsertionSort
 */
public class InsertionSortTest
{
    private int[] testArray;
    private InsertionSort sorter;
    
    public InsertionSortTest()
    {
        //Set up an array filled with random unsorted values
        testArray = new int[]{4,25,45,12,66,320,10,99,4,201,345,22,43,2,6,67,789,90,100,1};

        //Create an instance of the InsertionSort class
        sorter = new InsertionSort(testArray);
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
     * Test wheter the array is sorted properly.
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
     * Test if the sort works on the legodataset
     */
    @Test
    public void testLegoDataset() {

        // create an array of int from the itemnumbers and sort the array
        CSVReader csvReader = new CSVReader();
        int[] dataArray = csvReader.getItemNrArray();

        sorter = new InsertionSort(dataArray);
        int[] correct = dataArray;
        Arrays.sort(correct);


        //Compare the correct array with the sorted array
        assertArrayEquals( correct, dataArray );

    }
    
}
