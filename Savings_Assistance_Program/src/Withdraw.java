import javax.swing.JOptionPane;

public class Withdraw {

    public void withdrawMoney(Account acc) {

        String input = JOptionPane.showInputDialog("Enter amount:");
        if (input == null) return;

        try {
            double amount = Double.parseDouble(input);

            if (amount <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid amount.");
                return;
            }

            if (amount > acc.getBalance()) {
                JOptionPane.showMessageDialog(null,
                        "Insufficient funds.\nYour balance is ₱" + acc.getBalance());
                return;
            }

            acc.withdraw(amount);

            JOptionPane.showMessageDialog(null,
                "Successfully withdrew ₱" + amount +
                "\nNew Balance: ₱" + acc.getBalance());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Numbers only.");
        }
    }
}
