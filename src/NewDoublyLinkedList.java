import java.util.NoSuchElementException;

class NewDoublyLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public NewDoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {
            head.prev = tmp;
        }
        head = tmp;
        if(tail == null) {
            tail = tmp;
        }
        size++;
    }

    public void addAtPos(E val , int pos)
    {
        Node newNode = new Node(val, null, null);
        if (pos == 1)
        {
            addFirst(val);
            return;
        }
        Node itNode = head;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = itNode.next;
                itNode = itNode.prev;
                itNode.next = newNode;
                newNode.prev = itNode;
                newNode.next = tmp;
                size++ ;
                return;
            }
            itNode = itNode.next;
        }


    }

    public void addLast(E element) {

        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
    }

    public void iterateForward(){

        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void iterateBackward(){

        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.element;
    }

    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tmp.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E getFirst() {
        return head.element;
    }

    public E getLast() {
        return tail.element;
    }

    public static void main(String a[]){

        NewDoublyLinkedList<Integer> dll = new NewDoublyLinkedList<Integer>();
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addLast(56);
        dll.addLast(364);
        dll.addAtPos(364,4);
        dll.iterateForward();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateBackward();
    }
}