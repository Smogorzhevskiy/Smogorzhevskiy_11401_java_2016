public class UndoRedoQueue{
    DList<Integer>_queue=new DList<Integer>();
    DList<Integer>List1=new DList<Integer>();
    DList<Integer>List2=new DList<Integer>();
    public void insert(int c){
        List1.clear();     // удаляем часть истории, которую
        List2.clear();     // не должны повторть после выполнения новой операции
        _queue.addEnd(c);
        List1.addEnd(1);
        List2.addEnd(c);
        List1.moveEnd();
        List2.moveEnd();

    }
    public void remove(){
        if (_queue.isEmpty()){
            System.out.println("Очередь пуста");
        }
        else {
            List1.clear(); // удаляем часть истории, которую
            List2.clear(); // не должны повторть после выполнения новой операции
            List1.addEnd(0);
            List2.addEnd(_queue.getFirst());
            _queue.deleteStart();
            List1.moveEnd();
            List2.moveEnd();
        }
    }

    public void undo(){
        if (List1.isEnd()){    // омену нельзя произвести, если cur встал перед head
            System.out.println("Нельзя отменить");
        }
        else {

            if(List1.getCur()==1){
                _queue.deleteEnd();
                List1.moveBack();
                List2.moveBack();
            }
            else {
                _queue.addStart(List2.getCur());

                List1.moveBack();
                List2.moveBack();
            }
        }

    }

    public void redo() {
if (List1.isEnd()) {      // если очередь пуста, а действие повторить еще можно
    List1.moveStart();    // то cur переходит с null
    List2.moveStart();    // в начало истории
}
else
    {
    List1.moveNext();
    List2.moveNext();
    }
                if (List1.isEnd()) {
                System.out.println("Нет отмененных действий");
                List1.moveEnd();// чтобы не было равно null  при повторном вызове redo
                List2.moveEnd();// и undo, что позволяет избежать  ошибки
            }
            else {

                if (List1.getCur() == 1) {
                    _queue.addEnd(List2.getCur());
                } else {
                    _queue.deleteStart();
                }
            }
        }
    public boolean isEm(){
        return _queue.isEmpty();
    }
    public void displayQueue()
    {
        System.out.print("Queue(first-->last):");
        _queue.displayList();
    }
}