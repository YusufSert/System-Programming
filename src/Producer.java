public class Producer implements Runnable {

    MyBlockingQuee_Wait buffer;
    int st, sp;

    Producer(MyBlockingQuee_Wait buffer, int t, int p)
    {
        this.buffer = buffer;
        this.st = t;
        this.sp = p;
    }
    public void run()
    {
        for( int i = st; i<sp; i++)
        {
            buffer.put(i);
        }
    }
}
