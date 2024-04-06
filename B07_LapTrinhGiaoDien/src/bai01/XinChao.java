package bai01;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class XinChao extends JFrame {
    public XinChao() {
        //Xây dựng một số nội dung trên màn hình
        this.init();
        //Gán tên trên thanh tiêu đề
        this.setTitle("Xin Chào");
        //Quy định về kích thước
        this.setSize(600, 600);
        //Cửa sổ hiển thị ở giữa màn hình
        this.setLocationRelativeTo(null);
        //Quy định thoát chương trình khi thoát cửa sổ
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Cho phép hiển thị ra màn hình
        this.setVisible(true);
    }

    public void init() {
        JPanel mainPanel = new JPanel();
        //Quy định về bố cục
        mainPanel.setLayout(new BorderLayout());
        //Thêm một số nút nhấn
        JButton j_north = new JButton("Phía trên");
        JButton j_south = new JButton("Phía dưới");
        JButton j_west = new JButton("Phía trái");
        JButton j_east = new JButton("Phía phải");
        JButton j_center = new JButton("Nguyễn Vũ Tuấn Kiệt");

        mainPanel.add(j_north, BorderLayout.NORTH);
        mainPanel.add(j_south, BorderLayout.SOUTH);
        mainPanel.add(j_west, BorderLayout.WEST);
        mainPanel.add(j_east, BorderLayout.EAST);
        mainPanel.add(j_center, BorderLayout.CENTER);
        //Thêm JPanel vào chương trình
        this.add(mainPanel);
    }

    public static void main(String[] args) {
        new XinChao();
    }
}
