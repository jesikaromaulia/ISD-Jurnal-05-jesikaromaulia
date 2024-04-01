// import java.util.Iterator;
// import java.util.LinkedList;
import java.util.*;

public class QueueLL<E> {
    private Queue<E> queueList;

    //constructor
    public QueueLL() {
        queueList = new LinkedList<E>();
    }

    public void enqueue(E object) {
        queueList.add(object);
    }

    public E dequeue() throws NoSuchElementException {
        return queueList.remove();
    }

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    public void printQueue() {
        Iterator<E> it = queueList.iterator();
        while(it.hasNext()) {

            Object value = it.next();

            if (!it.hasNext()) {
                System.out.print(value);   
            } else {
                System.out.print(value + " - ");
            }
            
        }
    }

    public void printPekerjaan () {
        System.out.println(queueList.peek());
    }
}