import java.net.*;
public class HostInfo
{
    public static void main( String args[] )
    {
        InetAddress ipAddr;
        try
        {
            ipAddr = InetAddress.getLocalHost();
            System.out.println( "This is " + ipAddr );
        }
        catch ( UnknownHostException ex )
        {
            System.out.println( "Unknown host" );
        }
    }
}