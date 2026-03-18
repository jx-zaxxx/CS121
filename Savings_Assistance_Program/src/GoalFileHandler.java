import java.io.*;
import java.util.ArrayList;

public class GoalFileHandler {

    public static void saveGoal(String username, Goal g) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("goals.txt", true));
            pw.println(username + "," + g.getPurpose() + "," + g.getTarget());
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving goal.");
        }
    }

    public static ArrayList<Goal> loadGoals(String username) {
        ArrayList<Goal> list = new ArrayList<>();

        try {
            File f = new File("goals.txt");
            if (!f.exists()) return list;

            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", 3);
                if (p[0].equals(username)) {
                    list.add(new Goal(p[1], Double.parseDouble(p[2])));
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error loading goals.");
        }

        return list;
    }

    public static void updateGoals(Account acc) {
        try {
            File f = new File("goals.txt");
            if (!f.exists()) f.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(f));
            PrintWriter pw = new PrintWriter(new FileWriter("goals_temp.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", 3);
                if (!p[0].equals(acc.getUsername())) {
                    pw.println(line);
                }
            }

            for (Goal g : acc.getGoals()) {
                pw.println(acc.getUsername() + "," + g.getPurpose() + "," + g.getTarget());
            }

            br.close();
            pw.close();

            File oldFile = new File("goals.txt");
            File newFile = new File("goals_temp.txt");

            oldFile.delete();
            newFile.renameTo(oldFile);

        } catch (Exception e) {
            System.out.println("Error updating goals.");
        }
    }
}
