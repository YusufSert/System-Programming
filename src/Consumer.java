public class Consumer implements Runnable {

    MyBlockingQuee_Wait buffer;

    Consumer(MyBlockingQuee_Wait q){
        buffer = q;
    }

    int x;
    public void run()
    {
        for(int i = 0; i < 30; i++)
        {
          x = (Integer) buffer.take();
        }
    }
}
