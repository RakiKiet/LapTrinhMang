package library;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Thread_WriteData extends Thread {
    private Socket socket;
    private String name;

    public Thread_WriteData(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Lấy Stream để ghi dữ liệu
            OutputStream os = socket.getOutputStream();
            System.out.println("---------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập 'exit' để thoát");
            System.out.println("Nhập nội dung tin nhắn để gửi thông tin đến " + name);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

            while (true) {
                // Server đọc tin nhắn từ bàn phím
                String input = sc.nextLine();
                if (input.equals("exit")) {
                    break;
                }
                // Gửi tin nhắn đến Client
                pw.println(input);
                //Ép buộc dữ liệu truyền đi ngay lập tức
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
