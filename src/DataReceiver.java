import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class DataReceiver {
    public DataReceiver() throws IOException {
        try {
            DatagramSocket ds = new DatagramSocket(3000);
            byte buf[] = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            ds.receive(dp);
            String str = new String(dp.getData(),0 ,dp.getLength());
            System.out.println(str);
            //DatagramPacket echo = new DatagramPacket(str.getBytes(StandardCharsets.UTF_8), str.length(), dp.getAddress(), 3001);
            ds.send(dp);
            ds.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {
        DataReceiver receiver = new DataReceiver();
    }
}
