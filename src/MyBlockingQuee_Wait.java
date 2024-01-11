import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class MyBlockingQuee_Wait<E> {
    private Queue<E> queue;
    private int max;

    public MyBlockingQuee_Wait(int s)
    {
        queue = new LinkedList<>();
        this.max = s;
    }

    public synchronized void put(E e)
    {
        while (queue.size() == max)
        {
            try {
                wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        queue.add(e);
        System.out.println(Thread.currentThread().getName() + " : " + e);
        notifyAll();
    }

    public synchronized E take()
    {
        while (queue.size() == 0)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        E item = queue.remove();
        System.out.println(Thread.currentThread().getName() + " : " + item);
        notifyAll();
        return item;
    }
    public int size()
    {
        return queue.size();
    }

}
