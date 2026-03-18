import javax.swing.JOptionPane;

public class Start {

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        Manager manager = new Manager();

        String menu = JOptionPane.showInputDialog(
                "1. Login Account\n" +
                "2. Register Account\n" +
                "3. Exit program");

        if (menu == null) {
            showMenu();
            return;
        }

        switch (menu) {
            case "1":
                Account acc = manager.login();
                if (acc != null) {
                    Main.showMainMenu(acc);  
                }
                showMenu();
                break;

            case "2":
                manager.register();
                showMenu();
                break;

            case "3":
                JOptionPane.showMessageDialog(null, "Exiting the program :(");
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice.");
                showMenu();
        }
    }
}
