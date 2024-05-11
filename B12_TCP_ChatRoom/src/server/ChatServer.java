package server;

import client.ChatClient;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 5000;
    private List<ClientHandle> clients = new ArrayList<>();

    public ChatServer() {
        try {
            // Web socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening to port: " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                ClientHandle clientHandle = new ClientHandle(clientSocket, System.currentTimeMillis()+"", this);
                clients.add(clientHandle);
                clientHandle.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void broadcastMessage(String ID, String ms) {
        for(ClientHandle client : clients) {
            if(!(client.getSid().equals(ID))) {
                client.sendMessage(ID + " : " + ms);
            }
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
    }
}
