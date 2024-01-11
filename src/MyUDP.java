import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class MyUDP {
    public byte[] buf = new byte[1024];
    public DatagramPacket echo = new DatagramPacket(buf, 1024);
    MyUDP()
    {
        try {
            DatagramSocket ds = new DatagramSocket(3001);
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            String data = "Hi";
            DatagramPacket dp = new DatagramPacket(data.getBytes(), data.length(), ip, 3000);
            ds.send(dp);
            ds.receive(echo);
            System.out.println(echo.getAddress() + "-" + echo.getPort() + "=> " + new String(echo.getData(), 0, echo.getLength()));
            ds.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)
    {
        MyUDP send = new MyUDP();
    }
}
