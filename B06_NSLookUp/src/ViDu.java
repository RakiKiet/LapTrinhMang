import java.io.IOException;
import java.net.InetAddress;

public class ViDu {
    public static void main(String[] args) {
        try{
            InetAddress ia = InetAddress.getByName("youtube.com");
            System.out.println(ia.getAddress());
            System.out.println(ia.getHostAddress());
            System.out.println(ia.getCanonicalHostName());
            System.out.println(ia.getHostName());
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
}
