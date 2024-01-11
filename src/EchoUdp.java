import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoUdp implements Runnable {

    private DatagramPacket packet;
    public EchoUdp(DatagramPacket packet) throws SocketException {this.packet = packet;}
    public DatagramSocket s = new DatagramSocket();


    public void run()
    {
        try {
            s.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket s = new DatagramSocket(3000);
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                s.receive(dp);
                System.out.println(dp.getAddress() + " says-> " + new String(dp.getData(), 0, dp.getLength()));
                new Thread(new EchoUdp(dp)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
