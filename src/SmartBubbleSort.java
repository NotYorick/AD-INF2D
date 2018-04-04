//@author Marco Brink
//@date   04-04-2018

import java.io.Console;

public class SmartBubbleSort {

    boolean flag = false;

    SmartBubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;


        outerloop:
        for(int i = 0; i < n; i++){

            //When there haven't been any swaps after the first completer iteration
            //the process can stop immediately because the collection is already ordered.

            if(flag == false && i > 0)
            {
                break outerloop;
            }

            for(int j=1; j < (n-i); j++){

                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }
    }

    //Method that can be used to check the value of flag
    public boolean getFlag()
    {
        return flag;
    }



}

