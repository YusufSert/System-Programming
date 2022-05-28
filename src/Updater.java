public class Updater {
    public static void main(String[] args)
    {
        MyClass o1 = new MyClass();

        Thread t1 = new Thread(new Worker(o1));
        Thread t2 = new Thread(new Worker(o1));
        Thread t3 = new Thread(new Worker(o1));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(o1.get());
    }
}