import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;

public class MonthlyReport {

    public void generate(Account currentUser) {

        String report = "";

        report += "===== MONTHLY REPORT =====\n\n";
        report += "Username: " + currentUser.getUsername() + "\n";
        report += "Current Balance: ₱" + currentUser.getBalance() + "\n\n";

        report += "===== TRANSACTION HISTORY =====\n\n";

        if (currentUser.getTransactions().size() == 0) {
            report += "No transactions this month.\n";
        } else {

            for (int i = 0; i < currentUser.getTransactions().size(); i++) {

                Transaction t = currentUser.getTransactions().get(i);

                report += (i + 1) + ". ";
                report += t.getType() + " - ₱" + t.getAmount() + "\n";
            }
        }

        try {
            FileWriter writer = new FileWriter(
                    "MonthlyReport_" + currentUser.getUsername() + ".txt");

            writer.write(report);
            writer.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving report.");
        }

        JOptionPane.showMessageDialog(null, report);
    }
}