import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

class StackTest{

    static void main(String[] args){}

    @Test
    void testStack(){
        Stack stack = new Stack();

        Assert.assertEquals(true, stack.empty()); //True, de stack hoort leeg te zijn

        ArrayList<Integer> arrayList = new ArrayList<>();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);

        Assert.assertEquals(false, stack.empty()); //False, er zit nu een object in de stack

        stack.pop();

        Assert.assertEquals(14, stack.peek()); //True, nummer 14 moet nu bovenaan staan

        Assert.assertEquals( 2, stack.search( 13 ) ); //True, 13 zou op index 2 moeten staan
    }
}