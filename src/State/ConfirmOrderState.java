package State;

import Order.Order;

public class ConfirmOrderState implements OrderState {
    @Override
    public void handleState(Order context) {
        System.out.println("Order confirmed and set!");
    }
}