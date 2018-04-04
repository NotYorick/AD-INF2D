import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue<E> extends LinkedList<E>
{
    private LinkedList<E> list = new LinkedList<E>();

    public boolean add(E e)
    {

        return false;
    }

    public boolean offer(E e)
    {
        //
        list.addLast(e);
        return true;
    }

    public E peek(E e)
    {
        return list.getFirst();
    }

    public E poll()
    {
        if (list.size() == 0)
        {
            return null;
        }
        E oldfirst = list.getFirst();
        list.remove(oldfirst);
        return oldfirst;
    }

    public E remove()
    {
        return null;
    }
}