import org.junit.Test;
import static org.junit.Assert.*;
public class QueueTest {
    @Test
    public void addStartTest() {
        DList<Integer> l = new DList<Integer>();
        l.addStart(5);
        assertFalse(l.isEmpty());
    }
     @Test
      public void addEndTest(){
         DList<Integer> l = new DList<Integer>();
         Integer n = 3;
         Integer j = 4;
         Integer m = 5;
         l.addStart(n);
         l.addStart(j);
         l.addEnd(m);
         l.moveStart();
         l.moveNext();
         l.moveNext();
         assertTrue(l.getCur() == m);
     }
     @Test
     public void getFirstTest() {
         DList<Integer> l = new DList<Integer>();
         Integer n = 5;
         l.addStart(n);
         assertEquals(n, l.getFirst());
     }
     @Test
     public void getLastTest(){
         DList<Integer> l= new DList<Integer>();
         Integer n=5;
         Integer p=3;
         l.addStart(n);
         l.addEnd(p);
         assertEquals(p, l.getLast());
     }
     @Test
     public void deleteStartTest() {
         DList<Integer> l = new DList<Integer>();
         Integer n = 3;
         l.addStart(n);
         l.deleteStart();
         assertTrue(l.isEmpty());
     }
     @Test
     public void deleteEndTest() {
         DList<Integer> l = new DList<Integer>();
         Integer n = 10;
         Integer p = 1;
         l.addEnd(n);
         l.addEnd(p);
         l.deleteEnd();
         assertEquals(n, l.getLast());
     }
     @Test
     public void isEmptyTest() {
     DList<Integer> l= new DList<Integer>();
         Integer n=5;
         l.addEnd(n);
         assertFalse(l.isEmpty());
         l.deleteEnd();
         assertTrue(l.isEmpty());
     }
     @Test
     public void getCur_and_moveStartTest() {
         DList<Integer> l = new DList<Integer>();
         Integer n = 1;
         l.addStart(n);
         l.moveStart();
         assertEquals(l.getCur(), l.getFirst());
     }
     @Test
     public void moveEnd() {
     DList<Integer> l= new DList<Integer>();
     Integer n=4;
         Integer p=3;
         l.addStart(n);
         l.addStart(p);
         l.moveEnd();
         assertEquals(l.getCur(),l.getLast());
     }

     @Test
     public void moveNextTest() {
         DList<Integer> l = new DList<Integer>();
         Integer n = 2;
         Integer m = 3;
         l.addStart(n);
         l.addStart(m);
         l.moveStart();
         l.moveNext();
         assertEquals(l.getCur(), n);
     }

     @Test
     public void isEndTest(){
         DList<Integer> l = new DList<Integer>();
         Integer n= 4;
         l.addStart(n);
         l.addStart(n);
         l.moveStart();
         l.moveNext();
         assertFalse(l.isEnd());
         l.moveNext();
         assertTrue(l.isEnd());
     }
     @Test
     public void clearTest(){
         DList<Integer> l= new DList<Integer>();
         Integer n=4;
         Integer p=8;
         l.addEnd(n);
         l.addEnd(p);
         l.addEnd(n);
         l.moveEnd();
         l.moveBack();
         l.clear();
         assertEquals(p, l.getCur());
     }
     @Test
     public void insertTest(){
         UndoRedoQueue l=new UndoRedoQueue();
         l.insert(5);
         assertFalse(l.isEm());
     }
     @Test
     public void removeTest(){
         UndoRedoQueue l=new UndoRedoQueue();
         l.insert(7);
         l.remove();
         assertTrue(l.isEm());
     }
     @Test
     public void UndoTest(){
         UndoRedoQueue l= new UndoRedoQueue();
         l.insert(4);
         l.remove();
         l.undo();
         l.undo();
         assertTrue(l.isEm());
         assertFalse(!l.isEm());
     }
     @Test
     public void RedoTest(){
         UndoRedoQueue l= new UndoRedoQueue();
         l.insert(4);
         l.remove();
         l.undo();
         l.redo();
         assertTrue(l.isEm());
         assertFalse(!l.isEm());

     }
     @Test
     public void isEmTest(){
         UndoRedoQueue l= new UndoRedoQueue();
         l.insert(7);
         l.remove();
         assertTrue(l.isEm());
     }
    @Test
    public void pushPop2RedoTest() {
        UndoRedoQueue l = new UndoRedoQueue();
        l.insert(5);
        l.remove();
        l.undo();
        l.redo();
        l.redo();
        assertTrue(l._queue.isEmpty());
    }

 }


