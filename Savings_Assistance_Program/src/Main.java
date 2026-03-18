import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Start.main(args);
    }

    public static void showMainMenu(Account currentUser) {

        while (true) {
            String menu = JOptionPane.showInputDialog(
                "1. Deposit\n" +
                "2. Withdraw\n" +
                "3. View Balance\n" +
                "4. Set Goal\n" +
                "5. View Goal Progress\n" +
                "6. Generate Monthly Report\n" +
                "7. Remove Goal\n" +
                "8. Logout\n" +
                "9. Exit Program"
            );

            if (menu == null) continue;

            switch (menu) {

                case "1":
                    new Deposit().depositMoney(currentUser);
                    break;

                case "2":
                    new Withdraw().withdrawMoney(currentUser);
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,
                        "Current Balance: ₱" + currentUser.getBalance());
                    break;

                case "4":
                    new SetGoal().setGoal(currentUser);
                    break;

                case "5":
                    new ViewGoalProgress().showGoal(currentUser);
                    break;

                case "6":
                    new MonthlyReport().generate(currentUser);
                    break;

                case "7":
                    new RemoveGoal().remove(currentUser);
                    break;

                case "8":
                    FileHandler.saveAccount(
                        currentUser.getUsername(),
                        currentUser.getPassword(),
                        currentUser.getBalance()
                    );
                    JOptionPane.showMessageDialog(null, "Logging out...");
                    return;

                case "9":
                    JOptionPane.showMessageDialog(null, "Exiting the program :(");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
            }

            FileHandler.saveAccount(
                currentUser.getUsername(),
                currentUser.getPassword(),
                currentUser.getBalance()
            );
        }
    }
}
