import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Result> results = new ArrayList<>();
        results.add(JUnitCore.runClasses(NewDoublyLinkedListTest.class));
        results.add(JUnitCore.runClasses(BinarySearchTree.class));
        results.add(JUnitCore.runClasses(BubbleSortTest.class));
        results.add(JUnitCore.runClasses(BinarySearchTreeTest.class));
        results.add(JUnitCore.runClasses(InsertionSortTest.class));
        results.add(JUnitCore.runClasses(NewLinkedListTest.class));
        results.add(JUnitCore.runClasses(QueueTest.class));
        results.add(JUnitCore.runClasses(QuickSortTest.class));
        results.add(JUnitCore.runClasses(SequentialSearchTest.class));
        results.add(JUnitCore.runClasses(SmartBubbleSortTest.class));
        results.add(JUnitCore.runClasses(StackTest.class));

        Result result = JUnitCore.runClasses(NewDoublyLinkedListTest.class);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Tests started");
        for(Result res : results){
            for (Failure failure : res.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        System.out.println("Tests done --> " + result.wasSuccessful() + " : Test completed");
        System.out.println("------------------------------------------------------------------");
    }
}
