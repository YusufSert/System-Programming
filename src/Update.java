public class Update implements Runnable{

    Value val;

    Update(Value v) {this.val = v;}

    public void run()
    {
        int i = 0;
        while (true)
        {
            val.set(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
