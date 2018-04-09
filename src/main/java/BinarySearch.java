public class BinarySearch {

    public int binarySearchInt(int[] array, int key, int start, int end)
    {
        // if the key isn't in the array, the recursion will call this method with start greater than end
        if (end <= start)
        {
            return -1;
        }

        // take the middle of the array and compare it to the key
        int middle = (start + end) / 2;
        if (array[middle] == key)
        {
            return middle;
        }
        else if (key < array[middle])
        {
            // binarySearch on the left half
            return binarySearchInt(array, key, start, middle);
        }
        else
        {
            // binarySearch on the right half
            return binarySearchInt(array, key, middle + 1, end);
        }
    }

    public int binarySearchString(String[] array, String key, int start, int end)
    {
        // if the key isn't in the array, the recursion will call this method with start greater than end
        if (end <= start)
        {
            return -1;
        }

        // take the middel of the array
        int middle = start + (end - start) / 2;
        // compare the string value of the middle to the key
        int cmp = array[middle].compareTo(key);
        if (cmp == 0)
        {
            // return the index of the key
            return middle;
        }
        else if (cmp > 0)
        {
            // binarySearchString on the left half
            return binarySearchString(array, key, start, middle);
        }
        else
        {
            // binarySearchString on the right half
            return binarySearchString(array, key, middle + 1, end);
        }
    }
}
