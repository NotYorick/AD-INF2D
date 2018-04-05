import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class StackTest{
  
  CSVReader csvReader;
  
  
  /**
   
   * @throws java.lang.Exception
   
   */
  
  @Before
  
  public void setUp() throws Exception {
   
   csvReader = new CSVReader();
   
  }
  
  
  @Test
    public void testStack(){
        Stack stack = new Stack();

        Assert.assertEquals(true, stack.empty()); //True, de stack hoort leeg te zijn
    
        ArrayList<String[]> arrayList = new ArrayList<>(csvReader.getLegoArrayList());
  
        stack.push(arrayList.get(12));
        stack.push(arrayList.get(13));
        stack.push(arrayList.get(14));
        stack.push(arrayList.get(15));

        Assert.assertEquals(false, stack.empty()); //False, er zit nu een object in de stack

        stack.pop();

        Assert.assertEquals(arrayList.get(14), stack.peek()); //True, nummer 14 moet nu bovenaan staan

        Assert.assertEquals( 1, stack.search( arrayList.get(13) ) ); //True, 13 zou op index 1 moeten staan
    }
}