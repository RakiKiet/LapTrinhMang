package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            // Địa chỉ server: 127.0.0.1
            // Zalo địa chỉ server: zalo.vn
            Socket client = new Socket("127.0.0.1", 25000);
            System.out.println("Đã kết nối đến máy chủ.");

            // Lấy Stream để đọc dữ liệu
            InputStream is = client.getInputStream();
            //Lẫy Stream để ghi dữ liệu
            OutputStream os = client.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

            // Gửi yêu cầu xin chào và ghi thông tin
            pw.println("Kiệt: Xin chào, tôi là Kiệt.");
            pw.flush();

            System.out.println("-----------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập 'exit' để thoát");
            System.out.println("Nhập nội dung tin nhắn để gửi đến Server");

            while (true) {
                // Đọc dữ liệu từ server và xuất ra màn hình
                System.out.println(br.readLine());

                // Server đọc tin nhắn từ bàn phím
                String input = sc.nextLine();
                if (input.equals("exit")) {
                    break;
                }

                // Gửi tin nhắn lên server
                pw.println("Kiệt: " + input);
                //Ép buộc dữ liệu truyền đi ngay lập tức
                pw.flush();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
