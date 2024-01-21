package Payment;

class DigitalWalletPayment implements PaymentStrategy {
    private String walletId;

    public DigitalWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void processPayment(double amount) {
        // Implement digital wallet payment processing logic
        System.out.println("Processing digital wallet payment of $" + amount + " using wallet ID " + walletId);
    }
}