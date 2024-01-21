package Payment;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(double amount) {
        // Implement credit card payment processing logic
        System.out.println("Processing credit card payment of $" + amount + " using card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }
}