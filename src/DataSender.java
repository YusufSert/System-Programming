import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DataSender {
   DataSender(){
       try {
           DatagramSocket ds = new DatagramSocket(3001);
           byte[] buf = new byte [1024];
           String str = "Yusuf Can Sert";
           InetAddress ip =  InetAddress.getByName("127.0.0.1");
           DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(), ip, 3000);
           DatagramPacket dpR = new DatagramPacket(buf, 1024);
           ds.send(dp);
           ds.receive(dpR);
           System.out.println("Echo " + new String(dpR.getData(), 0, dpR.getLength()));
           ds.close();
       } catch (SocketException e) {
           throw new RuntimeException(e);
       } catch (UnknownHostException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
    public static void main(String[] args) throws SocketException {
        DataSender sender = new DataSender();
    }
}
