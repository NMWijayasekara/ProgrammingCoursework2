package State;

import Order.Order;

public interface OrderState {
    void handleState(Order context);
}
