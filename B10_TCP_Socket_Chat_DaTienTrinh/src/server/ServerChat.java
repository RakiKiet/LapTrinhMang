package server;

import library.Thread_ReadData;
import library.Thread_WriteData;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(25000);
            System.out.println("Server đang chạy tại port: 25000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Chấp nhận kết nối từ Client");

                Thread_ReadData tr = new Thread_ReadData(socket, "Client");
                Thread_WriteData tw = new Thread_WriteData(socket, "Client");

                tr.start();
                tw.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
