import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {
  private static LinkedList<String[]> ll = new LinkedList<>();
  private static String[] llString;
  
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
          ll.add( lego );
        }
        getLegoLinkedList();
        i++;
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static LinkedList<String[]> getLegoLinkedList(){
    return ll;
  
}
  
}