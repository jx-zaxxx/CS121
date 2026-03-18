import javax.swing.JOptionPane;

public class RemoveGoal {

    public void remove(Account acc) {
        if (acc.getGoals().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No goals to remove.");
            return;
        }

        String msg = "";
        for (int i = 0; i < acc.getGoals().size(); i++) {
            Goal g = acc.getGoals().get(i);
            msg += (i + 1) + ". " + g.getPurpose() + " - ₱" + g.getTarget() + "\n";
        }

        String choice = JOptionPane.showInputDialog(
                "Select goal to remove:\n" + msg);

        if (choice == null) return;

        try {
            int index = Integer.parseInt(choice) - 1;
            if (acc.removeGoal(index)) {
                GoalFileHandler.updateGoals(acc);
                JOptionPane.showMessageDialog(null, "Goal removed.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }
}
