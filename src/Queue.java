import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue<E> extends LinkedList<E>
{
    private LinkedList<E> list = new LinkedList<E>();

    public boolean offer(E e)
    {
        // add function from Collection returns true if the Collection changed
        list.add(e);
        return list.contains(e);
    }

    public E peek()
    {
        // check if the list is empty
        if (list.size() == 0)
        {
            return null;
        }
        // return the first element of the list
        E first = list.getFirst();
        return first;
    }

    public E poll()
    {
        // check if the list is empty
        if (list.size() == 0)
        {
            return null;
        }
        // store the element that will be removed to return it later
        E oldfirst = list.getFirst();
        list.remove(oldfirst);
        return oldfirst;
    }
}