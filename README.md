# CodeSoft

# Task-1
# Number Game

## Description
The **Number Guessing Game GUI** is an interactive game built using Java Swing. In this game, the computer generates a random number between 1 and 100, and the user has to guess the number within a limited number of attempts. The game provides real-time feedback to help the player narrow down their guesses and eventually win the game.

The graphical user interface (GUI) is created using Java Swing, which provides a user-friendly and visually appealing experience. The game features the following:

- A label showing instructions to guess a number between 1 and 100.
- A text field to input guesses.
- Buttons for submitting guesses and playing a new round.
- A display showing the number of attempts remaining.
- A display showing the number of rounds won.

### Features:
- **Random Number Generation**: A random number is generated at the beginning of each round.
- **Guess Submission**: Players input their guesses and receive feedback whether the guess is too low, too high, or correct.
- **Rounds and Attempts**: The player has 5 attempts per round to guess the correct number.
- **Play Again**: After a correct guess or after the attempts are exhausted, the player can play another round.

## How to Play:
1. Upon starting the game, a random number between 1 and 100 is generated.
2. The player enters their guess in the text field and clicks the "Submit Guess" button.
3. The game informs the player whether their guess was too high, too low, or correct.
4. The player can continue guessing until the correct number is guessed or the attempts are exhausted.
5. After each round, the player can click the "Play Again" button to start a new round.

## How to Run:
1. Clone or download the repository.
2. Open the project in your preferred Java IDE (such as Eclipse, IntelliJ IDEA, etc.).
3. Compile and run the `NumberGuessingGameGUI.java` file.

## Technologies Used:
- **Java**: Programming language used for the game logic.
- **Java Swing**: GUI framework used for creating the user interface.









# Task-2
# ATM Interface

## Description
The **ATM Interface** is a Java-based graphical user interface (GUI) program simulating an ATM system. It allows users to perform basic banking operations such as checking account balance, withdrawing money, and depositing money. The program simulates an ATM environment by interacting with a user’s bank account, where they can perform these operations and receive appropriate feedback.

The GUI provides the user with options to select actions and input amounts, and it validates the input to ensure proper transactions. Each transaction is connected to the user's bank account, which stores and updates the balance after every deposit or withdrawal.

### Features:
- **Withdraw**: The user can withdraw a specified amount, provided their balance is sufficient.
- **Deposit**: The user can deposit a specified amount into their account.
- **Check Balance**: The user can view their current account balance.
- **Input Validation**: Ensures that users cannot withdraw more than their balance or input invalid data.

### User Interface:
The GUI consists of the following:
- **Buttons** for withdrawing, depositing, and checking the balance.
- **Text fields** for inputting withdrawal and deposit amounts.
- **Labels** to display messages such as account balance and transaction results.
- **Feedback** after each action to show the success or failure of the operation.

## How to Use:
1. Start the program and interact with the ATM interface.
2. Choose an action (Withdraw, Deposit, Check Balance) by clicking the appropriate button.
3. If withdrawing or depositing, input the amount and submit it.
4. The current balance will be updated after each transaction, and feedback will be displayed.

## How to Run:
1. Clone or download the repository.
2. Open the project in your preferred Java IDE (such as Eclipse, IntelliJ IDEA, etc.).
3. Compile and run the `ATMInterface.java` file to start the program.

## Technologies Used:
- **Java**: Programming language used for both the logic and GUI components.
- **Java Swing**: GUI framework for creating the interactive user interface.






# Task-3
# Currency Converter

## Description
The **Currency Converter** is a Java-based graphical user interface (GUI) program that allows users to convert an amount from one currency to another using real-time exchange rates. It fetches exchange rates via an external API and performs the conversion based on the selected base and target currencies.

Users can select the base currency (the currency they want to convert from) and the target currency (the currency they want to convert to). The program allows the user to input the amount to be converted and displays the converted amount in the selected target currency.

### Features:
- **Currency Selection**: Choose from a range of currencies (USD, EUR, INR, GBP, JPY, AUD, CAD).
- **Real-time Exchange Rates**: Fetches live exchange rates from an external API to provide accurate conversions.
- **Amount Input**: Allows users to input the amount they want to convert.
- **Currency Conversion**: Converts the input amount from the base currency to the target currency based on the fetched exchange rate.
- **Error Handling**: Displays appropriate error messages if the user enters invalid data or if the API request fails.

### User Interface:
The GUI consists of:
- **Dropdown menus** to select the base and target currencies.
- **Text field** for entering the amount to be converted.
- **Convert button** to perform the conversion.
- **Result label** to display the converted amount.

## How to Use:
1. Start the program and select the base and target currencies.
2. Enter the amount you wish to convert in the provided text field.
3. Click the "Convert" button to perform the conversion.
4. The converted amount will be displayed along with the target currency symbol.

## How to Run:
1. Clone or download the repository.
2. Open the project in your preferred Java IDE (such as Eclipse, IntelliJ IDEA, etc.).
3. Compile and run the `CurrencyConverter.java` file to start the program.

## Technologies Used:
- **Java**: Programming language used for both the logic and GUI components.
- **Java Swing**: GUI framework for creating the interactive user interface.
- **External API**: Fetches real-time exchange rates for conversion.


