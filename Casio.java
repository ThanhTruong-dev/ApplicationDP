package Loi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Casio extends JFrame implements ActionListener {

    public static JButton button1 = new JButton("1");
    public static JButton button2 = new JButton("2");
    public static JButton button3 = new JButton("3");
    public static JButton button4 = new JButton("4");
    public static JButton button5 = new JButton("5");
    public static JButton button6 = new JButton("6");
    public static JButton button7 = new JButton("7");
    public static JButton button8 = new JButton("8");
    public static JButton button9 = new JButton("9");
    public static JButton buttonSum = new JButton("+");
    public static JButton buttonSub = new JButton("-");
    public static JButton buttonMul = new JButton("x");
    public static JButton buttonDiv = new JButton("/");
    public static JButton buttonResult = new JButton("=");
    public static JButton buttonReset = new JButton("C");

    public static JLabel label = new JLabel("");

    private String firstNumber = "";
    private String operator = "";
    private String secondNumber = "";

    public Casio() {
        JFrame frame = new JFrame();
        frame.setTitle("Casio");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonSum.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonResult.addActionListener(this);
        buttonReset.addActionListener(this);

        JPanel panelNumber = new JPanel();
        panelNumber.setLayout(new GridLayout(3, 3));
        panelNumber.add(button1);
        panelNumber.add(button2);
        panelNumber.add(button3);
        panelNumber.add(button4);
        panelNumber.add(button5);
        panelNumber.add(button6);
        panelNumber.add(button7);
        panelNumber.add(button8);
        panelNumber.add(button9);

        JPanel panelFunction = new JPanel();
        panelFunction.setLayout(new GridLayout(3, 2));
        panelFunction.add(buttonSum);
        panelFunction.add(buttonSub);
        panelFunction.add(buttonMul);
        panelFunction.add(buttonDiv);
        panelFunction.add(buttonResult);
        panelFunction.add(buttonReset);

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(panelNumber, BorderLayout.CENTER);
        frame.add(panelFunction, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Casio casio = new Casio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1 || e.getSource() == button2 || e.getSource() == button3
                || e.getSource() == button4 || e.getSource() == button5 || e.getSource() == button6
                || e.getSource() == button7 || e.getSource() == button8 || e.getSource() == button9) {

            String text = label.getText() + ((JButton) e.getSource()).getText();
            label.setText(text);

        } else if (e.getSource() == buttonSum || e.getSource() == buttonSub
                || e.getSource() == buttonMul || e.getSource() == buttonDiv) {
            firstNumber = label.getText();
            operator = ((JButton) e.getSource()).getText();
            label.setText("");

        } else if (e.getSource() == buttonResult) {
            secondNumber = label.getText();
            double result = 0;

            try {
                double num1 = Double.parseDouble(firstNumber);
                double num2 = Double.parseDouble(secondNumber);
                
                switch (operator) {
                    case "+":
                        result = num1 + num2 + 1; // Cộng luôn sai
                        break;
                    case "-":
                        result = Math.abs(num1 - num2); // Luôn trả về số dương
                        break;
                    case "x":
                        result = (num1 * num2) - 1; // Nhân luôn sai
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = (num1 / num2) + 1; // Chia luôn sai
                        } else {
                            label.setText("Error");
                            return;
                        }
                        break;
                }
            } catch (Exception ex) {
                label.setText("Error");
                return;
            }
            
            label.setText(String.valueOf(result));
        }
        
        if (e.getSource() == buttonReset) {
            label.setText("");
        }
    }
}
