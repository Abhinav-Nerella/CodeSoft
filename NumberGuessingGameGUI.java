import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class NumberGuessingGameGUI extends JFrame {
    private int randomNumber;
    private int attemptsLeft = 5;
    private int roundsWon = 0;

    private JLabel messageLabel, attemptsLabel, scoreLabel;
    private JTextField guessField;
    private JButton guessButton, playAgainButton;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(44, 62, 80));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("🎯 Number Guessing Game");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        messageLabel = new JLabel("Guess a number between 1 and 100:");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(messageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        guessField = new JTextField(10);
        guessField.setMaximumSize(new Dimension(200, 30));
        guessField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(guessField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        guessButton = new JButton("Submit Guess");
        styleButton(guessButton);
        panel.add(guessButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft);
        attemptsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        attemptsLabel.setForeground(Color.LIGHT_GRAY);
        attemptsLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(attemptsLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        scoreLabel = new JLabel("Rounds won: " + roundsWon);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setForeground(Color.LIGHT_GRAY);
        scoreLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(scoreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        playAgainButton = new JButton("Play Again");
        styleButton(playAgainButton);
        playAgainButton.setEnabled(false);
        panel.add(playAgainButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        add(panel);
        generateNewNumber();

        guessButton.addActionListener(e -> checkGuess());
        playAgainButton.addActionListener(e -> resetGame());

        setVisible(true);
    }

    private void generateNewNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            if (userGuess < 1 || userGuess > 100) {
                messageLabel.setText("⚠️ Enter a number between 1 and 100!");
                return;
            }

            attemptsLeft--;

            if (userGuess == randomNumber) {
                messageLabel.setText("🎉 Correct! You won this round.");
                roundsWon++;
                scoreLabel.setText("Rounds won: " + roundsWon);
                endGame();
            } else if (userGuess < randomNumber) {
                messageLabel.setText("🔼 Too low! Try again.");
            } else {
                messageLabel.setText("🔽 Too high! Try again.");
            }

            attemptsLabel.setText("Attempts left: " + attemptsLeft);

            if (attemptsLeft == 0) {
                messageLabel.setText("😢 No attempts left! The number was " + randomNumber);
                endGame();
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("❌ Please enter a valid number!");
        }
        guessField.setText("");
    }

    private void endGame() {
        guessButton.setEnabled(false);
        playAgainButton.setEnabled(true);
    }

    private void resetGame() {
        attemptsLeft = 5;
        generateNewNumber();
        guessButton.setEnabled(true);
        playAgainButton.setEnabled(false);
        messageLabel.setText("Guess a number between 1 and 100:");
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
        guessField.setText("");
    }

    private void styleButton(JButton button) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}

