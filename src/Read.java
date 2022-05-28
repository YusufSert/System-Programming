class Read implements Runnable
{
    Value val;
    Read(Value v) {val = v;}

    public void run()
    {
        while (true)
        {
            val.display();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}