package bai05_MVC;

import bai04.MyNSLookUp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField num1;
    private JTextField num2;
    private JLabel resultLabel;

    private JButton addButton,
            subtractButton,
            multiplyButton,
            divideButton,
            powerButton,
            squareButtonA,
            squareButtonB,
            minButton,
            maxButton;

    public CalculatorView() {
        this.init();
        this.setTitle("Calculator");
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // this.setVisible(true);
    }
    public void init() {
        JPanel inputPanel = new JPanel();
        num1 = new JTextField(10);
        num1.setFont(new Font("Consolas", NORMAL, 20));
        num2 = new JTextField(10);
        num2.setFont(new Font("Consolas", NORMAL, 20));
        JLabel num1Label = new JLabel("Số 1: ");
        num1Label.setFont(new Font("Consolas", NORMAL, 20));
        JLabel num2Label = new JLabel("Số 2: ");
        num2Label.setFont(new Font("Consolas", NORMAL, 20));
        inputPanel.add(num1Label);
        inputPanel.add(num1);
        inputPanel.add(num2Label);
        inputPanel.add(num2);

        addButton = new JButton("+");
        addButton.setFont(new Font("Consolas", Font.BOLD, 20));
        subtractButton = new JButton("-");
        subtractButton.setFont(new Font("Consolas", Font.BOLD, 20));
        multiplyButton = new JButton("*");
        multiplyButton.setFont(new Font("Consolas", Font.BOLD, 20));
        divideButton = new JButton("/");
        divideButton.setFont(new Font("Consolas", Font.BOLD, 20));
        powerButton = new JButton("^");
        powerButton.setFont(new Font("Consolas", Font.BOLD, 20));
        squareButtonA = new JButton("SqrtA");
        squareButtonA.setFont(new Font("Consolas", Font.BOLD, 20));
        squareButtonB = new JButton("SqrtB");
        squareButtonB.setFont(new Font("Consolas", Font.BOLD, 20));
        minButton = new JButton("Min");
        minButton.setFont(new Font("Consolas", Font.BOLD, 20));
        maxButton = new JButton("Max");
        maxButton.setFont(new Font("Consolas", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(powerButton);
        buttonPanel.add(squareButtonA);
        buttonPanel.add(squareButtonB);
        buttonPanel.add(minButton);
        buttonPanel.add(maxButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Consolas", Font.BOLD, 40));
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(inputPanel);
        this.add(buttonPanel);
        this.add(resultPanel);
    }

    public double getNum1Value() {
        return Double.valueOf(this.num1.getText());
    }

    public double getNum2Value() {
        return Double.valueOf(this.num2.getText());
    }

    public void setResult(double value) {
        resultLabel.setText("Result: " + value);
    }

    public void addCalculateListener(ActionListener listener) {
        this.addButton.addActionListener(listener);
        this.subtractButton.addActionListener(listener);
        this.multiplyButton.addActionListener(listener);
        this.divideButton.addActionListener(listener);
        this.powerButton.addActionListener(listener);
        this.squareButtonA.addActionListener(listener);
        this.squareButtonB.addActionListener(listener);
        this.minButton.addActionListener(listener);
        this.maxButton.addActionListener(listener);
    }
}
