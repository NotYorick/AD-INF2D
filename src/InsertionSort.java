/**
 *
 * @author Gert Jan
 * @version 1.0
 * @date april 2018
 * 
 * This class is used to sort (put in ascending order) an array by using the insertion method, 
 * meaning it starts by sorting the first two elements in the set, 
 * followed by the third and so on untill all elements are on the right place. 
 */

public class InsertionSort
{
    private int[] sortedArray;
    
    public InsertionSort(int array[])
    {
        this.sortedArray = array;
        int arrLength = array.length; //length of the array to sort
        //check every element with the ones to the left of it starting from position 1.
        for(int x = 1; x < arrLength; x++)
        {
            int currentElement = array[x]; //the element to check the order of
            int prevElemLoc = x - 1;  //the location of the element to check the current element with

            //Moves the array elements greater than the currentElement to the left in the array untill it's no longer greater.
            while (prevElemLoc >= 0 && array[prevElemLoc] > currentElement) // while the previous element is greater than the current
            {
                array[prevElemLoc + 1] = array[prevElemLoc]; // put value of previous element in the one to the right of it.
                prevElemLoc = prevElemLoc - 1; //change element location to check to the one left of it.
            }
            array[prevElemLoc + 1] = currentElement; //put the current element on the right of the last checked element.
        }
    }
    
    public int[] getSortedArray()
    {
        return sortedArray;
    }
}
