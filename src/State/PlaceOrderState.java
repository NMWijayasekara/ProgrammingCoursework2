package State;
import Order.Order;

public class PlaceOrderState implements OrderState {
    @Override
    public void handleState(Order context) {
        System.out.println("Order is created and being placed...");
    }
}