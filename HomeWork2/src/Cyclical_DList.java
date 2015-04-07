// Цикличный список
public class Cyclical_DList<T> {

    class DLNode<T> {
        T elem;
        DLNode next;
        DLNode prev;
    }

    private DLNode<T> head;
    private DLNode<T> last;
    private DLNode<T> cur;


    public Cyclical_DList() {
        head = null;
        last = null;
    }

    public void addStart(T elem) {
        DLNode p = new DLNode();
        p.elem = elem;
        p.next = head;
        if (head != null)
            head.prev = p;
        if (head == null) {
            last = p;
            last.next = head;
            last.prev = head;
        }
        head = p;
        last.next = head;
        p.prev = last;
    }

    public void addEnd(T x) {
        DLNode p = new DLNode();
        p.elem = x;
        p.next = head;
        p.prev = last;
        if (last != null)
            last.next = p;
        last = p;
        if (head == null) {
            head = p;
            head.prev = last;
        }
    }

    public T getStart() {
        return head.elem;
    }

    public void deleteStart() {
        if (head != null) {
            if (head != last) {
                head = head.next;
                head.prev = last;
            }
            else {
                head=null;
                last=null;
            }
        } else System.out.println("Nothing to delete");
    }

    public void deleteEnd() {
        if (last != null) {
            if (last!=head) {
                last = last.prev;
                last.next = head;
            }
            else {
                head=null;
                last=null;
            }
        } else System.out.println("Nothing to delete");
    }

    public void moveStart() {
        cur = head;
    }

    public void moveNext() {
        cur = cur.next;
    }

    public void moveBack() {
        cur = cur.prev;
    }

    public T getCur() {
        return cur.elem;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T getEnd() {
        return last.elem;
    }
}