package Command;

import Order.Order;
import Payment.Payment;
import Payment.PaymentStrategy;

public class PayOrderCommand extends Command {
    private Order order;

    public PayOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        Payment payment = order.getPayment();

        if (payment != null) {
            double amountToPay = payment.getAmount();
            PaymentStrategy paymentStrategy = payment.getPaymentMethod();

            if (paymentStrategy != null) {
                // Process the payment using the specified strategy
                paymentStrategy.processPayment(amountToPay);
                System.out.println("Payment successful for the order.");
            } else {
                System.out.println("No payment strategy found for the order.");
            }
        } else {
            System.out.println("No payment details found for the order.");
        }
    }
}