import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class NewLinkedList<E> implements List<E> {

    private class Node {    // node class die gebruikt wordt om data op te slaan en een verwijzing te maken naar de volgende node.
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        public String toString() {
            return "Node(" + data.toString() + ")";
        }   //toString functie om de node te kunnen bekijken als string
    }

    private int size;            // houdt de grootte bij van de collectie
    private Node head;           // Verwijzing naar de hoofd node

    public NewLinkedList() {
        //Constructor voor het begin van de collectie
        head = null;
        size = 0;
    }

    @Override
    public boolean add(E element) { //Voegt een nieuw element toe aan de collectie
        if (head == null) { // controlleerd of de collectie net aangemaakt is
            head = new Node(element);
        } else {    //loopt door tot dat de next null is gevonden om een node daar toe te voegen
            Node node = head;
            for ( ; node.next != null; node = node.next) {}
            node.next = new Node(element);
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) { //tweede add die een index kan meekrijgen om hem op die plek te plaatsen
        if(index == 0){
            head = new Node(element, head); // controlleerd of de collectie net aangemaakt is
        }else{  // gebruikt de getNode functie om te kijken naar index min 1 om de nieuwe node toe te voegen op de juiste plek
            Node preNode = getNode(index - 1);
            preNode.next = new Node(element,preNode.next);
        }
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) { //voegt een hele collectie toe aan de linked list
        boolean flag = true;
        for (E element: collection) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    } // geeft weer of de object in de collectie plaats vindt.

    @Override
    public boolean containsAll(Collection<?> collection) { // geeft weer of alles van de collectie, in de huidige collectie plaats vindt.
        for (Object obj: collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E get(int index) { //geeft de element van een bepaalde plek weer
        Node node = getNode(index); // gebruikt getNode functie
        return node.data;
    }

    private Node getNode(int index) { //geeft de node van een bepaalde plek weer
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i<index; i++) {   // looped naar de index
            node = node.next;
        }
        return node;
    }

    @Override
    public int indexOf(Object target) { //geeft de index weer van een object
        Node node = head;
        int index = -1;
        for( int i = 0; i < size; i++){
            if(equals(target, node.data)){
                return i;
            }else{
                node = node.next;
            }
        }
        return -1;
    }

    private boolean equals(Object target, Object element) { // controlleerd 2 objecten met elkaar, gebruikt de functie van Object class
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    } // geeft weer of de collectie leeg is

    @Override
    public Iterator<E> iterator() { // Geeft de iterator class weer van de collectie
        E[] array = (E[]) toArray();
        return Arrays.asList(array).iterator();
    }

    @Override
    public int lastIndexOf(Object target) {
        Node node = head;
        int index = -1;
        for (int i=0; i<size; i++) {
            if (equals(target, node.data)) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    } // abstracte functie

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    } // abstracte functie

    @Override
    public boolean remove(Object obj) { // verwijderd de eerste object uit de collectie
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {    // verwijderd de index van een object uit de collectie
        E element = get(index);
        if(index == 0){
            head = head.next;
        }else{
            Node preNode = getNode(index - 1);

            preNode.next = preNode.next.next;

        }
        size--;
        return element;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {  // verwijderd alles van de collectie
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) { // abstracte functie
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) { // plaatst een element op de plek van de index
        Node node = getNode(index);
        E old = node.data;
        node.data = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    } // geeft de grootte van de collectie weer

    @Override
    public List<E> subList(int fromIndex, int toIndex) { // maakt een tweede collectie vanaf het punt van de index en returned het in de vorm van een list
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        NewLinkedList<E> list = new NewLinkedList<E>();
        for (Node node=head; node != null; node = node.next) {
            if (i >= fromIndex && i <= toIndex) {
                list.add(node.data);
            }
            i++;
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node node=head; node != null; node = node.next) {
            array[i] = node.data;
            i++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        List<Integer> mll = new NewLinkedList<Integer>();
        mll.add(1);
        mll.add(2);
        mll.add(3);
        System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());

        mll.remove(2);
        System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());
    }
}
