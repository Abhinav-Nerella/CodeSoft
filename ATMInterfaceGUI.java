import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void checkBalance(JLabel balanceLabel) {
        balanceLabel.setText("Current balance: $" + String.format("%.2f", balance));
    }
}

public class ATMInterfaceGUI extends JFrame {
    private BankAccount account;
    private JTextField amountField;
    private JLabel balanceLabel;
    private JButton depositButton, withdrawButton, checkBalanceButton;

    public ATMInterfaceGUI() {
        account = new BankAccount(1000);
        setTitle("ATM Interface");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBackground(new Color(44, 62, 80));

        JLabel amountLabel = new JLabel("Enter Amount: ");
        amountLabel.setForeground(Color.WHITE);
        panel.add(amountLabel);

        amountField = new JTextField();
        panel.add(amountField);

        depositButton = new JButton("Deposit");
        depositButton.setBackground(new Color(52, 152, 219));
        depositButton.setForeground(Color.WHITE);
        panel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(52, 152, 219));
        withdrawButton.setForeground(Color.WHITE);
        panel.add(withdrawButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBackground(new Color(52, 152, 219));
        checkBalanceButton.setForeground(Color.WHITE);
        panel.add(checkBalanceButton);

        balanceLabel = new JLabel("");
        balanceLabel.setForeground(Color.WHITE);
        panel.add(balanceLabel);

        add(panel);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleWithdraw();
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account.checkBalance(balanceLabel);
            }
        });

        setVisible(true);
    }

    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                account.deposit(amount);
                JOptionPane.showMessageDialog(this, "Successfully deposited: $" + String.format("%.2f", amount));
                amountField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a positive amount.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.");
        }
    }

    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0 && account.withdraw(amount)) {
                JOptionPane.showMessageDialog(this, "Successfully withdrawn: $" + String.format("%.2f", amount));
                amountField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds or invalid amount.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new ATMInterfaceGUI();
    }
}



