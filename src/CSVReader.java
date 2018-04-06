import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;


public class CSVReader {
  private LinkedList<String[]> ll = new LinkedList<>();
  
  public static void main(String[] arg)
  {
  }
  
  CSVReader() {
    String csvFile = "legosets.csv";
    
    setList(csvFile);
  }
  
  private void setList(String csvFile){
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
  
  public String[][] getLegoArray() {
    String[][] array = ll.toArray(new String[ll.size()][]);
    return array;
  }

  public int[] getItemNrArray() {
    String[][] array2d = getLegoArray();
    int[] array = new int[array2d.length];

    for (int i = 0; i < array2d.length-1; i++)
    {
      String id = array2d[i][0];
      id = id.replace("\"", "");
      array[i] = Integer.parseInt(id);
    }
    return array;
  }
  
}
