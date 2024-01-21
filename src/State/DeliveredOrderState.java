package State;

import Order.Order;

public class DeliveredOrderState implements OrderState {
    @Override
    public void handleState(Order context) {
        System.out.println("Order placed. Please confirm your order.");
    }
}