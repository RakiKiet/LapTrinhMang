package bai04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import javax.swing.border.Border;

public class MyNSLookUp extends JFrame {
    public MyNSLookUp() {
        //Xây dựng một số nội dung trên màn hình
        this.init();
        //Gán tên trên thanh tiêu đề
        this.setTitle("Xin Chào");
        //Quy định về kích thước
        this.setSize(600, 400);
        //Cửa sổ hiển thị ở giữa màn hình
        this.setLocationRelativeTo(null);
        //Quy định thoát chương trình khi thoát cửa sổ
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Cho phép hiển thị ra màn hình
        this.setVisible(true);
    }

    public void init() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 1));

        //Thêm nhãn
        JLabel title = new JLabel("PHẦN MỀM TRA CỨU ĐỊA CHỈ IP");
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        headerPanel.add(title);

        //Thêm một số text input
        JTextField domain_input = new JTextField();
        domain_input.setColumns(50);
        headerPanel.add(domain_input);

        //Thêm nút nhấn tra cứu
        JButton tracuu = new JButton("Tra Cứu");
        headerPanel.add(tracuu);

        //Thêm một JTextArea
        JTextArea jta_rs = new JTextArea();
        jta_rs.setColumns(50);
        jta_rs.setRows(20);
        jta_rs.setEditable(false);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(jta_rs);

        //Thêm các thành phần vào main panel
        mainPanel.add(headerPanel);
        mainPanel.add(resultPanel);

        // Thêm main panel vào jframe
        this.add(mainPanel);

        tracuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InetAddress ia = InetAddress.getByName(domain_input.getText());
                    //In thông tin
                    String result = "";
                    result += ("IP: " + ia.getHostAddress() + "\n");
                    result += ("Domain: " + ia.getHostName() + "\n");
                    result += ("Reachable: " + ia.isReachable(120) + "\n");
                    result += ("MulticastAddress: " + ia.isMulticastAddress() + "\n");
                    result += ("SiteLocalAddress: " + ia.isSiteLocalAddress());
                    jta_rs.setText(result);
                }
                catch(Exception e1){
                    // e1.printStackTrace();
                    System.out.println("Gặp lỗi, vui lòng nhập địa chỉ khác!");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Quy định về cách nhìn và cảm nhận
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        new MyNSLookUp();
    }
}
