import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPPortScanner {
    public static void main(String[] args) {
        for (int port = 1024; port <= 65535; port++) {
            try {
                //Kiểm tra port có được dùng hay chưa bằng cách tạo ra 1 DatagramSocket
                DatagramSocket server = new DatagramSocket(port);
                //Tạo thành công => port trước đây chưa được sử dụng
                server.close();
            }
            catch (SocketException ex) {
                System.out.println("Port: " + port + " đang được sử dụng.");
            }
        }
    }
}
