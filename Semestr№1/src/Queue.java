public class Queue {

    public static void main(String[] args) {
        UndoRedoQueue queue=new UndoRedoQueue();
        queue.insert(20);
        queue.insert(30);
        queue.insert(10);
        queue.displayQueue();
        queue.remove();
        queue.displayQueue();
        queue.insert(50);
        queue.displayQueue();
        queue.remove();
        queue.displayQueue();
        queue.insert(5);
        queue.displayQueue();
        queue.undo();
        queue.undo();queue.undo();queue.undo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.remove();
        queue.displayQueue();
        queue.redo();
        queue.undo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.undo();
        queue.displayQueue();
        queue.undo();
        queue.displayQueue();
        queue.undo();
        queue.displayQueue();
        queue.undo();
        queue.displayQueue();
        queue.undo();
        queue.displayQueue();
        queue.undo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.redo();
        queue.displayQueue();
        queue.redo();
        queue.redo();
        queue.undo();
        queue.displayQueue();

    }
}
/*      Queue(first-->last):20 30 10
        Queue(first-->last):30 10
        Queue(first-->last):30 10 50
        Queue(first-->last):10 50
        Queue(first-->last):10 50 5
        Queue(first-->last):20 30 10
        Queue(first-->last):30 10
        Queue(first-->last):10
        Нет отмененных действий
        Queue(first-->last):30 10
        Queue(first-->last):10
        Queue(first-->last):30 10
        Queue(first-->last):20 30 10
        Queue(first-->last):20 30
        Queue(first-->last):20
        Queue(first-->last):
        Нельзя отменить
        Queue(first-->last):
        Queue(first-->last):20
        Queue(first-->last):20 30
        Queue(first-->last):20 30 10
        Queue(first-->last):30 10
        Queue(first-->last):10
        Нет отмененных действий
        Нет отмененных действий
        Queue(first-->last):30 10      */
