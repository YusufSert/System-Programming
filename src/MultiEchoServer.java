import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiEchoServer {
    public static void main(String[] args){
        try {
            ServerSocket s = new ServerSocket(8009);
            while (true)
            {
                Socket incoming = s.accept();
                new Thread(new ClientHandler(incoming)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
