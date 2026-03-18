import java.util.ArrayList;

public class Account {

    private String username;
    private String password;
    private double balance;

    private ArrayList<Goal> goals = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;

        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
        return true;
    }

    public void addGoal(Goal g) {
        goals.add(g);
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<Goal> list) {
        if (list != null) this.goals = list;
    }

    public boolean removeGoal(int index) {
        if (index < 0 || index >= goals.size()) return false;
        goals.remove(index);
        return true;
    }
}