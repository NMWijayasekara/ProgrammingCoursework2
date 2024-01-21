package State;

import Order.Order;

public class PreparationOrderState implements OrderState {
    @Override
    public void handleState(Order context) {
        System.out.println("Order is being prepared");
    }
}
