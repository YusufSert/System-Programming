public class Worker implements Runnable{
    MyClass obj;

    Worker(MyClass obj){
        this.obj = obj;
    }
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            obj.inc();
        }
    }
}