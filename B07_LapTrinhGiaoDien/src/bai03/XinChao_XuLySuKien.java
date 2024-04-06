package bai03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XinChao_XuLySuKien extends JFrame{
    public XinChao_XuLySuKien(){
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
    public void init(){
        JPanel mainPanel = new JPanel();
        //Quy định về bố cục
        mainPanel.setLayout(new BorderLayout());
        //Thêm một số nút nhấn
        JButton j_north = new JButton("Phía trên");
        JButton j_south = new JButton("Phía dưới");
        JButton j_west = new JButton("Phía trái");
        JButton j_east = new JButton("Phía phải");
        JButton j_center = new JButton("Nguyễn Vũ Tuấn Kiệt");

        j_north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = e.getActionCommand();
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        j_south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = e.getActionCommand();
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        j_west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = e.getActionCommand();
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        j_east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = e.getActionCommand();
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        j_center.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = e.getActionCommand();
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        mainPanel.add(j_north, BorderLayout.NORTH);
        mainPanel.add(j_south, BorderLayout.SOUTH);
        mainPanel.add(j_west, BorderLayout.WEST);
        mainPanel.add(j_east, BorderLayout.EAST);
        mainPanel.add(j_center, BorderLayout.CENTER);
        //Thêm JPanel vào chương trình
        this.add(mainPanel);
    }
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        new XinChao_XuLySuKien();
    }
}
