public class Prod_Cons {
    public static void main(String[] args)
    {
       MyBlockingQuee_Wait<Integer> buf = new MyBlockingQuee_Wait<Integer>(5);
       Thread p1 = new Thread(new Producer(buf, 0, 20), "Producer-1");
       Thread p2 = new Thread(new Producer(buf, 20, 40), "Producer-2");
       Thread p3 = new Thread(new Producer(buf, 40, 60), "Producer-3");

       Thread c1 = new Thread(new Consumer(buf), "Consumer-1");
       Thread c2 = new Thread(new Consumer(buf), "Consumer-2");

       p1.start();
       p2.start();
       p3.start();

       c1.start();
       c2.start();

       try {
           p1.join();
           p2.join();
           p3.join();
           c1.join();
           c2.join();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       System.out.println("Buffer size on exit : " + buf.size());
    }

}
