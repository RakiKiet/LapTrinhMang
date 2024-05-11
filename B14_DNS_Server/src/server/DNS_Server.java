package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DNS_Server {
    public static void main(String[] args) {
        // Giả lập một dnsTable
        String[][] dnsTable = {
                {"www.example.com", "192.168.1.100"},
                {"www.google.com", "8.8.8.8"},
                {"www.titv.vn", "9.1.9.1"}
        };

        try {
            // Tạo DatagramSocket
            DatagramSocket socket = new DatagramSocket(9876);

            // Liên tục lắng nghe từ Client
            while (true) {
                // Tạo và nhận gói tin từ Client
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Truy vấn IP từ dnsTable
                String domainName = new String(receivePacket.getData(), 0, receivePacket.getLength());
                domainName = domainName.trim();
                domainName = domainName.toLowerCase();

                // Duyệt toàn bộ cái table
                String result = "Not found!";
                for (String[] entry : dnsTable) {
                    if (entry[0].equals(domainName)) {
                        result = entry[1];
                        break;
                    }
                }

                // Phản hồi thông tin cho Client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                byte[] responseData = result.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
