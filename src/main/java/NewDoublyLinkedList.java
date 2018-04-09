import java.util.NoSuchElementException;

class NewDoublyLinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public NewDoublyLinkedList() { //constrcutor om voor het aanmaken van de collectie
        size = 0;
        head = null;
        tail = null;
    }

    private class Node { //Node class die de vorige en volgende node bijhoud.
        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) { // next en prev moeten worden meegegeven om de collectie te kunnen maken
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addFirst(E element) { // voegt een element toe aan het begin van de collectie
        Node tmp = new Node(element, head, null);
        if(head != null ) { // bekijkt of de collectie nieuw is
            head.prev = tmp; // voegt de prev toe aan de oude head
        }
        head = tmp; //maakt de nieuwe head
        if(tail == null) {
            tail = tmp;
        }
        size++; // update de size
    }

    public boolean add(E element) { // voegt een nieuwe node toe aan de tail
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

    public void addLast(E element) { // voegt een node toe aan het eind

        Node tmp = new Node(element, null, tail); //nieuwe node met tail als prev
        if(tail != null) {tail.next = tmp;} // als tail niet niets is,  wordt de next de nieuwe node
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
    }

    public void iterateForward(){ // print de collectie van begin tot eind

        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void iterateBackward(){ // print de collectie van eind naar begin

        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

    public E removeFirst() { // verwijderd de eerste node
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.element;
    }

    public E removeLast() { // verwijderd de laatste node
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tmp.element;
    }

    public void reverse(){ // maakt de collectie omgekeerd
        Node cn = head;
        Node tmp = null;
        while(cn != null){
            tmp = cn.next; //temp wordt current next
            cn.next = cn.prev; //current next wordt de current prev
            cn.prev = tmp; //current prev wordt de oude next
            cn = cn.prev;
        }
        tmp = head;
        head = tail;
        tail = tmp;
        head.prev = null;
        tail.next = null;
    }

    public E get(int index) { // geeft de element van het index weer
        Node node = getNode(index);
        return node.element;
    }

    private Node getNode(int index) { // geeft de node weer van de index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); // error wanneer de range overschreden is
        }
        Node node = head;
        for (int i=0; i<index; i++) { // looped naar de index en returned de waarde
            node = node.next;
        }
        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    } // controle als de collectie leeg is

    public int size() {
        return size;
    } // geeft de grootte weer van de collectie

    public E getFirst() {
        return head.element;
    } //geeft de eerste node weer

    public E getLast() {
        return tail.element;
    } // geeft de laatste node weer

    public static void main(String a[]){
        NewDoublyLinkedList list = new NewDoublyLinkedList();
        list.add("halp");
        list.add("halp2");
        list.addAtPos("halp3",2);
        list.removeLast();
        System.out.println(list.get(0));

    }
}