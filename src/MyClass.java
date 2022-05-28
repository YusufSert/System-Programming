public class MyClass {
    private int count;

    public MyClass()
    {
        count = 0;
    }

    public  int get()
    {
        return count;
    }

    public synchronized void inc()
    {
        count ++;
    }
}
