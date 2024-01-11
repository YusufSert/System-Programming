class Value
{
    private int num;
    private boolean valueSet = false;

    public synchronized void set(int n)
    {
        while (valueSet)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        num = n;
        System.out.println("Set: " + num);
        valueSet = true;
        notify();
    }

    public synchronized void display()
    {
        while (!valueSet)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Show: " + num);
        valueSet = false;
        notify();
    }
}