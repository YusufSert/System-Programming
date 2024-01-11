import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args)
    {
        try {
            String host = args.length > 0 ? args[0] : "localhost";
            Socket socket = new Socket(host, 8008);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            for(int i = 1; i<=10; i++)
            {

                out.println("line " + i);
                out.flush();
                System.out.println("Sending: line " + i);
                String str = in.readLine();
                System.out.println(str);
            }

            out.println("BYE");
            out.flush();

            while (true)
            {
                String str = in.readLine();
                if(str == null)
                    break;

                System.out.println(str);
            }

            in.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
