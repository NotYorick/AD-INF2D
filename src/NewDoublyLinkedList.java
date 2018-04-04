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

    public boolean add(E element) {
        if (head == null) {
            head = new Node(element,null,null);
        } else {
            Node node = head;
            for ( ; node.next != null; node = node.next) {}
            node.next = new Node(element,null,node);
            tail = node.next;
        }
        size++;
        return true;
    }
    public void addAtPos (E val, int pos)
    {
        Node add = new Node(val,null,null);
        int ix = pos - 1;
        Node cur = head;
        for (int i = 0; i < size; i++) {
            if(i == ix) {
                add.next = cur.next;
                cur.next = add;
            }
            cur = cur.next;
        }
        ++size;
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

    public void reverse(){
        Node cn = head;
        Node tmp = null;
        while(cn != null){
            tmp = cn.next;
            cn.next = cn.prev;
            cn.prev = tmp;

            cn = cn.prev;
        }
        tmp = head;
        head = tail;
        tail = tmp;
        head.prev = null;
        tail.next = null;
    }

    public E get(int index) {
        Node node = getNode(index);
        return node.element;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
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
        NewDoublyLinkedList list = new NewDoublyLinkedList();
        list.add("halp");
        list.add("halp2");
        list.addAtPos("halp3",2);
        list.removeLast();
        System.out.println(list.get(0));




    }
}