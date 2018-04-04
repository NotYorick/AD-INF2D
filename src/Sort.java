/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gert Jan
 * @version 1.0
 * @date april 2018
 * 
 */
public class Sort
{
    /*
    * This method is used to sort (put in ascending order) an array by using the insertion method, 
    * meaning it starts by sorting the first two elements in the set, 
    * followed by the third and so on untill all elements are on the right place. 
    */
    public int[] insertionSort(int array[])
    {
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
        return array; //return sorted element
    }
    
    /*
        This method is used to sort (put in ascending order ) an array by using the quicksort method,
        meaning it starts by creating a pivot (one value of the array to test against) and see if the other values are higher or lower than the pivot.
        The lower and higher groups will all be sorted as well in the same way with their own pivots untill all is sorted.
        @low the starting index
        @high the ending index
    */
    public int[] quickSort(int array[])
    {
        int lastIndex = array.length - 1; //last index of the array
        sort(array, 0, lastIndex);
        
        return array;
    }
    
    /*
        This method takes the element from the end as the pivot and places all smaller elements left and bigger ones to the right.
        It puts the pivot at the right place.
    */
    public int partition(int array[], int low, int high)
    {
        int pivot = array[high]; //pivot from the end of the array
        int smallIndex = low - 1; //index of the smaller elements
        int swap; //Variable to swap variables around
        
       for(int x = low; x < high; x++)
       {
           //if lower or equal swap array[smallIndex] with array[x]
           if(array[x] <= pivot)
           {
               smallIndex++;
               swap = array[smallIndex];
               array[smallIndex] = array[x];
               array[x] = swap;
           }
       }
       //swap array[smallIndex] with array[high]
       swap = array[smallIndex + 1];
       array[smallIndex + 1] = array[high];
       array[high] = swap;
       
       return smallIndex + 1;
    }
    
    /*
    * This method is the main method of the quickSort, it first uses partition to get the pivot at the right place,
    * then it sorts everything above and below until there's nothing left to sort.
    */
    public void sort(int array[], int low, int high)
    {
        if(low < high)
        {
            int partIndex = partition(array, low, high);
            //sorts everything before partition
            sort(array, low, partIndex - 1);
            //sorts everything after partition
            sort(array, partIndex + 1, high);
        }
    }
    
}
