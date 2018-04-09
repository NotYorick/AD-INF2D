import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gert Jan
 * 
 * Test class for BinarySearchTree
 */
public class BinarySearchTreeTest
{
    private int[] testSortedArray;
    private BinarySearchTree BTS;
    
    public BinarySearchTreeTest()
    {
        //Set up an array filled with random unsorted values
        testSortedArray = new int[]{1,2,4,4,6,10,12,22,25,43,45,66,67,90,99,100,201,320,345,789 };

        //Create an instance of the InsertionSort class
        BTS = new BinarySearchTree(testSortedArray);
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
     * Test of sortedArrayToBST, search and getRoot method, of class BinarySearchTree.
     */
    @Test
    public void testSortedArrayBSTFunctions()
    {
        System.out.println("sortedArrayToBST, Search, getRoot");
        int result = BTS.search(BTS.getRoot(),6).key;
        assertEquals(result, 6);
    }

    /**
     * Test of search method for invalid values (valid has already been tested), of class BinarySearchTree.
     */
    @Test(expected=NullPointerException.class)
    public void testSearch()
    {
        int result = BTS.search(BTS.getRoot(),7).key;
    }

    /**
     * Test of insert method, of class BinarySearchTree.
     */
    @Test
    public void testInsert()
    {
        System.out.println("insert");
        int key = 7;
        BTS.insert(key);
        int result = BTS.search(BTS.getRoot(),7).key;
        assertEquals(result,7);
    }

    /**
     * Test of deleteNode and MinValue methods, of class BinarySearchTree.
     */
    @Test(expected=NullPointerException.class)
    public void testDeleteNodeMinValue()
    {
        System.out.println("deleteNode");
        int key = 6;
        BTS.deleteNode(key);
        int result = BTS.search(BTS.getRoot(),7).key;
    }
	
	/*
     * Test if the tree works with the legodataset
     */
    @Test
    public void testLegoDataset() {

        // create an array of int from the itemnumbers and sort the array
        CSVReader csvReader = new CSVReader();
        int[] dataArray = csvReader.getItemNrArray();
        
        int[] sorted = dataArray;
        Arrays.sort(sorted);
        BTS = new BinarySearchTree(sorted);

        //checks wheter value exists in the tree
        int result = BTS.search(BTS.getRoot(),10600).key;
        assertEquals(result, 10600);
    }

}
