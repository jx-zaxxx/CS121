import javax.swing.JOptionPane;

public class Deposit {
    public void depositMoney(Account acc) {

        String input = JOptionPane.showInputDialog("Enter amount:");
        if (input == null) return;

        try {
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid amount.");
                return;
            }

            acc.deposit(amount);

            JOptionPane.showMessageDialog(null,
                "Successfully deposited ₱" + amount +
                "\nNew Balance: ₱" + acc.getBalance());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Numbers only.");
        }
    }
}
