import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest {

    protected BinarySearch test;
    @Before
    public void setUp() throws Exception
    {
        test = new BinarySearch();

    }

    @Test
    public void testBinarySearchInt()
    {
        // create a sorted array of ints and test values in the middle, left and right
        int[] array = {1, 4, 6, 8, 9, 12, 31, 35, 56, 77, 89};
        assertThat(test.binarySearchInt(array, 1, 0, array.length), is(0));
        assertThat(test.binarySearchInt(array, 8, 0, array.length), is(3));
        assertThat(test.binarySearchInt(array, 12, 0, array.length), is(5));
        assertThat(test.binarySearchInt(array, 56, 0, array.length), is(8));
        assertThat(test.binarySearchInt(array, 89, 0, array.length), is(10));
        // test to make sure it can't find values that are not in the array
        assertThat(test.binarySearchInt(array, 2, 0, array.length), is(-1));
    }

    @Test
    public void testBinarySearchStringNumbers()
    {
        // create a sorted array of Strings containing the same numbers as the in test
        // again test the middle, left, right
        String[] array = {"01", "04", "06", "08", "09", "12", "31", "35", "56", "77", "89"};
        assertThat(test.binarySearchString(array, "01", 0, array.length), is(0));
        assertThat(test.binarySearchString(array, "77", 0, array.length), is(9));
        assertThat(test.binarySearchString(array, "04", 0, array.length), is(1));
        assertThat(test.binarySearchString(array, "09", 0, array.length), is(4));
        assertThat(test.binarySearchString(array, "12", 0, array.length), is(5));
        assertThat(test.binarySearchString(array, "89", 0, array.length), is(10));
        // test to make sure it can't find values that are not in the array
        assertThat(test.binarySearchString(array, "02", 0, array.length), is(-1));
    }

    @Test
    public void testBinarySearchStringWords()
    {
        // create a sorted array of Strings and test values in middle, left and right
        String[] array = {"aaa", "aab", "abb", "bbb", "ccd", "eax", "ewc", "lkl", "qwe", "xsx", "zzz"};
        assertThat(test.binarySearchString(array, "aaa", 0, array.length), is(0));
        assertThat(test.binarySearchString(array, "lkl", 0, array.length), is(7));
        assertThat(test.binarySearchString(array, "abb", 0, array.length), is(2));
        assertThat(test.binarySearchString(array, "bbb", 0, array.length), is(3));
        assertThat(test.binarySearchString(array, "ewc", 0, array.length), is(6));
        assertThat(test.binarySearchString(array, "zzz", 0, array.length), is(10));
        // test to make sure it can't find values that are not in the array
        assertThat(test.binarySearchString(array, "nouditgaatdusnietwerken", 0, array.length), is(-1));
    }

    @Test
    public void testBinarySearchLegoDataset()
    {
        // create an array of int from the itemnumbers and sort the array
        CSVReader csvReader = new CSVReader();
        int[] dataArray = csvReader.getItemNrArray();
        Arrays.sort(dataArray);

        // test some values from the lego dataset
        assertThat(test.binarySearchInt(dataArray, 5, 0, dataArray.length), is(1));
        assertThat(test.binarySearchInt(dataArray, 6031641, 0, dataArray.length), is(dataArray.length-1));
        assertThat(test.binarySearchInt(dataArray, 5969, 0, dataArray.length), is(2018));
        // test to make sure it can't find values that are not in the array
        assertThat(test.binarySearchInt(dataArray, 1, 0, dataArray.length-1), is(-1));
    }
}