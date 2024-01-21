package Payment;

public class Payment {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentMethod) {
        this.amount = amount;
        this.paymentStrategy = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStrategy getPaymentMethod() {
        return paymentStrategy;
    }
}