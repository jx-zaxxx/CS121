import javax.swing.JOptionPane;

public class ViewGoalProgress {

    public void showGoal(Account acc) {

        if (acc.getGoals().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have no goals set.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Goal g : acc.getGoals()) {
            double progress = (acc.getBalance() / g.getTarget()) * 100;
            if (progress > 100) progress = 100;

            sb.append("Purpose: ").append(g.getPurpose()).append("\n");
            sb.append("Target: ₱").append(g.getTarget()).append("\n");
            sb.append("Progress: ").append(String.format("%.2f", progress)).append("%\n");
            sb.append("---------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}