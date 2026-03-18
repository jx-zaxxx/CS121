import java.io.*;
import javax.swing.JOptionPane;

public class FileHandler {

    public static void saveAccount(String username, String password, double balance) {
        File input = new File("accounts.txt");
        File temp = new File("temp.txt");

        try {
            if (!input.exists()) input.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(input));
            PrintWriter pw = new PrintWriter(temp);

            String line;
            boolean updated = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    pw.println(username + "," + password + "," + balance);
                    updated = true;
                } else {
                    pw.println(line);
                }
            }

            if (!updated) {
                pw.println(username + "," + password + "," + balance);
            }

            br.close();
            pw.close();

            input.delete();
            temp.renameTo(input);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving account.");
        }
    }
}
