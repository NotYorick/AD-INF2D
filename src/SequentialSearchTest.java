import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

class SequentialSearchTest{

    static void main(String[] args){}

    @Test
    void testSeq(){
        SequentialSearch search = new SequentialSearch();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(929);
        arrayList.add(327);
        arrayList.add(69);
        arrayList.add(8);


        int resultTrue = search.search(arrayList, 69);
        Assert.assertTrue("True, juiste plaats", resultTrue == 3); //true, deze staat op de juiste plaats

        int resultTrue2 = search.search(arrayList, 1337);
        Assert.assertTrue("True, zit niet in de lijst", resultTrue2 == -1); //true, deze zit niet in de lijst

        int resultFalse = search.search(arrayList, 13);
        Assert.assertFalse("False, verkeerde plaats + wordt niet verwacht", resultFalse == 1); //false, deze zit niet in de list, en word dus ook niet verwacht op plaats 1

        int resultFalse2 = search.search(arrayList, 8);
        Assert.assertFalse("False, niet op de juiste plaats", resultFalse2 == 3); //false, deze zit wel in de lijs maar wordt niet verwacht op plaats 3
    }
}