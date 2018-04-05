import java.util.ArrayList;

public class SequentialSearch {

    public static void main(String[] args) {

    }

    //De zoekopdracht met een array en de tevinden waarde in deze array
    public static int search(ArrayList<String[]> arr, String key){
        //Loop door de array heen tot je bij de gevonden waarde aankomt
        for(int j=0;j<arr.size();j++){
            //Return de plaats van de waarde wanneer deze gevonden is
          
            String id = arr.get(j)[0];
            id = id.replace("\"", "");
            
            if(id.equals(key)){
                return j;
            }
        }
        //Return -1 wanneer de waarde niet gevonden is
        return -1;
    }
}