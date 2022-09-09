import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class GUI<ActionEvent> implements ActionListener {
    public static JLabel amountlabel;
    public static JTextField amountText;
    public static JLabel ratelabel;
    public static JTextField rateText;
    public static JLabel yearslabel;
    public static JTextField yearsText;
    public static JButton button;
    public static JLabel operations;
    int monthInYear = 12;
    int percent = 100;
    float monthlyRate;
    int numberOfPayments;
    public static JLabel totalAmountLabel;

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Mortgage Calculator");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 200);
        frame.add(panel);

        panel.setLayout(null);

        amountlabel = new JLabel("Amount: ");
        amountlabel.setBounds(50, 20, 100, 50);
        panel.add(amountlabel);

        amountText = new JTextField(30);
        amountText.setBounds(220, 30, 350, 30);
        panel.add(amountText);

        ratelabel = new JLabel("Interest Rate: ");
        ratelabel.setBounds(50, 100, 80, 50);
        panel.add(ratelabel);

        rateText = new JTextField(30);
        rateText.setBounds(220, 110, 350, 30);
        panel.add(rateText);

        yearslabel = new JLabel("Period: ");
        yearslabel.setBounds(50, 180, 80, 50);
        panel.add(yearslabel);

        yearsText = new JTextField(30);
        yearsText.setBounds(220, 190, 350, 30);
        panel.add(yearsText);

        button = new JButton("Calculate");
        button.setBounds(250, 250, 150, 30);
        button.addActionListener(new GUI());
        panel.add(button);

        operations = new JLabel("");
        operations.setBounds(50, 300, 300, 30);
        panel.add(operations);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("hi");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        String amountStr = amountText.getText();
        String annualRateStr = rateText.getText();
        String yearsStr = yearsText.getText();
        int amount = Integer.parseInt(amountStr);
        float annualRate = Float.parseFloat(annualRateStr);
        int years = Integer.parseInt(yearsStr);

        while (true) {
            if (amount >= 1000 && amount <= 10000000) {
                break;
            } else {
                System.out.println("Please enter an amount between 1,000 and 10,000,000");
            }
        }

        while (true) {
            if (annualRate >= 1 && annualRate <= 15) {
                monthlyRate = annualRate / percent / monthInYear;
                break;
            } else {
                System.out.println("Please enter a valid interest rate.");
            }
        }

        while (true) {
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * monthInYear;
                break;
            } else {
                System.out.println("Please enter an number between 1 and 30.");
            }
        }
        double mortgage = amount * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        totalAmountLabel = new JLabel("Monthly payment: ");
        totalAmountLabel.setBounds(50, 350, 80, 50);
        panel.add(totalAmountLabel);

        float totalAmountPaid = (float) mortgage * monthInYear * years;
        String totalAmountPaidFormatted = NumberFormat.getCurrencyInstance().format(totalAmountPaid);
        System.out.println("Total amount paid to the bank in " + years + " years: " + totalAmountPaidFormatted);

        float InterestPaid = totalAmountPaid - amount;
        String InterestPaidFormatted = NumberFormat.getCurrencyInstance().format(InterestPaid);
        System.out.println("Total interest paid in " + years + " years: " + InterestPaidFormatted);

    }
}
