import javax.swing.JOptionPane;

public class SetGoal {

    public void setGoal(Account acc) {

        String purpose = JOptionPane.showInputDialog("Enter purpose:");
        if (purpose == null || purpose.trim().equals("")) return;

        double target;
        try {
            target = Double.parseDouble(
                JOptionPane.showInputDialog("Enter target amount ₱")
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid amount.");
            return;
        }

        Goal g = new Goal(purpose, target);

        acc.addGoal(g); 
        GoalFileHandler.saveGoal(acc.getUsername(), g);

        JOptionPane.showMessageDialog(null, "Goal saved!");
    }
}