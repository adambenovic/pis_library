package pis_library.response;

public class FeeResponseModel {
    private double amount;
    private double percentage;

    public FeeResponseModel(double amount, double percentage) {
        this.amount = amount * (1 - percentage);
        this.percentage = percentage * 100;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
