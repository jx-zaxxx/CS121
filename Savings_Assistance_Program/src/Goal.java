public class Goal {
    private String purpose;
    private double target;

    public Goal(String purpose, double target) {
        this.purpose = purpose;
        this.target = target;
    }

    public String getPurpose() {
        return purpose;
    }

    public double getTarget() {
        return target;
    }
}
