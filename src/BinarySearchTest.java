import org.junit.Before;
import org.junit.Test;

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
        int[] array = {1, 4, 6, 8, 9, 12, 31, 35, 56, 77, 89};
        assertThat(test.binarySearch(array, 1, 0, array.length), is(0));
        assertThat(test.binarySearch(array, 56, 0, array.length), is(8));
        assertThat(test.binarySearch(array, 8, 0, array.length), is(3));
        assertThat(test.binarySearch(array, 89, 0, array.length), is(10));
        assertThat(test.binarySearch(array, 2, 0, array.length), is(-1));
    }

    @Test
    public void testBinarySearchStringNumbers()
    {
        String[] array = {"01", "04", "06", "08", "09", "12", "31", "35", "56", "77", "89"};
        assertThat(test.binarySearchString(array, "01", 0, array.length), is(0));
        assertThat(test.binarySearchString(array, "77", 0, array.length), is(9));
        assertThat(test.binarySearchString(array, "04", 0, array.length), is(1));
        assertThat(test.binarySearchString(array, "09", 0, array.length), is(4));
        assertThat(test.binarySearchString(array, "12", 0, array.length), is(5));
        assertThat(test.binarySearchString(array, "89", 0, array.length), is(10));
        assertThat(test.binarySearchString(array, "02", 0, array.length), is(-1));
    }

    @Test
    public void testBinarySearchStringWords()
    {
        String[] array = {"aaa", "aab", "abb", "bbb", "ccd", "eax", "ewc", "lkl", "qwe", "xsx", "zzz"};
        assertThat(test.binarySearchString(array, "aaa", 0, array.length), is(0));
        assertThat(test.binarySearchString(array, "xsx", 0, array.length), is(9));
        assertThat(test.binarySearchString(array, "aab", 0, array.length), is(1));
        assertThat(test.binarySearchString(array, "ccd", 0, array.length), is(4));
        assertThat(test.binarySearchString(array, "eax", 0, array.length), is(5));
        assertThat(test.binarySearchString(array, "zzz", 0, array.length), is(10));
        assertThat(test.binarySearchString(array, "nouditgaatdusnietwerken", 0, array.length), is(-1));
    }
}