import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;


public class CSVReader {
  private static LinkedList<String[]> ll = new LinkedList<>();
  
  public static void main(String[] args) {
  
    String csvFile = "legosets.csv";
    String line = "";
    String cvsSplitBy = ",";
    
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      int i = 0;
      while ((line = br.readLine()) != null) {
        
        // use comma as separator
        String[] lego = line.split(cvsSplitBy);
  
        if(i > 0){
          if(Pattern.matches("^[a-zA-Z]+$", lego[0]) == false){
            ll.add( lego );
            System.out.println(lego[0]);
          }
        }
        i++;
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public LinkedList<String[]> getLegoLinkedList() {
    return ll;
  }
  
  public ArrayList<String[]> getLegoArrayList() {
    ArrayList<String[]> al = new ArrayList<>( ll );
    return al;
  }
  
  public String[] getLegoArray() {
    String[] array = new String[ll.size()];
    array = ll.toArray(array);
    return array;
  }
  
}
