import java.util.ArrayList;

public class SequentialSearch {

    public static void main(String[] args) {

    }

    //De zoekopdracht met een array en de tevinden waarde in deze array
    public static int search(ArrayList<Integer> arr, int key){
        //Loop door de array heen tot je bij de gevonden waarde aankomt
        for(int i=0;i<arr.size();i++){
            //Return de plaats van de waarde wanneer deze gevonden is
            if(arr.get(i) == key){
                return i;
            }
        }
        //Return -1 wanneer de waarde niet gevonden is
        return -1;
    }
}