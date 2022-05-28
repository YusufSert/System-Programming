public class Producer implements Runnable {

    MyBlockingQuee_Wait buffer;
    int st, sp;

    Producer(MyBlockingQuee_Wait q, int t, int p)
    {
        buffer = q;
        st = t;
        sp = p;
    }

    public void run()
    {
        for (int i = st; i<sp; i++)
        {
            buffer.put(i);
        }
    }
}
