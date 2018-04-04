/**
 *
 * @author Gert Jan
 * @version 1.0
 * @date april 2018
 * 
 *
 * This method is used to sort (put in ascending order ) an array by using the quicksort method,
 * meaning it starts by creating a pivot (one value of the array to test against) and see if the other values are higher or lower than the pivot.
 * The lower and higher groups will all be sorted as well in the same way with their own pivots untill all is sorted.
 * @low the starting index
 * @high the ending index
 *
 */

public class QuickSort
{
     private int[] sortedArray;
     
     public QuickSort(int array[])
    {
        this.sortedArray = array;
        int lastIndex = array.length - 1; //last index of the array
        sort(array, 0, lastIndex);

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
    
    public int[] getSortedArray()
    {
        return sortedArray;
    }
    
}
