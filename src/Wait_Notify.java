public class Wait_Notify {
    public static void main(String[] args)
    {
        Value data = new Value();

        Thread prod = new Thread(new Update(data));
        Thread cons = new Thread(new Read(data));

        prod.start();
        cons.start();
    }
}
