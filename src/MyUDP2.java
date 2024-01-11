import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyUDP2 {
    MyUDP2()
    {
        try {
            DatagramSocket ds = new DatagramSocket(3000);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            ds.receive(dp);
            String data = new String(dp.getData(),0,  dp.getLength());
            System.out.println(dp.getAddress()+ "-" + dp.getPort() + "=> " + data);
            ds.send(dp);
            ds.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)
    {
        MyUDP2 reciv = new MyUDP2();
    }
}
