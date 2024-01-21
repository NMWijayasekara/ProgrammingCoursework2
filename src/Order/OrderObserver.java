package Order;

public class OrderObserver {
    public void update(Order order) {
        System.out.println(order.getCurrentState());
    }

}