import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.io.BufferedReader;
import java.io.FileReader;

public class Manager {

    public Account login() {

    String user = askInput("Enter username: ");
    if (user == null) return null;

    JPasswordField passwordField = new JPasswordField();

    int option = JOptionPane.showConfirmDialog(
            null,
            passwordField,
            "Enter password:",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
    );

    if (option != JOptionPane.OK_OPTION) return null;

    String pass = new String(passwordField.getPassword());

    Account acc = loadAccount(user, pass);

    if (acc != null) {
        JOptionPane.showMessageDialog(null, "Login successful!");
        return acc;
    } else {
        JOptionPane.showMessageDialog(null, "Invalid username or password.");
        return null;
    }
}

    public void register() {
        String user = askInput("Enter username: ");
        if (user == null) return;

        if (usernameExists(user)) {
            JOptionPane.showMessageDialog(null, "Username already exists! Try another.");
            register();
            return;
        }

        String pass = askInput("Enter password: ");
        if (pass == null) return;

        FileHandler.saveAccount(user, pass, 0.0);
        JOptionPane.showMessageDialog(null, "Account Created!");
    }

    private String askInput(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);

            if (input == null)
                return null;

            if (!input.trim().equals(""))
                return input;

            JOptionPane.showMessageDialog(null, "Input cannot be empty.");
        }
    }

    private Account loadAccount(String username, String password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("accounts.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    if (parts[0].equals(username) && parts[1].equals(password)) {
                        double balance = Double.parseDouble(parts[2]);
                        br.close();

                        Account acc = new Account(username, password, balance);
                        acc.setGoals(GoalFileHandler.loadGoals(username));
                        return acc;
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading account.");
        }

        return null;
    }

    private boolean usernameExists(String username) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("accounts.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(username)) {
                    br.close();
                    return true;
                }
            }

            br.close();
        } catch (Exception ignored) {}

        return false;
    }
}
