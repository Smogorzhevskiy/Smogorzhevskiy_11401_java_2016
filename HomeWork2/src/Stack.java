public class Stack<T> {
    List<T> l;
    public Stack(){
        l = new List();
    }

    public void push(T x) {
        l.addStart(x);
    }

    public T pop() throws MyException{
        if (isEmpty()) throw new MyException();
        else {
            l.moveStart();
            l.deleteStart();
            return l.getCur();
        }
    }

    public boolean isEmpty() {
        return l.isEmpty();
    }
}