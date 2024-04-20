package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
    public static void main(String[] args) {
        {
            try {
                // Tạo ra ServerSocket
                ServerSocket server = new ServerSocket(25000);
                System.out.println("Server đang chạy tại port: 25000");

                while (true) {
                    Socket connection = server.accept();
                    System.out.println("Chấp nhận kết nối từ client.");

                    // Lẫy Stream để đọc dữ liệu
                    InputStream is = connection.getInputStream();
                    //Lẫy Stream để ghi dữ liệu
                    OutputStream os = connection.getOutputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

                    System.out.println("-----------------------");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nhập 'exit' để thoát");
                    System.out.println("Nhập nội dung tin nhắn để gửi thông tin đến Kiệt(client)");

                    while (true) {
                        // Đọc dữ liệu từ client và xuất ra màn hình
                        System.out.println(br.readLine());

                        // Server đọc tin nhắn từ bàn phím
                        String input = sc.nextLine();
                        if (input.equals("exit")) {
                            break;
                        }

                        // Gửi tin nhắn đến Kiệt
                        pw.println("Server: " + input);
                        //Ép buộc dữ liệu truyền đi ngay lập tức
                        pw.flush();
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
