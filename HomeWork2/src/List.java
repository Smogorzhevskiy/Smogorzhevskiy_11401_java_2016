public class List<T> {
    class Node<T> {
        T x;
        Node next;
    }

    private Node<T> head;
    private Node<T> last;
    private Node<T> cur;


    public List() {
        head = null;
        last = null;
    }

    public void addStart(T x) {
        Node p = new Node();
        p.x = x;
        p.next = head;
        if (head == null) {
            last = p;
            p.next=null;
        }
        head = p;
    }

    public void addEnd(T x) {
        Node p = new Node();
        p.x = x;
        p.next = null;
        if (head == null)
            head = p;
        else
            last.next = p;
        last = p;
    }

    public T getStart() {
        return head.x;
    }

    public void deleteStart() {
        head = head.next;
    }

    public void moveStart() {
        cur = head;
    }

    public void moveNext() {
        cur = cur.next;
    }

    public T getCur() {
        return cur.x;
    }

    public boolean isEnd() {
        return cur == null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
