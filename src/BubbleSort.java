//@author Marco Brink
//@date   04-04-2018

public class BubbleSort {

    BubbleSort(int[] arr) {

        int n = arr.length;
        int temp = 0;

        //The first loop is the amount of iterations over the array
        for(int i=0; i < n; i++){

            //Make the comparison between elements within this loop
            for(int j=1; j < (n-i); j++){

                //when the first element is larger than the second swap elements
                if(arr[j-1] > arr[j]){

                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}



