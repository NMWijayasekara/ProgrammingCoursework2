package State;

import Order.Order;

public class DeliveryOrderState implements OrderState {
    @Override
    public void handleState(Order context) {
        System.out.println("Order is one delivery");
    }
}