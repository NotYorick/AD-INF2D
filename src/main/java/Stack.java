
import java.util.LinkedList;

public class Stack<E> extends LinkedList<E>
{
    private LinkedList<E> list = new LinkedList<E>();

    public void main(String[] args) { }

    //Kijken of de stack leeg is
    public boolean empty(){
        if(list.size() > 0){
            return false;
        }
        return true;
    }

    //Kijken naar het bovenste object vd stack
    public E peek()
    {
        if(!list.isEmpty()){
            return list.getFirst();
        }

        return null;
    }

    //Het bovenste object van de stack halen
    public E pop()
    {
        E returnValue = list.getFirst();
        list.remove( list.getFirst() );
        return returnValue;
    }

    //Een nieuw item aan de stack toevoegen
    public void push(E item){
        list.addFirst( item );
    }

    //Item in de stack zoeken
    public int search(Object o){
        for(int i=0;i<list.size();i++){
            if(list.get(i) == o){
                return i;
            }
        }

        return -1;
    }
}