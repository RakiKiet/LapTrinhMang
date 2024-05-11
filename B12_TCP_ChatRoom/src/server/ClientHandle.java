package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandle extends Thread {
    private Socket mySocket;
    private ChatServer chatServer;
    private String sID;
    private InputStream input;
    private OutputStream output;

    public ClientHandle(Socket s, String ID, ChatServer server) {
        this.mySocket = s;
        this.sID = ID;
        this.chatServer = server;
        try {
            this.input = mySocket.getInputStream();
            this.output = mySocket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                chatServer.broadcastMessage(this.sID, message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String ms) {
        try {
            output.write(ms.getBytes());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public String getSid() {
        return this.sID;
    }
}
