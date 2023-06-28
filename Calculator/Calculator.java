import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 40, 240, 30);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons = new JButton[]{addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton};
        for (JButton button : functionButtons) {
            button.addActionListener(new ButtonClickListener());
            button.setFont(new Font("Arial", Font.PLAIN, 18));
        }

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new ButtonClickListener());
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }

        delButton.setBounds(40, 280, 100, 40);
        clrButton.setBounds(150, 280, 100, 40);

        panel = new JPanel();
        panel.setBounds(40, 100, 210, 150);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source == delButton) {
                String currentText = textField.getText();
                if (!currentText.isEmpty()) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (source == clrButton) {
                textField.setText("");
            } else if (source == equButton) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            } else {
                for (int i = 0; i < 10; i++) {
                    if (source == numberButtons[i]) {
                        textField.setText(textField.getText().concat(String.valueOf(i)));
                    }
                }
                if (source == addButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '+';
                    textField.setText("");
                }
                if (source == subButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '-';
                    textField.setText("");
                }
                if (source == mulButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '*';
                    textField.setText("");
                }
                if (source == divButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '/';
                    textField.setText("");
                }
                if (source == decButton) {
                    if (!textField.getText().contains(".")) {
                        textField.setText(textField.getText().concat("."));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
