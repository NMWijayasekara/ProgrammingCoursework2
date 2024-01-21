package State;

import Order.Order;

public class PayOrderState implements OrderState {
    @Override
    public void handleState(Order context) {
        System.out.println("Accept Order Payment");
    }
}
