import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SequentialSearchTest{
    
    @Test
    public void testSeq(){
        SequentialSearch search = new SequentialSearch();
        CSVReader csvReader = new CSVReader();
        
        ArrayList<String[]> arrayList = new ArrayList<>(csvReader.getLegoArrayList());
        
        int resultTrue = search.search(arrayList, "7260");
        
        Assert.assertTrue("True, juiste plaats", resultTrue == 3257); //true, deze staat op de juiste plaats

        int resultTrue2 = search.search(arrayList, "False");
        Assert.assertTrue("True, zit niet in de lijst", resultTrue2 == -1); //true, deze zit niet in de lijst

        int resultFalse = search.search(arrayList, "False");
        Assert.assertFalse("False, verkeerde plaats + wordt niet verwacht", resultFalse == 1); //false, deze zit niet in de list, en word dus ook niet verwacht op plaats 1

        int resultFalse2 = search.search(arrayList, "30283");
        Assert.assertFalse("False, niet op de juiste plaats", resultFalse2 == 2); //false, deze zit wel in de lijs maar wordt niet verwacht op plaats 3
    }
}