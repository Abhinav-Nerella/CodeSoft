import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> baseCurrency, targetCurrency;
    private JTextField amountField;
    private JLabel resultLabel;
    private JButton convertButton;

    private static final String API_KEY = "bc8d4bb8fcae5ae216045f51"; 
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(44, 62, 80));

        JLabel baseLabel = new JLabel("Base Currency:");
        baseLabel.setForeground(Color.WHITE);
        panel.add(baseLabel);

        baseCurrency = new JComboBox<>(new String[]{"USD $", "EUR €", "INR ₹", "GBP £", "JPY ¥", "AUD A$", "CAD C$"});
        panel.add(baseCurrency);

        JLabel targetLabel = new JLabel("Target Currency:");
        targetLabel.setForeground(Color.WHITE);
        panel.add(targetLabel);

        targetCurrency = new JComboBox<>(new String[]{"USD $", "EUR €", "INR ₹", "GBP £", "JPY ¥", "AUD A$", "CAD C$"});
        panel.add(targetCurrency);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setForeground(Color.WHITE);
        panel.add(amountLabel);

        amountField = new JTextField();
        panel.add(amountField);

        convertButton = new JButton("Convert");
        styleButton(convertButton);
        panel.add(convertButton);

        resultLabel = new JLabel("Converted Amount: ");
        resultLabel.setForeground(Color.YELLOW);
        panel.add(resultLabel);

        add(panel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        setVisible(true);
    }

    private void convertCurrency() {
        try {
            String base = getCurrencyCode((String) baseCurrency.getSelectedItem());
            String target = getCurrencyCode((String) targetCurrency.getSelectedItem());
            double amount = Double.parseDouble(amountField.getText());

            if (base == null || target == null || amountField.getText().isEmpty()) {
                resultLabel.setText("Please fill in all fields.");
                return;
            }

            double exchangeRate = getExchangeRate(base, target);
            double convertedAmount = amount * exchangeRate;

            resultLabel.setText("Converted Amount: " + String.format("%.2f", convertedAmount) + " " + target);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Invalid amount entered.");
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    private double getExchangeRate(String base, String target) throws Exception {
        URL url = new URL(API_URL + base);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int statusCode = connection.getResponseCode();
        if (statusCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Failed to fetch data. HTTP Error Code: " + statusCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String responseString = response.toString();

        String targetRateKey = "\"" + target + "\":";
        int startIndex = responseString.indexOf(targetRateKey);
        if (startIndex == -1) {
            throw new Exception("Target currency not found in the response.");
        }

        startIndex += targetRateKey.length();
        int endIndex = responseString.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = responseString.indexOf("}", startIndex);
        }

        String rateString = responseString.substring(startIndex, endIndex).trim();
        return Double.parseDouble(rateString);
    }

    private String getCurrencyCode(String currency) {
        return currency.split(" ")[0];
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}



