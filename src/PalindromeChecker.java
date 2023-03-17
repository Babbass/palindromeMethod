import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeChecker extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel outputLabel;
    private JButton checkButton;

    public PalindromeChecker() {
        super("Palindrome Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputField = new JTextField(10);
        add(new JLabel("Enter a number:"));
        add(inputField);

        checkButton = new JButton("Check");
        checkButton.addActionListener(this);
        add(checkButton);

        outputLabel = new JLabel();
        add(outputLabel);

        setSize(350, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String inputStr = inputField.getText();
        try {
            int inputNum = Integer.parseInt(inputStr);
            if (isPalindrome(inputNum)) {
                outputLabel.setText(inputNum + " is a palindrome.");
            } else {
                outputLabel.setText(inputNum + " is not a palindrome.");
            }
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input. Please enter a valid integer.");
        }
    }

    private boolean isPalindrome(int num) {
        int reversed = 0, remainder, original = num;
        while (num > 0) {
            remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num = num / 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        new PalindromeChecker();
    }
}
