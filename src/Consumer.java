public class Consumer implements Runnable {

    int x;
    MyBlockingQuee_Wait buffer;
    Consumer(MyBlockingQuee_Wait buffer) {this.buffer = buffer; }

    public void run()
    {
        for (int i = 0; i < 30; i++)
        {
            x = (Integer) buffer.take();
        }
    }
}