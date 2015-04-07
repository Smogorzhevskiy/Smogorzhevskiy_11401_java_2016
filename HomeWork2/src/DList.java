// Двухсторонний список
public class DList<T> {
    class DLNode<T> {
        T elem;
        DLNode next;
        DLNode prev;
    }

    private DLNode<T> head;
    private DLNode<T> cur;
    private DLNode<T> last;

    public DList() {
        head = null;
        last = null;
    }

    public void addStart(T x) {
        DLNode p = new DLNode();
        p.elem = x;
        p.next = head;
        if (head != null)
            head.prev = p;
        if (head == null) {
            last = p;
            last.next = null;
            last.prev = head;
        }
        head = p;
        p.prev = null;
    }

    public void addEnd(T x) {
        DLNode p = new DLNode();
        p.elem = x;
        p.next = null;
        p.prev = last;
        if (last != null)
            last.next = p;
        last = p;
        if (head == null) {
            head = p;
            head.prev = null;
        }
    }

    public T getFirst() {
        return head.elem;
    }

    public T getLast() {
        return last.elem;
    }

    public void deleteStart() {
        if (head != null) {
            head = head.next;
            if(head!=null)
                head.prev = null;
            else last=null;
        } else System.out.println("Nothing to delete");
    }

    public void deleteEnd() {
        if (last!=null) {
            last = last.prev;
            if (last!=null)
                last.next = null;
            else head=null;
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

    public boolean isEnd() {
        return cur == null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

