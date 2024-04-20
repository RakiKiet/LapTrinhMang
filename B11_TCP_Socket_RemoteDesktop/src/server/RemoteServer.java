package server;

import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer {
    public static void main(String[] args) {
        try {
            ServerSocket svSk = new ServerSocket(50000);
            while (true) {
                Socket socket = svSk.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                HandleRequest hr = new HandleRequest(socket);
                hr.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
